package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface BbLikeRepository extends JpaRepository<BbLike, Long> {

        @Query(value = "select b.* from tb_bb_like b where :bno = b.bno and :userId = b.user_id"
                ,nativeQuery = true)
        public Optional<BbLike> findLike(@Param("bno") int bno, @Param("userId") Long userId);

        @Query(value = "select count(*) as count from tb_bb_like b where b.bno = :bno",
        nativeQuery = true)
        public Optional<BbLikeDto> CountLike(@Param("bno") int bno);
}
