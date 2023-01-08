package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.FbCategoryDto;
import com.example.simpledms.model.community.Fb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.simpledms.repository
 * fileName : FbRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Repository
public interface FbRepository extends JpaRepository<Fb, Integer> {


    // 카테고리 선택 후 검색 조회 쿼리
    // TODO : 게시판 날짜 계산 수정된 쿼리!!! (2023-01-08 유슬기)
    @Query(value = "select f.fno, c.fb_ctitle as fbCtitle, f.fb_title as fbTitle, f.fb_content, f.nick, f.fb_cnt as fbCnt, " +
            "case when substr(f.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(f.insert_time, 6,5)) " +
            "else (substr(f.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_fb f, tb_fb_category c " +
            "where f.fb_category = c.fb_cid " +
            "and c.fb_ctitle like %:fb_ctitle% " +
            "and f.fb_title like %:fb_title% " +
            "and f.delete_yn = 'N' " +
            "order by f.fno desc "
            , countQuery =  "select f.fno, c.fb_ctitle as fbCtitle, f.fb_title as fbTitle, f.fb_content, f.nick, f.fb_cnt as fbCnt, " +
            "case when substr(f.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(f.insert_time, 6,5)) " +
            "else (substr(f.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_fb f, tb_fb_category c " +
            "where f.fb_category = c.fb_cid " +
            "and c.fb_ctitle like %:fb_ctitle% " +
            "and f.fb_title like %:fb_title% " +
            "and f.delete_yn = 'N' " +
            "order by f.fno desc "
            , nativeQuery = true)
    Page<FbCategoryDto> selectSearchAndKeywordSearch(@Param("fb_ctitle") String fb_ctitle,
                                                     @Param("fb_title") String fb_title,
                                                     Pageable pageable);


    // 상세페이지 클릭시 조회수 1상승 쿼리
    @Modifying
    @Query(value = "update tb_fb f " +
            "set f.fb_cnt = f.fb_cnt + 1 " +
            "where f.fno = :fno "
            , countQuery = "select count(*) " +
            "update tb_fb f " +
            "set f.fb_cnt = f.fb_cnt + 1 " +
            "where f.fno = :fno "
            , nativeQuery = true)
    int updateCnt(@Param("fno") Integer fno);

    // 조회수 Best 5 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select f.* from tb_fb f order by f.fb_cnt desc ) where ROWNUM <= 5 "
            , nativeQuery = true)
    List<Fb> boardBestList() ;

    // 최신순 6 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select f.* from tb_fb f order by f.fno desc ) where ROWNUM <= 6 "
            , nativeQuery = true)
    List<Fb> boardDescList() ;
}
