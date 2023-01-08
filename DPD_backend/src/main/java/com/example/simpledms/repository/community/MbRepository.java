package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.MbCategoryDto;
import com.example.simpledms.dto.community.MbCategoryDto;
import com.example.simpledms.dto.community.MbCategoryDto;
import com.example.simpledms.model.community.Mb;
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
 * fileName : MbRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Repository
public interface MbRepository extends JpaRepository<Mb, Integer> {

    // 카테고리 선택 후 검색 조회 쿼리
    // TODO : 게시판 날짜 계산 수정된 쿼리!!! (2023-01-08 유슬기)
    @Query(value = "select m.mno, c.mb_ctitle as mbCtitle, m.mb_title as mbTitle, m.mb_content, m.nick, m.mb_cnt as mbCnt, " +
            "case when substr(m.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(m.insert_time, 6,5)) " +
            "else (substr(m.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_mb m, tb_mb_category c " +
            "where m.mb_category = c.mb_cid " +
            "and c.mb_ctitle like %:mb_ctitle% " +
            "and m.mb_title like %:mb_title% " +
            "and m.delete_yn = 'N' " +
            "order by m.mno desc "
            , countQuery =  "select m.mno, c.mb_ctitle as mbCtitle, m.mb_title as mbTitle, m.mb_content, m.nick, m.mb_cnt as mbCnt, " +
            "case when substr(m.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(m.insert_time, 6,5)) " +
            "else (substr(m.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_mb m, tb_mb_category c " +
            "where m.mb_category = c.mb_cid " +
            "and c.mb_ctitle like %:mb_ctitle% " +
            "and m.mb_title like %:mb_title% " +
            "and m.delete_yn = 'N' " +
            "order by m.mno desc "
            , nativeQuery = true)
    Page<MbCategoryDto> selectSearchAndKeywordSearch(@Param("mb_ctitle") String mb_ctitle,
                                                     @Param("mb_title") String mb_title,
                                                     Pageable pageable);
    // 상세페이지 클릭시 조회수 1상승 쿼리
    @Modifying
    @Query(value = "update tb_mb m " +
            "set m.mb_cnt = m.mb_cnt + 1 " +
            "where m.mno = :mno "
            , countQuery = "select count(*) " +
            "update tb_mb m " +
            "set m.mb_cnt = m.mb_cnt + 1 " +
            "where m.mno = :mno "
            , nativeQuery = true)
    int updateCnt(@Param("mno") Integer mno);

    // 조회수 Best 5 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select m.* from tb_mb m order by m.mb_cnt desc ) where ROWNUM <= 5 "
            , nativeQuery = true)
    List<Mb> boardBestList() ;

    // 최신순 6 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select m.* from tb_mb m order by m.mno desc ) where ROWNUM <= 6 "
            , nativeQuery = true)
    List<Mb> boardDescList() ;
}
