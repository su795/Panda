package com.example.simpledms.service.community;

import com.example.simpledms.model.community.MbComment;
import com.example.simpledms.repository.community.MbCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : MbCommentService
 * author : ds
 * date : 2022-10-20
 * description : 모임게시판 댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class MbCommentService {

    @Autowired
    MbCommentRepository mbCommentRepository;

    // 전체 조회 함수
    public List<MbComment> findCommentAll(int mno) {
        List<MbComment> list = mbCommentRepository.findCommentAll(mno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        mbCommentRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public MbComment save(MbComment mbComment) {

        MbComment mbComment2 = mbCommentRepository.save(mbComment);

        return mbComment2;
    }

    // 번호(commentId)로 조회하는 함수
    public Optional<MbComment> findById(int commentId) {
    // findById(기본키속성)
        Optional<MbComment> optionalMbComment = mbCommentRepository.findById(commentId);

        return optionalMbComment;
    }

    // 번호(commentId)로 삭제하는 함수
    public boolean removeById(int commentId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(mbCommentRepository.existsById(commentId) == true) {
            mbCommentRepository.deleteById(commentId);
            return true;
        }

    //  없으면 그냥 false 리턴
        return false;
    }

}









