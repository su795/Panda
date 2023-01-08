package com.example.simpledms.service.community;

import com.example.simpledms.model.community.LbReply;
import com.example.simpledms.repository.community.LbReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : LbReplyService
 * author : ds
 * date : 2022-10-20
 * description : 분실게시판 대댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class LbReplyService {

    @Autowired
    LbReplyRepository lbReplyRepository;

    // 전체 조회 함수
    public List<LbReply> findReplyAll(int lno) {
        List<LbReply> list = lbReplyRepository.findReplyAll(lno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        lbReplyRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public LbReply save(LbReply lbReply) {

        LbReply lbReply2 = lbReplyRepository.save(lbReply);

        return lbReply2;
    }

    // 번호(replyId)로 조회하는 함수
    public Optional<LbReply> findById(int replyId) {
    // findById(기본키속성)
        Optional<LbReply> optionalLbReply = lbReplyRepository.findById(replyId);

        return optionalLbReply;
    }

    // 번호(replyId)로 삭제하는 함수
    public boolean removeById(int replyId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(lbReplyRepository.existsById(replyId) == true) {
            lbReplyRepository.deleteById(replyId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









