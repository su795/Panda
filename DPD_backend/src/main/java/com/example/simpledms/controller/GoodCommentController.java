package com.example.simpledms.controller;

import com.example.simpledms.model.Diary;
import com.example.simpledms.model.GoodComment;
import com.example.simpledms.service.DiaryService;
import com.example.simpledms.service.GoodCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Diary07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 쿼리 메소드
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GoodCommentController {

    @Autowired
    GoodCommentService goodCommentService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/goodcomment/{goodsId}")
    public ResponseEntity<Object> findCommentAll(@PathVariable int goodsId) {

        try {
//            1) title 이 null 경우 : 전체 검색
//            2) title 에 값이 있을 경우 : 부서명 like 검색
            List<GoodComment> list = Collections.emptyList(); // null 대신 초기화

            list = goodCommentService.findCommentAll(goodsId);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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


//    @DeleteMapping("/goodcomment/all")
//    public ResponseEntity<Object> removeAll() {
//
//        try {
//            diaryService.removeAll();
//
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/goodcomment")
    public ResponseEntity<Object> createComment(@RequestBody GoodComment goodComment) {

        try {
            GoodComment goodComment2 = goodCommentService.save(goodComment);

            return new ResponseEntity<>(goodComment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/diary/{dno}")
//    public ResponseEntity<Object> getDiaryId(@PathVariable int dno) {
//
//        try {
//            Optional<Diary> optionalDiary = diaryService.findById(dno);
//
//            if (optionalDiary.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalDiary.get(), HttpStatus.OK);
//            } else {
////                데이터 없음 메세지 전송(클라이언트)
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            // 서버에러 발생 메세지 전송(클라이언트)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/diary/{dno}")
//    public ResponseEntity<Object> updateDiary(@PathVariable int dno,
//                                              @RequestBody Diary diary) {
//
//        try {
//            Diary diary2 = diaryService.save(diary);
//
//            return new ResponseEntity<>(diary2, HttpStatus.OK);
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/diary/deletion/{dno}")
//    public ResponseEntity<Object> deleteDiary(@PathVariable int dno) {
//
//        try {
//            boolean bSuccess = diaryService.removeById(dno);
//
//            if (bSuccess == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(HttpStatus.OK);
//            } else {
////                데이터 없음 메세지 전송(클라이언트)
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            // 서버에러 발생 메세지 전송(클라이언트)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
}










