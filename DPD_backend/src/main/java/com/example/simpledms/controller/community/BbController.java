package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.BbCategoryDto;
import com.example.simpledms.dto.community.BbDto;
import com.example.simpledms.model.community.Bb;
import com.example.simpledms.service.community.BbService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.controller
 * fileName : FbController
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BbController {

    @Autowired
    BbService bbService;

    ModelMapper modelMapper = new ModelMapper();

    // 글쓰기 업로드 함수 : image file Upload 포함
    @PostMapping("/bb")
    public ResponseEntity<Object> createUploadFile(
            @RequestParam String nick,
            @RequestParam String bbCategory,
            @RequestParam String bbTitle,
            @RequestParam(required = false) String bbContent,
            @RequestParam(required = false) String bbTag,
            @RequestParam(required = true, name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        // 디버깅 출력
        log.info("nick {} : ", nick);
        log.info("fbCategory {} : ", bbCategory);
        log.info("fbTitle {} : ", bbTitle);
        log.info("fbContent {} : ", bbContent);
        log.info("fbTag {} : ", bbTag);
        log.info("blobFile {} : ", blobFile);

        try {
            // db 저장 함수
            bbService.createUploadFile(nick, bbCategory, bbTitle, bbContent, bbTag, blobFile);
            if(blobFile != null) {
                message = "이미지 포함 업로드 성공!" + blobFile.getOriginalFilename();
            } else {
                message ="이미지 없이 업로드 성공!";
            }
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 수정 처리 : image update 포함
    @PutMapping("/bb/{bno}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int bno,
            @RequestParam String nick,
            @RequestParam String bbCategory,
            @RequestParam String bbTitle,
            @RequestParam (required = false) String bbContent,
            @RequestParam (required = false) String bbTag,
            @RequestParam (required = false) int bbCnt,
            @RequestParam (required = false) int bbLike,
            @RequestParam (name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        log.info("bno {} : ", bno);
        log.info("nick {} : ", nick);
        log.info("bbCategory {} : ", bbCategory);
        log.info("bbTitle {} : ", bbTitle);
        log.info("bbContent {} : ", bbContent);
        log.info("bbTag {} : ", bbTag);
        log.info("bbCnt {} : ", bbCnt);
        log.info("bbLike {} : ", bbLike);

        try {

            bbService.updateUploadFile(bno, nick, bbCategory, bbTitle, bbContent, bbTag, bbCnt, bbLike, blobFile);
            if(blobFile != null) {
                message = "이미지 포함 수정 성공!: " + blobFile.getOriginalFilename();
            } else {
                message ="이미지 없이 수정 성공!";
            }
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);

        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // file 자동 다운로드 메뉴 : 내부적으로 이미지 URL 접근 시 다운로드됨
    // 다운로드 헤더 형식 : HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
    @GetMapping("/bb/file/{bno}")
    public ResponseEntity<byte[]> findFile(@PathVariable int bno) {
        // id 로 조회 함수
        Bb bb = bbService.findId(bno).get();

        return ResponseEntity.ok()
                // Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + bb.getFileName() + "\"")
                .body(bb.getBlobFile());
    }

    // 카테고리분류 - 제목검색 - 내림차순 조회 (페이징 함수)페이징 함수
    @GetMapping("/bb")
    public ResponseEntity<Object> selectSearchAndKeywordSearch(
            @RequestParam String bb_ctitle,
            @RequestParam(required = false) String bb_title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size)

    {
        try {
            // 페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            // 다운로드 url 을 만들어 FbCategoryDto 에 저장함
            Page<BbCategoryDto> bbPage
                    = bbService.selectSearchAndKeywordSearch (bb_ctitle, bb_title, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("bb", bbPage.getContent());
            response.put("currentPage", bbPage.getNumber());
            response.put("totalItems", bbPage.getTotalElements());
            response.put("totalPages", bbPage.getTotalPages());

            if (bbPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시판 상세페이지 조회
    @GetMapping("/bb/all")
    public ResponseEntity<Object> findAll() {

        try {
            List<Bb> bbList = bbService.findAll();

            if (bbList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(bbList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시번호(bno)로 조회 (이미지 포함)
    @GetMapping("/bb/{bno}")
    public ResponseEntity<Object> findId(@PathVariable int bno) {
        try {
            // Vue에서 전송한 매개변수 데이터 확인
            log.info("bno {}", bno);

            Optional<Bb> bbOptional = bbService.findId(bno);

            // TODO : 상세페이지 클릭시 조회수 1상승 함수
            bbService.updateCnt(bno);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/bb/file/")
                    .path(bbOptional.get().getBno().toString())
                    .toUriString();

            // modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            BbDto bbDto = modelMapper.map(bbOptional.get(), BbDto.class);

            // 아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (bbOptional.get().getBlobFile() != null)?bbOptional.get().getBlobFile().length : 0;
            bbDto.setFileSize(fileSize);
            bbDto.setFileUrl(fileDownloadUri);

            if (bbOptional.isPresent()) {
                return new ResponseEntity<Object>(bbDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // bno 삭제 처리
    @DeleteMapping("/bb/deletion/{bno}")
    public ResponseEntity<Object> deleteBb(@PathVariable int bno) {

    // 프론트엔드 쪽으로 상태정보를 보내줌
        try {
            log.debug("bno : {}", bno);
            boolean bSuccess = bbService.removeById(bno);

            if (bSuccess == true) {
            // delete 문이 성공했을 경우
                return new ResponseEntity<>(HttpStatus.OK);
            }
            // delete 실패했을 경우( 0건 삭제가 될경우 )
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            // DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 조회수 Best 5 리스트 함수
    @GetMapping("/bb/best")
    public ResponseEntity<Object> boardBestList()  {

        try {
            List<Bb> list = bbService.boardBestList();

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

    // 최신순 6 리스트 함수
    @GetMapping("/bb/desc")
    public ResponseEntity<Object> boardDescList()  {

        try {
            List<Bb> list = bbService.boardDescList();

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
}
