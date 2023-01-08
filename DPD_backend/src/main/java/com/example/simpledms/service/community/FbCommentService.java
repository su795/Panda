package com.example.simpledms.service.community;

import com.example.simpledms.model.community.FbComment;
import com.example.simpledms.repository.community.FbCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : FbCommentService
 * author : ds
 * date : 2022-10-20
 * description : 자유게시판 댓글 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class FbCommentService {

    @Autowired
    FbCommentRepository fbCommentRepository;

    // 전체 조회 함수
    public List<FbComment> findCommentAll(int fno) {
        List<FbComment> list = fbCommentRepository.findCommentAll(fno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        fbCommentRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public FbComment save(FbComment fbComment) {

        FbComment fbComment2 = fbCommentRepository.save(fbComment);

        return fbComment2;
    }

    // 번호(commentId)로 조회하는 함수
    public Optional<FbComment> findById(int commentId) {
    // findById(기본키속성)
        Optional<FbComment> optionalFbComment = fbCommentRepository.findById(commentId);

        return optionalFbComment;
    }

    // 번호(commentId)로 삭제하는 함수
    public boolean removeById(int commentId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(fbCommentRepository.existsById(commentId) == true) {
            fbCommentRepository.deleteById(commentId);
            return true;
        }

    //  없으면 그냥 false 리턴
        return false;
    }

}









