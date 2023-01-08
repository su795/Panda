package com.example.simpledms.service.community;

import com.example.simpledms.model.community.FbCategory;
import com.example.simpledms.repository.community.FbCategoryRepository;
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
public class FbCategoryService {

    @Autowired
    FbCategoryRepository fbCategoryRepository;

    // 등록시 실행될 메소드
    public boolean createFbCategory(FbCategory fbCategory) {

        // id 중복 체크
        if( fbCategory.getFbCid() != null) {
            boolean bResult = fbCategoryRepository.existsById(fbCategory.getFbCid());

//            id 중복 체크
            if(bResult) return false;

        }

//        생성 날짜 지정을 위한 날짜 라이브러리 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
//            시간 형태 지정 : 예) 2022-07-28 15:02:45
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH24:MI:SS");

//        생성 날짜 지정
        fbCategory.setInsertTime(localDateTime.format(formatter));

        fbCategoryRepository.save(fbCategory);

        return true;
    }

    public Page<FbCategory> findAllFbCtitleDesc(String fbCtitle, Pageable pageable) {

        Page<FbCategory> fbCategoryPage = fbCategoryRepository.findAllByFbCtitleContainingOrderByInsertTimeDesc(fbCtitle, pageable);
        return fbCategoryPage;
    }

    // 전체 조회시 실행될 메소드
    public List<FbCategory> findAll() {

        List<FbCategory> fbCategoryList = fbCategoryRepository.findAll();
        return fbCategoryList;
    }

    // 삭제시 실행될 메소드
    public boolean removeById(String fbCid) {

        if (fbCategoryRepository.existsById(fbCid)) {
            fbCategoryRepository.deleteById(fbCid);
            return true;
        }
        return false;
    }
}
