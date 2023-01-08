package com.example.simpledms.service.community;

import com.example.simpledms.model.community.BbComment;
import com.example.simpledms.repository.community.BbCommentRepository;
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
public class BbCommentService {

    @Autowired
    BbCommentRepository bbCommentRepository;

    // 전체 조회 함수
    public List<BbComment> findCommentAll(int bno) {
        List<BbComment> list = bbCommentRepository.findCommentAll(bno);

        return list;
    }

    // 전체 삭제 함수
    public void removeAll() {
        bbCommentRepository.deleteAll(); // 전체 삭제
    }

    // 정보 저장/수정 함수
    public BbComment save(BbComment bbComment) {

        BbComment bbComment2 = bbCommentRepository.save(bbComment);

        return bbComment2;
    }

    // 번호(commentId)로 조회하는 함수
    public Optional<BbComment> findById(int commentId) {
    // findById(기본키속성)
        Optional<BbComment> optionalBbComment = bbCommentRepository.findById(commentId);

        return optionalBbComment;
    }

    // 번호(commentId)로 삭제하는 함수
    public boolean removeById(int commentId) {
    // existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(bbCommentRepository.existsById(commentId) == true) {
            bbCommentRepository.deleteById(commentId);
            return true;
        }

    //  없으면 그냥 false 리턴
        return false;
    }

}









