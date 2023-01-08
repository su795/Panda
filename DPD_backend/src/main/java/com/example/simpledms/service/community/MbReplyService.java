package com.example.simpledms.service.community;

import com.example.simpledms.model.community.MbReply;
import com.example.simpledms.repository.community.MbReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : MbReplyService
 * author : ds
 * date : 2022-10-20
 * description : 모임게시판 대댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class MbReplyService {

    @Autowired
    MbReplyRepository mbReplyRepository;

    // 전체 조회 함수
    public List<MbReply> findReplyAll(int mno) {
        List<MbReply> list = mbReplyRepository.findReplyAll(mno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        mbReplyRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public MbReply save(MbReply mbReply) {

        MbReply mbReply2 = mbReplyRepository.save(mbReply);

        return mbReply2;
    }

    // 번호(replyId)로 조회하는 함수
    public Optional<MbReply> findById(int replyId) {
    // findById(기본키속성)
        Optional<MbReply> optionalMbReply = mbReplyRepository.findById(replyId);

        return optionalMbReply;
    }

    // 번호(replyId)로 삭제하는 함수
    public boolean removeById(int replyId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(mbReplyRepository.existsById(replyId) == true) {
            mbReplyRepository.deleteById(replyId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









