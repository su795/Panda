package com.example.simpledms.controller;

import com.example.simpledms.dto.filedb.ResponseFileDto;
import com.example.simpledms.dto.mypage.AccountBookDto;
import com.example.simpledms.model.FileDb;
import com.example.simpledms.model.Goods;
import com.example.simpledms.service.FileDbService;
import com.example.simpledms.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller
 * fileName : GoodsController
 * author : ds
 * date : 2022-12-16
 * description : 상품 컨트롤러
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class GoodsController {
    //    서비스 함수 사용을 위한 어노테이션
    @Autowired
    GoodsService goodsService;

    @Autowired
    FileDbService fileDbService;

    ModelMapper modelMapper = new ModelMapper();


//        메인 페이지 상품 조회 함수
    @GetMapping("/goods/main")
    public ResponseEntity<Object> getGoodsMain(@RequestParam(required = false) String title,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "15") int size
    ) {
        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//            Page 객체 정의
//            Page<GoodsDto> goodsPage = goodsService.findGoodsMain(pageable);
            Page<ResponseFileDto> goodsPage = goodsService
                    .findGoodsMainMain(pageable)
                    .map(GoodsDto -> {
                        String fileDownloadUri = ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/goods/")
                                .path(GoodsDto.getGoodsId().toString())
                                .toUriString();
                        ResponseFileDto fileDto = modelMapper.map(GoodsDto, ResponseFileDto.class);

                        fileDto.setFileUrl(fileDownloadUri);
                        return fileDto;
                    });

//            findAll() 생략 해도 전체검색이 됨 :
//            why? like 검색시 부서명 매개변수가 ""이더라도 전체검색이 됨
//            goodsPage = goodsService.findAllByTitleContainingOrderByInsertTimeDesc(title, pageable);
//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("goods", goodsPage.getContent());
            response.put("currentPage", goodsPage.getNumber());
            response.put("totalItems", goodsPage.getTotalElements());
            response.put("totalPages", goodsPage.getTotalPages());


            if (goodsPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        //    상품 페이지 메인 조회 함수
    @GetMapping("/goods")
    public ResponseEntity<Object> getGoodsAll(@RequestParam String category,
                                              @RequestParam(required = false) String title,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "40") int size
    ) {
        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//            Page 객체 정의
//            Page<GoodsDto> goodsPage = goodsService.findGoodsMain(pageable);
            Page<ResponseFileDto> goodsPage
                    = goodsService.findGoodsMain(category, title, pageable)
                    .map(GoodsDto -> {
                        String fileDownloadUri = ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/goods/")
                                .path(GoodsDto.getGoodsId().toString())
                                .toUriString();
                        ResponseFileDto fileDto = modelMapper.map(GoodsDto, ResponseFileDto.class);

                        fileDto.setFileUrl(fileDownloadUri);
                        return fileDto;
                    });

//            findAll() 생략 해도 전체검색이 됨 :
//            why? like 검색시 부서명 매개변수가 ""이더라도 전체검색이 됨
//            goodsPage = goodsService.findAllByTitleContainingOrderByInsertTimeDesc(title, pageable);
//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("goods", goodsPage.getContent());
            response.put("currentPage", goodsPage.getNumber());
            response.put("totalItems", goodsPage.getTotalElements());
            response.put("totalPages", goodsPage.getTotalPages());


            if (goodsPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/goods/{goodsId}")
    public ResponseEntity<byte[]> getFile(@PathVariable int goodsId) {
        FileDb fileDb = fileDbService.getFile(goodsId).get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDb.getFileName() + "\"")
                .body(fileDb.getFileData());
    }

    //    상품 추가 함수
    @PostMapping("/goods")
    public ResponseEntity<Object> addGoods(@RequestBody Goods goods) {

        try {
            Goods goods2 = goodsService.save(goods);

            return new ResponseEntity<>(goods2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/goods/{goodsId}")
    public ResponseEntity<Object> updateGoods(@PathVariable int goodsId,
                                              @RequestBody Goods goods) {

        try {
            Goods goods2 = goodsService.save(goods);

            return new ResponseEntity<>(goods2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //        상품번호로 조회(상세페이지 접속)
    @GetMapping("/goods/detail/{goodsId}")
    public ResponseEntity<Object> findGoodsByGoodsId(@PathVariable int goodsId) {

        try {
            Optional<Goods> optionalGoods = goodsService.findGoodsByGoodsId(goodsId);

            if (optionalGoods.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalGoods.get(), HttpStatus.OK);
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


    @DeleteMapping("/goods/deletion/{goodsId}")
    public ResponseEntity<Object> deleteGoods(@PathVariable int goodsId) {

        try {
            boolean bSuccess = goodsService.removeById(goodsId);

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
    //    ----------가계부-----------
    //    한달전 가계부 조회
    @GetMapping("/goods/account1/{sellerId}")
    public ResponseEntity<Object> accountBook(@PathVariable String sellerId) {

        try {
            List<AccountBookDto> list = goodsService.accountBook(sellerId);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //    3달전 가계부 조회
    @GetMapping("/goods/account3/{sellerId}")
    public ResponseEntity<Object> accountBook3M(@PathVariable String sellerId) {

        try {
            List<AccountBookDto> list = goodsService.accountBook3M(sellerId);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //    6달전 가계부 조회
    @GetMapping("/goods/account6/{sellerId}")
    public ResponseEntity<Object> accountBook6M(@PathVariable String sellerId) {

        try {
            List<AccountBookDto> list = goodsService.accountBook6M(sellerId);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}