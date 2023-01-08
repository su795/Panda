package com.example.simpledms.service.community;

import com.example.simpledms.model.community.LbComment;
import com.example.simpledms.repository.community.LbCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : LbCommentService
 * author : ds
 * date : 2022-10-20
 * description : 분실게시판 댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class LbCommentService {

    @Autowired
    LbCommentRepository lbCommentRepository;

    // 전체 조회 함수
    public List<LbComment> findCommentAll(int lno) {
        List<LbComment> list = lbCommentRepository.findCommentAll(lno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        lbCommentRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public LbComment save(LbComment lbComment) {

        LbComment lbComment2 = lbCommentRepository.save(lbComment);

        return lbComment2;
    }

    // 번호(commentId)로 조회하는 함수
    public Optional<LbComment> findById(int commentId) {
    // findById(기본키속성)
        Optional<LbComment> optionalLbComment = lbCommentRepository.findById(commentId);

        return optionalLbComment;
    }

    // 번호(commentId)로 삭제하는 함수
    public boolean removeById(int commentId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(lbCommentRepository.existsById(commentId) == true) {
            lbCommentRepository.deleteById(commentId);
            return true;
        }

    //  없으면 그냥 false 리턴
        return false;
    }

}









