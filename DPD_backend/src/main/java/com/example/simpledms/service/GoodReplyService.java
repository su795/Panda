package com.example.simpledms.service;

import com.example.simpledms.model.GoodReply;
import com.example.simpledms.model.GoodReply;
import com.example.simpledms.repository.GoodReplyRepository;
import com.example.simpledms.repository.GoodReplyRepository;
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
public class GoodReplyService {

    @Autowired
    GoodReplyRepository goodReplyRepository;

    //    전체 조회 함수
    public List<GoodReply> findReplyAll(int goodsId) {
        List<GoodReply> list = goodReplyRepository.findReplyAll(goodsId);

        return list;
    }

    //   전체 삭제 함수
    public void removeAll() {
        goodReplyRepository.deleteAll(); // 전체 삭제
    }

    //   정보 저장/수정 함수
    public GoodReply save(GoodReply goodReply) {

        GoodReply goodReply2 = goodReplyRepository.save(goodReply);

        return goodReply2;
    }

    //    다이어리 번호로 조회하는 함수
    public Optional<GoodReply> findById(int replyId) {
//        findById(기본키속성)
        Optional<GoodReply> optionalGoodReply = goodReplyRepository.findById(replyId);

        return optionalGoodReply;
    }

    // 번호(dno)로 삭제하는 함수
    public boolean removeById(int replyId) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(goodReplyRepository.existsById(replyId) == true) {
            goodReplyRepository.deleteById(replyId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









