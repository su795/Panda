package com.example.simpledms.controller;

import com.example.simpledms.model.GoodCart;
import com.example.simpledms.model.Goods;
import com.example.simpledms.model.community.FbLike;
import com.example.simpledms.service.GoodCartService;
import com.example.simpledms.service.community.FbLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GoodCartController {
    @Autowired
    GoodCartService goodCartService;

    // 좋아요 클릭 함수
    @PostMapping("/goodcart")
    public ResponseEntity<GoodCart> addCart(@RequestBody GoodCart goodCart) {
        try {
            GoodCart goodCart2 = goodCartService.save(goodCart);

            return new ResponseEntity<>(goodCart2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/goodcart/{goodsId}/{userId}")
    public ResponseEntity<Object> findGoodsByGoodsId(@PathVariable int goodsId, @PathVariable Long userId) {

        try {
            Optional<GoodCart> optionalGoodCart = goodCartService.findCart(goodsId, userId);

            if (optionalGoodCart.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalGoodCart.get(), HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
