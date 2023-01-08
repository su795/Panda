package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.BbCategoryDto;
import com.example.simpledms.model.community.Bb;
import com.example.simpledms.repository.community.BbRepository;
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
 * fileName : BbService
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Service
public class BbService {
    // CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    BbRepository bbRepository;

    // 이미지 포함한 생성 메서드
    public Bb createUploadFile(String nick,
                               String bbCategory,
                               String bbTitle,
                               String bbContent,
                               String bbTag,
                               MultipartFile blobFile)
            throws IOException {

        if(blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Bb bb = Bb.builder()
                    .nick(nick)
                    .bbCategory(bbCategory)
                    .bbTitle(bbTitle)
                    .bbContent(bbContent)
                    .bbTag(bbTag)
                    .fileName(fileName)
                    .blobFile(blobFile.getBytes())
                    .build();

            Bb createBb = bbRepository.save(bb);
            return createBb;

        } else {
            Bb bb = Bb.builder()
                    .nick(nick)
                    .bbCategory(bbCategory)
                    .bbTitle(bbTitle)
                    .bbContent(bbContent)
                    .bbTag(bbTag)
                    .fileName("")
                    .blobFile(null)
                    .build();

            Bb createBb = bbRepository.save(bb);
            return createBb;
        }
    }

    // 이미지 포함한 수정 메서드
    public Bb updateUploadFile(int bno, String nick, String bbCategory, String bbTitle, String bbContent, String bbTag, int bbCnt, int bbLike,
                               MultipartFile blobFile) throws IOException {

        if (blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Bb bb = Bb.builder()
                    .bno(bno)
                    .nick(nick)
                    .bbCategory(bbCategory)
                    .bbTitle(bbTitle)
                    .bbContent(bbContent)
                    .bbTag(bbTag)
                    .bbCnt(bbCnt)
                    .bbLike(bbLike)
                    .blobFile(blobFile.getBytes())
                    .build();

            Bb createBb = bbRepository.save(bb);
            return createBb;
        } else {
            Bb bb = Bb.builder()
                    .bno(bno)
                    .nick(nick)
                    .bbCategory(bbCategory)
                    .bbTitle(bbTitle)
                    .bbContent(bbContent)
                    .bbTag(bbTag)
                    .bbCnt(bbCnt)
                    .bbLike(bbLike)
                    .blobFile(null)
                    .build();

            Bb createBb = bbRepository.save(bb);
            return createBb;
        }
    }

    // 카테고리 선택 후 검색 조회 메서드
    public Page<BbCategoryDto> selectSearchAndKeywordSearch(String bb_ctitle,
                                                            String bb_title,
                                                            Pageable pageable) {
        Page<BbCategoryDto> bbPage
                = bbRepository.selectSearchAndKeywordSearch(bb_ctitle, bb_title, pageable);

        return bbPage;
    }

    // 자유게시판 상세 게시판 메소드
    public List<Bb> findAll() {

        List<Bb> bbList = bbRepository.findAll();
        return bbList;
    }

    // 게시판 번호(bno) 로 상세조회 메서드
    public Optional<Bb> findId(int bno) {

        // findById : parameter 값 - ID, return  값 - Optional
        Optional<Bb> bbOptional = bbRepository.findById(bno);

        return bbOptional;
    }

    // 게시판 번호(bno)로 삭제하는 메서드
    public boolean removeById(int bno) {

        if (bbRepository.existsById(bno)) {
            bbRepository.deleteById(bno);
            return true;
        }
        return false;
    }

    // 상세페이지 클릭시 조회수 1상승 메서드
    // @Transactional : 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
    @Transactional
    public int updateCnt(Integer bno) {
        return bbRepository.updateCnt(bno);
    }

    // 조회수 Best 5 리스트 메서드
    public List<Bb> boardBestList() {
        List<Bb> list = bbRepository.boardBestList();

        return list;
    }

    // 최신순 6 리스트 메서드
    public List<Bb> boardDescList() {
        List<Bb> list = bbRepository.boardDescList();

        return list;
    }
}
