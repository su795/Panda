package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.FbCategoryDto;
import com.example.simpledms.model.community.Fb;
import com.example.simpledms.repository.community.FbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : FbService
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Service
public class FbService {
    // CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    FbRepository fbRepository;

    // 이미지 포함한 생성 메서드
    public Fb createUploadFile(String nick,
                               String fbCategory,
                               String fbTitle,
                               String fbContent,
                               String fbTag,
                               MultipartFile blobFile)
            throws IOException {

        if(blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Fb fb = Fb.builder()
                    .nick(nick)
                    .fbCategory(fbCategory)
                    .fbTitle(fbTitle)
                    .fbContent(fbContent)
                    .fbTag(fbTag)
                    .fileName(fileName)
                    .blobFile(blobFile.getBytes())
                    .build();

            Fb createFb = fbRepository.save(fb);
            return createFb;

        } else {
            Fb fb = Fb.builder()
                    .nick(nick)
                    .fbCategory(fbCategory)
                    .fbTitle(fbTitle)
                    .fbContent(fbContent)
                    .fbTag(fbTag)
                    .fileName("")
                    .blobFile(null)
                    .build();

            Fb createFb = fbRepository.save(fb);
            return createFb;
        }
    }

    // 이미지 포함한 수정 메서드
    public Fb updateUploadFile(int fno, String nick, String fbCategory, String fbTitle, String fbContent, String fbTag, int fbCnt,
                               MultipartFile blobFile) throws IOException {

        if (blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Fb fb = Fb.builder()
                    .fno(fno)
                    .nick(nick)
                    .fbCategory(fbCategory)
                    .fbTitle(fbTitle)
                    .fbContent(fbContent)
                    .fbTag(fbTag)
                    .fbCnt(fbCnt)
                    .blobFile(blobFile.getBytes())
                    .build();

            Fb createFb = fbRepository.save(fb);

            return createFb;
        } else {
            Fb fb = Fb.builder()
                    .fno(fno)
                    .nick(nick)
                    .fbCategory(fbCategory)
                    .fbTitle(fbTitle)
                    .fbContent(fbContent)
                    .fbTag(fbTag)
                    .fbCnt(fbCnt)
                    .blobFile(null)
                    .build();

            Fb createFb = fbRepository.save(fb);
            return createFb;
        }
    }

    // 카테고리 선택 후 검색 조회 메서드
    public Page<FbCategoryDto> selectSearchAndKeywordSearch(String fb_ctitle,
                                                            String fb_title,
                                                            Pageable pageable) {
        Page<FbCategoryDto> fbPage
                = fbRepository.selectSearchAndKeywordSearch(fb_ctitle, fb_title, pageable);

        return fbPage;
    }

    // 자유게시판 상세 게시판 메서드
    public List<Fb> findAll() {

        List<Fb> fbList = fbRepository.findAll();
        return fbList;
    }

    // 게시판 번호(fno) 로 상세조회 메서드
    public Optional<Fb> findId(int fno) {

        // findById : parameter 값 - ID, return  값 - Optional
        Optional<Fb> fbOptional = fbRepository.findById(fno);

        return fbOptional;
    }

    // 게시판 번호(fno)로 삭제하는 메서드
    public boolean removeById(int fno) {

        if (fbRepository.existsById(fno)) {
            fbRepository.deleteById(fno);
            return true;
        }
        return false;
    }

    // 상세페이지 클릭시 조회수 1상승 메서드
    // @Transactional : 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
    @Transactional
    public int updateCnt(Integer fno) {
        return fbRepository.updateCnt(fno);
    }

    // 조회수 Best 5 리스트 메서드
    public List<Fb> boardBestList() {
        List<Fb> list = fbRepository.boardBestList();

        return list;
    }

    // 최신순 6 리스트 메서드
    public List<Fb> boardDescList() {
        List<Fb> list = fbRepository.boardDescList();

        return list;
    }
}
