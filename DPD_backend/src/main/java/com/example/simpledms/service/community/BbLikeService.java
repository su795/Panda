package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import com.example.simpledms.repository.community.BbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service

public class BbLikeService {
    @Autowired
    BbLikeRepository bbLikeRepository;

    // 좋아요 클릭 메서드
    public BbLike save(BbLike bbLike) {
        BbLike bbLike2 = bbLikeRepository.save(bbLike);

        return bbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<BbLike> findLike(int bno, Long userId) {
        Optional<BbLike> optionalBbLike = bbLikeRepository.findLike(bno, userId);

        return optionalBbLike;
    }


    public Optional<BbLikeDto> CountLike(int bno) {
        Optional<BbLikeDto> optionalBbLike = bbLikeRepository.CountLike(bno);

        return optionalBbLike;
    }
}
