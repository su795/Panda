package com.example.simpledms.repository;

import com.example.simpledms.model.Diary;
import com.example.simpledms.model.GoodComment;
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
public interface GoodCommentRepository extends JpaRepository<GoodComment, Integer> {

    @Query(value = "select c.* from tb_good_comment c" +
    " where c.goods_id = :goodsId"
    ,nativeQuery = true)
    List<GoodComment> findCommentAll(@Param("goodsId") int goodsId);
}









