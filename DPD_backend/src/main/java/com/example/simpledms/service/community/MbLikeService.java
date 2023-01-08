package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.dto.community.MbLikeDto;
import com.example.simpledms.model.community.MbLike;
import com.example.simpledms.repository.community.MbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service

public class MbLikeService {
    @Autowired
    MbLikeRepository mbLikeRepository;

    // 좋아요 클릭 메서드
    public MbLike save(MbLike mbLike) {
        MbLike mbLike2 = mbLikeRepository.save(mbLike);

        return mbLike2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<MbLike> findLike(int mno, Long userId) {
        Optional<MbLike> optionalMbLike = mbLikeRepository.findLike(mno, userId);

        return optionalMbLike;
    }

    public Optional<MbLikeDto> CountLike(int mno) {
        Optional<MbLikeDto> optionalMbLikeDto = mbLikeRepository.CountLike(mno);

        return optionalMbLikeDto;
    }

}
