package com.example.simpledms.repository;

import com.example.simpledms.model.GoodComment;
import com.example.simpledms.model.GoodReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : ds
 * date : 2022-10-20
 * description : 다이어리 repository
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

@Repository
public interface GoodReplyRepository extends JpaRepository<GoodReply, Integer> {

    @Query(value = "select r.* from tb_good_reply r" +
    " where r.goods_id = :goodsId "
    ,nativeQuery = true)
    List<GoodReply> findReplyAll(@Param("goodsId") int goodsId);
}









