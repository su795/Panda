package com.example.simpledms.service.community;

import com.example.simpledms.model.community.LbCategory;
import com.example.simpledms.repository.community.LbCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * packageName : com.example.backedu.service
 * fileName : LbCategoryService
 * author : kangtaegyung
 * date : 2022/07/29
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/29         kangtaegyung          최초 생성
 */
@Service
public class LbCategoryService {

    @Autowired
    LbCategoryRepository lbCategoryRepository;

    // 등록시 실행될 메소드
    public boolean createLbCategory(LbCategory lbCategory) {

        // id 중복 체크
        if( lbCategory.getLbCid() != null) {
            boolean bResult = lbCategoryRepository.existsById(lbCategory.getLbCid());

//            id 중복 체크
            if(bResult) return false;

        }

//        생성 날짜 지정을 위한 날짜 라이브러리 가져오기
        LocalDateTime localDateTime = LocalDateTime.now();
//            시간 형태 지정 : 예) 2022-07-28 15:02:45
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH24:MI:SS");

//        생성 날짜 지정
        lbCategory.setInsertTime(localDateTime.format(formatter));

        lbCategoryRepository.save(lbCategory);

        return true;
    }

    public Page<LbCategory> findAllLbCtitleDesc(String lbCtitle, Pageable pageable) {

        Page<LbCategory> lbCategoryPage = lbCategoryRepository.findAllByLbCtitleContainingOrderByInsertTimeDesc(lbCtitle, pageable);
        return lbCategoryPage;
    }

    // 전체 조회시 실행될 메소드
    public List<LbCategory> findAll() {

        List<LbCategory> lbCategoryList = lbCategoryRepository.findAll();
        return lbCategoryList;
    }

    // 삭제시 실행될 메소드
    public boolean removeById(String lbCid) {

        if (lbCategoryRepository.existsById(lbCid)) {
            lbCategoryRepository.deleteById(lbCid);
            return true;
        }
        return false;
    }
}
