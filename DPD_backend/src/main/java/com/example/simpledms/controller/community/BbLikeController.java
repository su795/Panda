package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.model.community.BbLike;
import com.example.simpledms.service.community.BbLikeService;
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
public class BbLikeController {
    @Autowired
    BbLikeService bbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/bblike")
    public ResponseEntity<BbLike> addLike(@RequestBody BbLike bbLike) {
        try {
            BbLike bbLike2 = bbLikeService.save(bbLike);

            return new ResponseEntity<>(bbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 좋아요 등록
    @GetMapping("/bblike/{bno}/{userId}")
    public ResponseEntity<Object> findBbByBno(@PathVariable int bno, @PathVariable Long userId) {

        try {
            Optional<BbLike> optionalBbLike = bbLikeService.findLike(bno, userId);

            if (optionalBbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalBbLike.get(), HttpStatus.OK);
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


//    TODO : 좋아요 count
    @GetMapping("/bblike/{bno}")
    public ResponseEntity<Object> findBbLike(@PathVariable int bno) {

        try {
            Optional<BbLikeDto> optionalBbLike = bbLikeService.CountLike(bno);

            if (optionalBbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalBbLike.get(), HttpStatus.OK);
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
