package com.example.simpledms.service.community;

import com.example.simpledms.model.community.FbReply;
import com.example.simpledms.repository.community.FbReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : FbReplyService
 * author : ds
 * date : 2022-10-20
 * description : 자유게시판 대댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class FbReplyService {

    @Autowired
    FbReplyRepository fbReplyRepository;

    // 전체 조회 함수
    public List<FbReply> findReplyAll(int fno) {
        List<FbReply> list = fbReplyRepository.findReplyAll(fno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        fbReplyRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public FbReply save(FbReply fbReply) {

        FbReply fbReply2 = fbReplyRepository.save(fbReply);

        return fbReply2;
    }

    // 번호(replyId)로 조회하는 함수
    public Optional<FbReply> findById(int replyId) {
    // findById(기본키속성)
        Optional<FbReply> optionalFbReply = fbReplyRepository.findById(replyId);

        return optionalFbReply;
    }

    // 번호(replyId)로 삭제하는 함수
    public boolean removeById(int replyId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(fbReplyRepository.existsById(replyId) == true) {
            fbReplyRepository.deleteById(replyId);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









