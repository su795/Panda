package com.example.simpledms.service.community;

import com.example.simpledms.dto.community.MbCategoryDto;
import com.example.simpledms.model.community.Mb;
import com.example.simpledms.repository.community.MbRepository;
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
public class MbService {
    // CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    MbRepository mbRepository;

    // 이미지 포함한 생성 메서드
    public Mb createUploadFile(String nick,
                               String mbCatfbegory,
                               String mbTitle,
                               String mbContent,
                               String mbTag,
                               MultipartFile blobFile)
            throws IOException {

        if(blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Mb mb = Mb.builder()
                    .nick(nick)
                    .mbCategory(mbCatfbegory)
                    .mbTitle(mbTitle)
                    .mbContent(mbContent)
                    .mbTag(mbTag)
                    .fileName(fileName)
                    .blobFile(blobFile.getBytes())
                    .build();

            Mb createMb = mbRepository.save(mb);
            return createMb;

        } else {
            Mb mb = Mb.builder()
                    .nick(nick)
                    .mbCategory(mbCatfbegory)
                    .mbTitle(mbTitle)
                    .mbContent(mbContent)
                    .mbTag(mbTag)
                    .fileName("")
                    .blobFile(null)
                    .build();

            Mb createMb = mbRepository.save(mb);
            return createMb;
        }
    }

    // 이미지 포함한 수정 메서드
    public Mb updateUploadFile(int mno, String nick, String mbCategory, String mbTitle, String mbContent, String mbTag, int mbCnt,
                               MultipartFile blobFile) throws IOException {

        if (blobFile != null) {
            // 업로드 파일에서 파일명 얻기
            String fileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            Mb mb = Mb.builder()
                    .mno(mno)
                    .nick(nick)
                    .mbCategory(mbCategory)
                    .mbTitle(mbTitle)
                    .mbContent(mbContent)
                    .mbTag(mbTag)
                    .mbCnt(mbCnt)
                    .blobFile(blobFile.getBytes())
                    .build();

            Mb createMb = mbRepository.save(mb);
            return createMb;
        } else {
            Mb mb = Mb.builder()
                    .mno(mno)
                    .nick(nick)
                    .mbCategory(mbCategory)
                    .mbTitle(mbTitle)
                    .mbContent(mbContent)
                    .mbTag(mbTag)
                    .mbCnt(mbCnt)
                    .blobFile(null)
                    .build();

            Mb createMb = mbRepository.save(mb);
            return createMb;
        }
    }

    // 카테고리 선택 후 검색 조회 메서드
    public Page<MbCategoryDto> selectSearchAndKeywordSearch(String mb_ctitle,
                                                            String mb_title,
                                                            Pageable pageable) {
        Page<MbCategoryDto> mbPage
                = mbRepository.selectSearchAndKeywordSearch(mb_ctitle, mb_title, pageable);

        return mbPage;
    }


    // 자유게시판 상세 게시판 메소드
    public List<Mb> findAll() {

        List<Mb> mbList = mbRepository.findAll();
        return mbList;
    }

    // 게시판 번호(mno) 로 상세조회 메서드
    public Optional<Mb> findId(int mno) {

        // findById : parameter 값 - ID, return  값 - Optional
        Optional<Mb> mbOptional = mbRepository.findById(mno);

        return mbOptional;
    }

    // 게시판 번호(mno)로 삭제하는 메서드
    public boolean removeById(int mno) {

        if (mbRepository.existsById(mno)) {
            mbRepository.deleteById(mno);
            return true;
        }
        return false;
    }

    // 상세페이지 클릭시 조회수 1상승 메서드
    // @Transactional : 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
    @Transactional
    public int updateCnt(Integer mno) {
        return mbRepository.updateCnt(mno);
    }

    // 조회수 Best 5 리스트 메서드
    public List<Mb> boardBestList() {
        List<Mb> list = mbRepository.boardBestList();

        return list;
    }

    // 최신순 6 리스트 메서드
    public List<Mb> boardDescList() {
        List<Mb> list = mbRepository.boardDescList();

        return list;
    }
}
