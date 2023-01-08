package com.example.simpledms.repository.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.dto.community.FbLikeDto;
import com.example.simpledms.model.community.FbLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface FbLikeRepository extends JpaRepository<FbLike, Long> {

        @Query(value = "select f.* from tb_fb_like f where :fno = f.fno and :userId = f.user_id"
                ,nativeQuery = true)
        public Optional<FbLike> findLike(@Param("fno") int fno, @Param("userId") Long userId);

        @Query(value = "select count(*) as count from tb_fb_like b where b.fno = :fno",
                nativeQuery = true)
        public Optional<FbLikeDto> CountLike(@Param("fno") int fno);

}
