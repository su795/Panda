package com.example.simpledms.repository.community;

import com.example.simpledms.model.community.BbComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : BbCommentRepository
 * author : ds
 * date : 2022-10-20
 * description : 추천게시판 댓글 Repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface BbCommentRepository extends JpaRepository<BbComment, Integer> {

    @Query(value = "select c.* from tb_bb_comment c" +
    " where c.bno = :bno"
    ,nativeQuery = true)
    List<BbComment> findCommentAll(@Param("bno") int bno);
}









