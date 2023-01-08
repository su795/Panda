package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbCategoryDto;
import com.example.simpledms.dto.community.BbCategoryDto;
import com.example.simpledms.dto.community.BbCategoryDto;
import com.example.simpledms.model.community.Bb;
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
 * fileName : BbRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Repository
public interface BbRepository extends JpaRepository<Bb, Integer> {


    // 카테고리 선택 후 검색 조회 쿼리
    // TODO : 게시판 날짜 계산 수정된 쿼리!!! (2023-01-08 유슬기)
    @Query(value = "select b.bno, c.bb_ctitle as bbCtitle, b.bb_title as bbTitle, b.bb_content, b.nick, b.bb_cnt as bbCnt, " +
            "case when substr(b.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(b.insert_time, 6,5)) " +
            "else (substr(b.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_bb b, tb_bb_category c " +
            "where b.bb_category = c.bb_cid " +
            "and c.bb_ctitle like %:bb_ctitle% " +
            "and b.bb_title like %:bb_title% " +
            "and b.delete_yn = 'N' " +
            "order by b.bno desc "
            , countQuery =  "select b.bno, c.bb_ctitle as bbCtitle, b.bb_title as bbTitle, b.bb_content, b.nick, b.bb_cnt as bbCnt, " +
            "case when substr(b.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(b.insert_time, 6,5)) " +
            "else (substr(b.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_bb b, tb_bb_category c " +
            "where b.bb_category = c.bb_cid " +
            "and c.bb_ctitle like %:bb_ctitle% " +
            "and b.bb_title like %:bb_title% " +
            "and b.delete_yn = 'N' " +
            "order by b.bno desc "
            , nativeQuery = true)
    Page<BbCategoryDto> selectSearchAndKeywordSearch(@Param("bb_ctitle") String bb_ctitle,
                                                     @Param("bb_title") String bb_title,
                                                     Pageable pageable);

    @Modifying
    @Query(value = "update tb_bb b " +
            "set b.bb_cnt = b.bb_cnt + 1 " +
            "where b.bno = :bno "
            , countQuery = "select count(*) " +
            "update tb_bb b " +
            "set b.bb_cnt = b.bb_cnt + 1 " +
            "where b.bno = :bno "
            , nativeQuery = true)
    int updateCnt(@Param("bno") Integer bno);

    // 조회수 Best 5 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select b.* from tb_bb b order by b.bb_cnt desc ) where ROWNUM <= 5 "
            , nativeQuery = true)
    List<Bb> boardBestList() ;

    // 최신순 6 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select b.* from tb_bb b order by b.bno desc ) where ROWNUM <= 6 "
            , nativeQuery = true)
    List<Bb> boardDescList() ;
}
