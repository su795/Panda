package com.example.simpledms.repository;

import com.example.simpledms.model.GoodCart;
import com.example.simpledms.model.community.FbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface GoodCartRepository extends JpaRepository<GoodCart, Integer> {

        @Query(value = "select c.* from tb_good_cart c where :goodsId = c.goods_id and :userId = c.user_id"
        ,nativeQuery = true)
        public Optional<GoodCart> findCart(@Param("goodsId") int goodsId, @Param("userId") Long userId);
}
