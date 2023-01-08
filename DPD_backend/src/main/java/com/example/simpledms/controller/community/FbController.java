package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.FbCategoryDto;
import com.example.simpledms.dto.community.FbDto;
import com.example.simpledms.model.community.Fb;
import com.example.simpledms.service.community.FbService;
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
public class FbController {

    @Autowired
    FbService fbService;

    ModelMapper modelMapper = new ModelMapper();

    // 글쓰기 업로드 함수 : image file Upload 포함
    @PostMapping("/fb")
    public ResponseEntity<Object> createUploadFile(
            @RequestParam String nick,
            @RequestParam String fbCategory,
            @RequestParam String fbTitle,
            @RequestParam(required = false) String fbContent,
            @RequestParam(required = false) String fbTag,
            @RequestParam(required = false, name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        // 디버깅 출력
        log.info("nick {} : ", nick);
        log.info("fbCategory {} : ", fbCategory);
        log.info("fbTitle {} : ", fbTitle);
        log.info("fbContent {} : ", fbContent);
        log.info("fbTag {} : ", fbTag);
        log.info("blobFile {} : ", blobFile);

        try {
            // db 저장 함수
            fbService.createUploadFile(nick, fbCategory, fbTitle, fbContent, fbTag, blobFile);
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
    @PutMapping("/fb/{fno}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int fno,
            @RequestParam String nick,
            @RequestParam String fbCategory,
            @RequestParam String fbTitle,
            @RequestParam (required = false) String fbContent,
            @RequestParam (required = false) String fbTag,
            @RequestParam (required = false) int fbCnt,
            @RequestParam (required = false, name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        log.info("fno {} : ", fno);
        log.info("nick {} : ", nick);
        log.info("fbCategory {} : ", fbCategory);
        log.info("fbTitle {} : ", fbTitle);
        log.info("fbContent {} : ", fbContent);
        log.info("fbTag {} : ", fbTag);
        log.info("fbCnt {} : ", fbCnt);

        try {

            fbService.updateUploadFile(fno, nick, fbCategory, fbTitle, fbContent, fbTag, fbCnt, blobFile);
            if (blobFile != null) {
                message = "이미지 포함 수정 성공!: " + blobFile.getOriginalFilename();
            } else {
                message = "이미지 없이 수정 성공!";
            }
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);

        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // file 자동 다운로드 메뉴 : 내부적으로 이미지 URL 접근 시 다운로드됨
    // 다운로드 헤더 형식 : HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
    @GetMapping("/fb/file/{fno}")
    public ResponseEntity<byte[]> findFile(@PathVariable int fno) {
        // id 로 조회 함수
        Fb fb = fbService.findId(fno).get();

        return ResponseEntity.ok()
                // Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fb.getFileName() + "\"")
                .body(fb.getBlobFile());
    }

    // 카테고리분류 - 제목검색 - 내림차순 조회 (페이징 함수)페이징 함수
    @GetMapping("/fb")
    public ResponseEntity<Object> selectSearchAndKeywordSearch(
            @RequestParam String fb_ctitle,
            @RequestParam(required = false) String fb_title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size)

    {
        try {
            // 페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            // 다운로드 url 을 만들어 FbCategoryDto 에 저장함
            Page<FbCategoryDto> fbPage
                    = fbService.selectSearchAndKeywordSearch (fb_ctitle, fb_title, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("fb", fbPage.getContent());
            response.put("currentPage", fbPage.getNumber());
            response.put("totalItems", fbPage.getTotalElements());
            response.put("totalPages", fbPage.getTotalPages());

            if (fbPage.isEmpty() == false) {
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
    @GetMapping("/fb/all")
    public ResponseEntity<Object> findAll() {

        try {
            List<Fb> fbList = fbService.findAll();

            if (fbList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(fbList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시번호(fno)로 조회 (이미지 포함)
    @GetMapping("/fb/{fno}")
    public ResponseEntity<Object> findId(@PathVariable int fno) {
        try {
            // Vue에서 전송한 매개변수 데이터 확인
            log.info("fno {}", fno);

            Optional<Fb> fbOptional = fbService.findId(fno);

            // TODO : 상세페이지 클릭시 조회수 1상승 함수
            fbService.updateCnt(fno);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/fb/file/")
                    .path(fbOptional.get().getFno().toString())
                    .toUriString();

            // modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            FbDto fbDto = modelMapper.map(fbOptional.get(), FbDto.class);

            // 아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (fbOptional.get().getBlobFile() != null) ? fbOptional.get().getBlobFile().length : 0;
            fbDto.setFileSize(fileSize);
            fbDto.setFileUrl(fileDownloadUri);

            if (fbOptional.isPresent()) {
                return new ResponseEntity<Object>(fbDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // fno 삭제 처리
    @DeleteMapping("/fb/deletion/{fno}")
    public ResponseEntity<Object> deleteFb(@PathVariable int fno) {

    // 프론트엔드 쪽으로 상태정보를 보내줌
        try {
            log.debug("fno : {}", fno);
            boolean bSuccess = fbService.removeById(fno);

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
    @GetMapping("/fb/best")
    public ResponseEntity<Object> boardBestList()  {

        try {
            List<Fb> list = fbService.boardBestList();

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
    }// 최신순 6 리스트 함수
    @GetMapping("/fb/desc")
    public ResponseEntity<Object> boardDescList()  {

        try {
            List<Fb> list = fbService.boardDescList();

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
