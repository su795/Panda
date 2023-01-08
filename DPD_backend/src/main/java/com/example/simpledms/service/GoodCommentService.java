package com.example.simpledms.service;

import com.example.simpledms.model.Diary;
import com.example.simpledms.model.GoodComment;
import com.example.simpledms.repository.DiaryRepository;
import com.example.simpledms.repository.GoodCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DiaryService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class GoodCommentService {

    @Autowired
    GoodCommentRepository goodCommentRepository;

    //    전체 조회 함수
    public List<GoodComment> findCommentAll(int goodsId) {
        List<GoodComment> list = goodCommentRepository.findCommentAll(goodsId);

        return list;
    }

    //   전체 삭제 함수
    public void removeAll() {
        goodCommentRepository.deleteAll(); // 전체 삭제
    }

    //   정보 저장/수정 함수
    public GoodComment save(GoodComment goodComment) {

        GoodComment goodComment2 = goodCommentRepository.save(goodComment);

        return goodComment2;
    }

    //    다이어리 번호로 조회하는 함수
    public Optional<GoodComment> findById(int commentId) {
//        findById(기본키속성)
        Optional<GoodComment> optionalGoodComment = goodCommentRepository.findById(commentId);

        return optionalGoodComment;
    }

    // 번호(dno)로 삭제하는 함수
    public boolean removeById(int coomentId) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(goodCommentRepository.existsById(coomentId) == true) {
            goodCommentRepository.deleteById(coomentId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









