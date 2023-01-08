package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.LbReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : LbReplyRepository
 * author : ds
 * date : 2022-10-20
 * description : 분실게시판 대댓글 repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface LbReplyRepository extends JpaRepository<LbReply, Integer> {

    @Query(value = "select r.* from tb_lb_reply r" +
    " where r.lno = :lno "
    ,nativeQuery = true)
    List<LbReply> findReplyAll(@Param("lno") int lno);
}









