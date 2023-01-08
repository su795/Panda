package com.example.simpledms.controller.community;

import com.example.simpledms.model.community.FbCategory;
import com.example.simpledms.service.community.FbCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName : com.example.backedu.controller
 * fileName : CodeController
 * author : kangtaegyung
 * date : 2022/07/28
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/28         kangtaegyung          최초 생성
 */
@Slf4j
@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class FbCategoryController {

    @Autowired
    FbCategoryService fbCategoryService;

    // 자유게시판 카테고리 등록
    @PostMapping("/fbCategory")
    public ResponseEntity<Object> createCode(@RequestBody FbCategory fbCategory) {
        log.info("fbCategory {}", fbCategory);

        try {
            boolean bResult = fbCategoryService.createFbCategory(fbCategory);
            if (bResult) {
                return new ResponseEntity<Object>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Object>(HttpStatus.CONFLICT);
            }

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 자유게시판 카테고리 목록 조회 (내림차순 - 카테고리명 검색 - 페이징)
    @GetMapping("/fbCategory")
    public ResponseEntity<Object> findAllPageDesc(@RequestParam(required = false) String searchKeyword,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size
    ) {

        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<FbCategory> fbCategoryPage;

//          카테고리 명 (CTitle) 이 없으면 전체 검색 실행
            fbCategoryPage = fbCategoryService.findAllFbCtitleDesc(searchKeyword, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("fbCategory", fbCategoryPage.getContent());
            response.put("currentPage", fbCategoryPage.getNumber());
            response.put("totalItems", fbCategoryPage.getTotalElements());
            response.put("totalPages", fbCategoryPage.getTotalPages());

            if (fbCategoryPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 자유게시판 카테고리 전체 조회
    @GetMapping("/fbCategory/all")
    public ResponseEntity<Object> findAll() {

        try {
            List<FbCategory> fbCategoryList = fbCategoryService.findAll();

            if (fbCategoryList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(fbCategoryList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 자유게시판 카테고리 아이디(fbCid)로 삭제
    @DeleteMapping("/fbCategory/{fbCid}")
    public ResponseEntity<Object> deleteId(@PathVariable String fbCid) {

//        프론트엔드 쪽으로 상태정보를 보내줌
        try {
            boolean bSuccess = fbCategoryService.removeById(fbCid);

            if (bSuccess == true) {
//                delete 문이 성공했을 경우
                return new ResponseEntity<>(HttpStatus.OK);
            }
//            delete 실패했을 경우( 0건 삭제가 될경우 )
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
//            DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
