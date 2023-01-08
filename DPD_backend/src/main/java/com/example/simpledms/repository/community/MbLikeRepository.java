package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.dto.community.MbLikeDto;
import com.example.simpledms.model.community.MbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface MbLikeRepository extends JpaRepository<MbLike, Long> {

        @Query(value = "select m.* from tb_mb_like m where :mno = m.mno and :userId = m.user_id"
                ,nativeQuery = true)
        public Optional<MbLike> findLike(@Param("mno") int mno, @Param("userId") Long userId);


        @Query(value = "select count(*) as count from tb_mb_like b where b.mno = :mno",
                nativeQuery = true)
        public Optional<MbLikeDto> CountLike(@Param("mno") int mno);

}
