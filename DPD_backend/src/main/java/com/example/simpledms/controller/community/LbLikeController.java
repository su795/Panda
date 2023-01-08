package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.BbLikeDto;
import com.example.simpledms.dto.community.LbLikeDto;
import com.example.simpledms.model.community.LbLike;
import com.example.simpledms.service.community.LbLikeService;
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
public class LbLikeController {
    @Autowired
    LbLikeService lbLikeService;

    // 좋아요 클릭 함수
    @PostMapping("/lblike")
    public ResponseEntity<LbLike> addLike(@RequestBody LbLike lbLike) {
        try {
            LbLike lbLike2 = lbLikeService.save(lbLike);

            return new ResponseEntity<>(lbLike2, HttpStatus.OK);
        } catch(Exception e) {
                log.debug(e.getMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 좋아요 등록
    @GetMapping("/lblike/{lno}/{userId}")
    public ResponseEntity<Object> findLbByLno(@PathVariable int lno, @PathVariable Long userId) {

        try {
            Optional<LbLike> optionalLbLike = lbLikeService.findLike(lno, userId);

            if (optionalLbLike.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalLbLike.get(), HttpStatus.OK);
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
    @GetMapping("/lblike/{lno}")
    public ResponseEntity<Object> findLbLike(@PathVariable int lno) {

        try {
            Optional<LbLikeDto> optionalLbLikeDto = lbLikeService.CountLike(lno);

            if (optionalLbLikeDto.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalLbLikeDto.get(), HttpStatus.OK);
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
