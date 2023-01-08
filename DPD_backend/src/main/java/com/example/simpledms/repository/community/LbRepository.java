package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.LbCategoryDto;
import com.example.simpledms.dto.community.LbCategoryDto;
import com.example.simpledms.dto.community.LbCategoryDto;
import com.example.simpledms.model.community.Lb;
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
 * fileName : LbRepository
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Repository
public interface LbRepository extends JpaRepository<Lb, Integer> {

    // 카테고리 선택 후 검색 조회 쿼리
    // TODO : 게시판 날짜 계산 수정된 쿼리!!! (2023-01-08 유슬기)
    @Query(value = "select l.lno, c.lb_ctitle as lbCtitle, l.lb_title as lbTitle, l.lb_content, l.nick, l.lb_cnt as lbCnt, " +
            "case when substr(l.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(l.insert_time, 6,5)) " +
            "else (substr(l.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_lb l, tb_lb_category c " +
            "where l.lb_category = c.lb_cid " +
            "and c.lb_ctitle like %:lb_ctitle% " +
            "and l.lb_title like %:lb_title% " +
            "and l.delete_yn = 'N' " +
            "order by l.lno desc "
            , countQuery =  "select l.lno, c.lb_ctitle as lbCtitle, l.lb_title as lbTitle, l.lb_content, l.nick, l.lb_cnt as lbCnt, " +
            "case when substr(l.insert_time, 1, 10) < to_char(sysdate, 'YYYY-MM-DD') then (substr(l.insert_time, 6,5)) " +
            "else (substr(l.insert_time, 11, 9)) " +
            "end as insertTime " +
            "from tb_lb l, tb_lb_category c " +
            "where l.lb_category = c.lb_cid " +
            "and c.lb_ctitle like %:lb_ctitle% " +
            "and l.lb_title like %:lb_title% " +
            "and l.delete_yn = 'N' " +
            "order by l.lno desc "
            , nativeQuery = true)
    Page<LbCategoryDto> selectSearchAndKeywordSearch(@Param("lb_ctitle") String lb_ctitle,
                                                     @Param("lb_title") String lb_title,
                                                     Pageable pageable);

    // 상세페이지 클릭시 조회수 1상승 쿼리
    @Modifying
    @Query(value = "update tb_lb l " +
            "set l.lb_cnt = l.lb_cnt + 1 " +
            "where l.lno = :lno "
            , countQuery = "select count(*) " +
            "update tb_lb l " +
            "set l.lb_cnt = l.lb_cnt + 1 " +
            "where l.lno = :lno "
            , nativeQuery = true)
    int updateCnt(@Param("lno") Integer lno);

    // 조회수 Best 5 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select l.* from tb_lb l order by l.lb_cnt desc ) where ROWNUM <= 5 "
            , nativeQuery = true)
    List<Lb> boardBestList() ;

    // 최신순 6 리스트 쿼리
    @Modifying
    @Query(value = "select * from (select l.* from tb_lb l order by l.lno desc ) where ROWNUM <= 6 "
            , nativeQuery = true)
    List<Lb> boardDescList() ;
}
