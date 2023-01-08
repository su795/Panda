package com.example.simpledms.controller.community;

import com.example.simpledms.dto.community.MbCategoryDto;
import com.example.simpledms.dto.community.MbDto;
import com.example.simpledms.model.community.Mb;
import com.example.simpledms.service.community.MbService;
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
 * fileName : MbController
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
public class MbController {

    @Autowired
    MbService mbService;

    ModelMapper modelMapper = new ModelMapper();

    // 글쓰기 업로드 함수 : image file Upload 포함
    @PostMapping("/mb")
    public ResponseEntity<Object> createUploadFile(
            @RequestParam String nick,
            @RequestParam String mbCategory,
            @RequestParam String mbTitle,
            @RequestParam(required = false) String mbContent,
            @RequestParam(required = false) String mbTag,
            @RequestParam(required = false, name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        // 디버깅 출력
        log.info("nick {} : ", nick);
        log.info("mbCategory {} : ", mbCategory);
        log.info("mbTitle {} : ", mbTitle);
        log.info("mbContent {} : ", mbContent);
        log.info("mbTag {} : ", mbTag);
        log.info("blobFile {} : ", blobFile);

        try {
            // db 저장 함수
            mbService.createUploadFile(nick, mbCategory, mbTitle, mbContent, mbTag, blobFile);
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
    @PutMapping("/mb/{mno}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int mno,
            @RequestParam String nick,
            @RequestParam String mbCategory,
            @RequestParam String mbTitle,
            @RequestParam (required = false) String mbContent,
            @RequestParam (required = false) String mbTag,
            @RequestParam (required = false) int mbCnt,
            @RequestParam (required = false, name="blobFile") MultipartFile blobFile
    ) {
        String message = ""; // front-end 전송할 메세지

        log.info("mno {} : ", mno);
        log.info("nick {} : ", nick);
        log.info("mbCategory {} : ", mbCategory);
        log.info("mbTitle {} : ", mbTitle);
        log.info("mbContent {} : ", mbContent);
        log.info("mbTag {} : ", mbTag);
        log.info("mbCnt {} : ", mbCnt);

        try {

            mbService.updateUploadFile(mno, nick, mbCategory, mbTitle, mbContent, mbTag, mbCnt, blobFile);
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
    @GetMapping("/mb/file/{mno}")
    public ResponseEntity<byte[]> findFile(@PathVariable int mno) {
        // id 로 조회 함수
        Mb mb = mbService.findId(mno).get();

        return ResponseEntity.ok()
                // Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + mb.getFileName() + "\"")
                .body(mb.getBlobFile());
    }

    // 카테고리분류 - 제목검색 - 내림차순 조회 (페이징 함수)페이징 함수
    @GetMapping("/mb")
    public ResponseEntity<Object> selectSearchAndKeywordSearch(
            @RequestParam String mb_ctitle,
            @RequestParam(required = false) String mb_title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size)

    {
        try {
            // 페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            // 다운로드 url 을 만들어 MbCategoryDto 에 저장함
            Page<MbCategoryDto> mbPage
                    = mbService.selectSearchAndKeywordSearch (mb_ctitle, mb_title, pageable);
            Map<String, Object> response = new HashMap<>();
            response.put("mb", mbPage.getContent());
            response.put("currentPage", mbPage.getNumber());
            response.put("totalItems", mbPage.getTotalElements());
            response.put("totalPages", mbPage.getTotalPages());

            if (mbPage.isEmpty() == false) {
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
    @GetMapping("/mb/all")
    public ResponseEntity<Object> findAll() {

        try {
            List<Mb> mbList = mbService.findAll();

            if (mbList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(mbList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 게시번호(mno)로 조회 (이미지 포함)
    @GetMapping("/mb/{mno}")
    public ResponseEntity<Object> findId(@PathVariable int mno) {
        try {
            // Vue에서 전송한 매개변수 데이터 확인
            log.info("mno {}", mno);

            Optional<Mb> mbOptional = mbService.findId(mno);

            // TODO : 상세페이지 클릭시 조회수 1상승 함수
            mbService.updateCnt(mno);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/mb/file/")
                    .path(mbOptional.get().getMno().toString())
                    .toUriString();

            // modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            MbDto mbDto = modelMapper.map(mbOptional.get(), MbDto.class);

            // 아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (mbOptional.get().getBlobFile() != null)?mbOptional.get().getBlobFile().length : 0;
            mbDto.setFileSize(fileSize);
            mbDto.setFileUrl(fileDownloadUri);

            if (mbOptional.isPresent()) {
                return new ResponseEntity<Object>(mbDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // mno 삭제 처리
    @DeleteMapping("/mb/deletion/{mno}")
    public ResponseEntity<Object> deleteMb(@PathVariable int mno) {

    // 프론트엔드 쪽으로 상태정보를 보내줌
        try {
            log.debug("mno : {}", mno);
            boolean bSuccess = mbService.removeById(mno);

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
    @GetMapping("/mb/best")
    public ResponseEntity<Object> boardBestList()  {

        try {
            List<Mb> list = mbService.boardBestList();

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
    @GetMapping("/mb/desc")
    public ResponseEntity<Object> boardDescList()  {

        try {
            List<Mb> list = mbService.boardDescList();

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
