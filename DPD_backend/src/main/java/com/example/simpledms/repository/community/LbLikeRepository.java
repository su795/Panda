package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.model.community.LbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface LbLikeRepository extends JpaRepository<LbLike, Long> {

        @Query(value = "select l.* from tb_lb_like l where :lno = l.lno and :userId = l.user_id"
                ,nativeQuery = true)
        public Optional<LbLike> findLike(@Param("lno") int lno, @Param("userId") Long userId);

        @Query(value = "select count(*) as count from tb_lb_like b where b.lno = :lno",
                nativeQuery = true)
        public Optional<LbLikeDto> CountLike(@Param("lno") int lno);

}
