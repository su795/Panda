package com.example.simpledms.controller.community;

import com.example.simpledms.model.community.BbComment;
import com.example.simpledms.service.community.BbCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : BbCommentController
 * author : ds
 * date : 2022-10-21
 * description : 자유게시판 댓글 컨트롤러 쿼리 메소드
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
 @CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class BbCommentController {

    @Autowired
    BbCommentService bbCommentService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    // frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
    // frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/bbcomment/{bno}")
    public ResponseEntity<Object> findCommentAll(@PathVariable int bno) {

        try {
            List<BbComment> list = Collections.emptyList(); // null 대신 초기화

            list = bbCommentService.findCommentAll(bno);

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

    @PostMapping("/bbcomment")
    public ResponseEntity<Object> createComment(@RequestBody BbComment bbComment) {

        try {
            BbComment bbComment2 = bbCommentService.save(bbComment);

            return new ResponseEntity<>(bbComment2, HttpStatus.OK);

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










