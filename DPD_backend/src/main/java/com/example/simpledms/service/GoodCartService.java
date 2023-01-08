package com.example.simpledms.service;

import com.example.simpledms.model.GoodCart;
import com.example.simpledms.model.community.FbLike;
import com.example.simpledms.repository.GoodCartRepository;
import com.example.simpledms.repository.community.FbLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service

public class GoodCartService {
    @Autowired
    GoodCartRepository goodCartRepository;

    // 좋아요 클릭 메서드
    public GoodCart save(GoodCart goodCart) {
        GoodCart goodCart2 = goodCartRepository.save(goodCart);

        return goodCart2;
    }

    // 좋아요 1회로 제한하는 메서드
    public Optional<GoodCart> findCart(int goodsId, Long userId) {
        Optional<GoodCart> optionalGoodCart = goodCartRepository.findCart(goodsId, userId);

        return optionalGoodCart;
    }
}
