package com.example.simpledms.service;

import com.example.simpledms.dto.mypage.*;
import com.example.simpledms.model.User;
import com.example.simpledms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : UserService
 * author : ds
 * date : 2022-12-16
 * description : User 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-16         정도훈          최초 생성
 */
@Service
public class UserService {
    //    CRUD 함수 사용을 위한 Repository 불러오기
    @Autowired
    UserRepository userRepository;

    //    초기 상품 화면을 위한 전체 불러오기(페이징)
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);

        return page;
    }


    //    id 로 내 글 목록 조회 함수

    //    상품 저장 함수/수정
    public User save(User user) {

        User user2 = userRepository.save(user);

        return user2;
    }

    //    상품번호로 조회하는 함수
    public Optional<User> findById(Long id) {
//        findById(기본키속성)
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser;
    }

    // 상품번호(userId)로 삭제하는 함수
    public boolean removeById(Long id) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if (userRepository.existsById(id) == true) {
            userRepository.deleteById(id);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }


    // 판매내역 조회 함수
    public List<SoldDto> findGoodByUsername(String username) {
        List<SoldDto> list = userRepository.findGoodByUsername(username);

        return list;
    }



    // 글쓴내역 조회 함수
    //    닉네임으로(Nick) 로 자유게시판 글쓴내역 조회하는 함수
    public List<WroteDto> findFbByNick(String nick) {
        List<WroteDto> list = userRepository.findFbByNick(nick);

        return list;
    }

    //    닉네임으로(Nick) 로 모임게시판 글쓴내역 조회하는 함수
    public List<WroteMbDto> findMbByNick(String nick) {
        List<WroteMbDto> list = userRepository.findMbByNick(nick);

        return list;
    }

    //    닉네임으로(Nick) 로 추천게시판 글쓴내역 조회하는 함수
    public List<WroteBbDto> findBbByNick(String nick) {
        List<WroteBbDto> list = userRepository.findBbByNick(nick);

        return list;
    }

    //    닉네임으로(Nick) 로 분실게시판 글쓴내역 조회하는 함수
    public List<WroteLbDto> findLbByNick(String nick) {
        List<WroteLbDto> list = userRepository.findLbByNick(nick);

        return list;
    }



}
