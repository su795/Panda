package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.BbReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : BbReplyRepository
 * author : ds
 * date : 2022-10-20
 * description : 추천게시판 대댓글 repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface BbReplyRepository extends JpaRepository<BbReply, Integer> {

    @Query(value = "select r.* from tb_bb_reply r" +
    " where r.bno = :bno "
    ,nativeQuery = true)
    List<BbReply> findReplyAll(@Param("bno") int bno);
}









