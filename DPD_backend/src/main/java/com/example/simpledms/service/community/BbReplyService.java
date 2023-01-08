package com.example.simpledms.service.community;

import com.example.simpledms.model.community.BbReply;
import com.example.simpledms.repository.community.BbReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : BbReplyService
 * author : ds
 * date : 2022-10-20
 * description : 추천게시판 대댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class BbReplyService {

    @Autowired
    BbReplyRepository bbReplyRepository;

    // 전체 조회 함수
    public List<BbReply> findReplyAll(int bno) {
        List<BbReply> list = bbReplyRepository.findReplyAll(bno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        bbReplyRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public BbReply save(BbReply bbReply) {

        BbReply bbReply2 = bbReplyRepository.save(bbReply);

        return bbReply2;
    }

    // 번호(replyId)로 조회하는 함수
    public Optional<BbReply> findById(int replyId) {
    // findById(기본키속성)
        Optional<BbReply> optionalBbReply = bbReplyRepository.findById(replyId);

        return optionalBbReply;
    }

    // 번호(replyId)로 삭제하는 함수
    public boolean removeById(int replyId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(bbReplyRepository.existsById(replyId) == true) {
            bbReplyRepository.deleteById(replyId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









