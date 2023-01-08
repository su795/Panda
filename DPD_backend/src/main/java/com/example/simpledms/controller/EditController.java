package com.example.simpledms.controller;

import com.example.simpledms.model.User;
import com.example.simpledms.service.EditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller
 * fileName : EditController
 * author : ds
 * date : 2022-12-21
 * description : 관리자의 유저 수정 controller
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-21         ds          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class EditController {


    @Autowired
    EditService editService;


    @GetMapping("/edit")
    public ResponseEntity<Object> getEditAll(@RequestParam(required = false) String username,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이지 객체 정의
            Pageable pageable = PageRequest.of(page,size);

//            Page 객체 정의
            Page<User> editPage;

//            findAll() 생략해도 전체검색이 됨 :
//            why? like 검색 시 매개변수가  "" 전체검색이 됨.
            editPage = editService.findAllByUsernameContaining(username, pageable);
//            }

//            맵 자료구저에 넣어서 전송
            Map<String,Object> response = new HashMap<>();
            response.put("edit", editPage.getContent());
            response.put("currentPage", editPage.getNumber());
            response.put("totalItems", editPage.getTotalElements());
            response.put("totalPages", editPage.getTotalPages());


            if (editPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/edit/all")
    public ResponseEntity<Object> removeAll() {

        try {
            editService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/edit")
    public ResponseEntity<Object> createEmp(@RequestBody User user) {

        try {
            User user2 = editService.save(user);

            return new ResponseEntity<>(user2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/edit/{userNum}")
    public ResponseEntity<Object> getEditId(@PathVariable int userNum) {

        try {
            Optional<User> optionalEmp = editService.findById(userNum);

            if (optionalEmp.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalEmp.get(), HttpStatus.OK);
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

    @PutMapping("/edit/{userNum}")
    public ResponseEntity<Object> updateEmp(@PathVariable int userNum,
                                            @RequestBody User user) {

        try {
            User user2 = editService.save(user);

            return new ResponseEntity<>(user2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/edit/deletion/{userNum}")
    public ResponseEntity<Object> deleteEdit(@PathVariable int userNum) {

        try {
            boolean bSuccess = editService.removeById(userNum);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
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











