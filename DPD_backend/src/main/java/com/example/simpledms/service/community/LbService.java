package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.LbCategoryDto;
import com.example.simpledms.model.community.Lb;
import com.example.simpledms.repository.community.LbRepository;
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
 * fileName : LbService
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Service
public class LbService {
    // CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    LbRepository lbRepository;

    // 이미지 포함한 생성 메서드
    public Lb createUploadFile(String nick,
                                 String lbCategory,
                                 String lbTitle,
                                 String lbContent,
                                 String lbTag,
                                 MultipartFile blobFile)
            throws IOException {

        if(blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Lb lb = Lb.builder()
                    .nick(nick)
                    .lbCategory(lbCategory)
                    .lbTitle(lbTitle)
                    .lbContent(lbContent)
                    .lbTag(lbTag)
                    .fileName(fileName)
                    .blobFile(blobFile.getBytes())
                    .build();

            Lb createLb = lbRepository.save(lb);
            return createLb;

        } else {
            Lb lb = Lb.builder()
                    .nick(nick)
                    .lbCategory(lbCategory)
                    .lbTitle(lbTitle)
                    .lbContent(lbContent)
                    .lbTag(lbTag)
                    .fileName("")
                    .blobFile(null)
                    .build();

            Lb createLb = lbRepository.save(lb);
            return createLb;
        }
    }

    // 이미지 포함한 수정 메서드
    public Lb updateUploadFile(int lno, String nick, String lbCategory, String lbTitle, String lbContent, String lbTag, int lbCnt,
                               MultipartFile blobFile) throws IOException {

        if (blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Lb lb = Lb.builder()
                    .lno(lno)
                    .nick(nick)
                    .lbCategory(lbCategory)
                    .lbTitle(lbTitle)
                    .lbContent(lbContent)
                    .lbTag(lbTag)
                    .lbCnt(lbCnt)
                    .blobFile(blobFile.getBytes())
                    .build();

            Lb createLb = lbRepository.save(lb);

            return createLb;
        } else {
            Lb lb = Lb.builder()
                    .lno(lno)
                    .nick(nick)
                    .lbCategory(lbCategory)
                    .lbTitle(lbTitle)
                    .lbContent(lbContent)
                    .lbTag(lbTag)
                    .lbCnt(lbCnt)
                    .blobFile(null)
                    .build();

            Lb createLb = lbRepository.save(lb);
            return createLb;
        }
    }

    // 카테고리 선택 후 검색 조회 메서드
    public Page<LbCategoryDto> selectSearchAndKeywordSearch(String lb_ctitle,
                                                            String lb_title,
                                                            Pageable pageable) {
        Page<LbCategoryDto> lbPage
                = lbRepository.selectSearchAndKeywordSearch(lb_ctitle, lb_title, pageable);

        return lbPage;
    }

    // 자유게시판 상세 게시판 메소드
    public List<Lb> findAll() {

        List<Lb> lbList = lbRepository.findAll();
        return lbList;
    }

    // 게시판 번호(lno) 로 상세조회 메서드
    public Optional<Lb> findId(int lno) {

        // findById : parameter 값 - ID, return  값 - Optional
        Optional<Lb> lbOptional = lbRepository.findById(lno);

        return lbOptional;
    }

    // 게시판 번호(lno)로 삭제하는 메서드
    public boolean removeById(int lno) {

        if (lbRepository.existsById(lno)) {
            lbRepository.deleteById(lno);
            return true;
        }
        return false;
    }

    // 상세페이지 클릭시 조회수 1상승 메서드
    // @Transactional : 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
    @Transactional
    public int updateCnt(Integer lno) {
        return lbRepository.updateCnt(lno);
    }

    // 조회수 Best 5 리스트 메서드
    public List<Lb> boardBestList() {
        List<Lb> list = lbRepository.boardBestList();

        return list;
    }

    // 최신순 6 리스트 메서드
    public List<Lb> boardDescList() {
        List<Lb> list = lbRepository.boardDescList();

        return list;
    }
}
