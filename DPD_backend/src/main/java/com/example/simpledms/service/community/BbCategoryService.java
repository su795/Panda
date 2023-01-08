package com.example.simpledms.service.community;

import com.example.simpledms.model.community.BbCategory;
import com.example.simpledms.repository.community.BbCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * packageName : com.example.backedu.service
 * fileName : CodeServiceImpl
 * author : kangtaegyung
 * date : 2022/07/29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/29         kangtaegyung          최초 생성
 */
@Service
public class BbCategoryService {

    @Autowired
    BbCategoryRepository bbCategoryRepository;

    // 등록시 실행될 메소드
    public boolean createBbCategory(BbCategory bbCategory) {

        // id 중복 체크
        if( bbCategory.getBbCid() != null) {
            boolean bResult = bbCategoryRepository.existsById(bbCategory.getBbCid());

//            id 중복 체크
            if(bResult) return false;

        }

//        생성 날짜 지정을 위한 날짜 라이브러리 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
//            시간 형태 지정 : 예) 2022-07-28 15:02:45
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH24:MI:SS");

//        생성 날짜 지정
        bbCategory.setInsertTime(localDateTime.format(formatter));

        bbCategoryRepository.save(bbCategory);

        return true;
    }

    public Page<BbCategory> findAllBbCtitleDesc(String bbCtitle, Pageable pageable) {

        Page<BbCategory> bbCategoryPage = bbCategoryRepository.findAllByBbCtitleContainingOrderByInsertTimeDesc(bbCtitle, pageable);
        return bbCategoryPage;
    }

    // 전체 조회시 실행될 메소드
    public List<BbCategory> findAll() {

        List<BbCategory> bbCategoryList = bbCategoryRepository.findAll();
        return bbCategoryList;
    }

    // 삭제시 실행될 메소드
    public boolean removeById(String bbCid) {

        if (bbCategoryRepository.existsById(bbCid)) {
            bbCategoryRepository.deleteById(bbCid);
            return true;
        }
        return false;
    }
}
