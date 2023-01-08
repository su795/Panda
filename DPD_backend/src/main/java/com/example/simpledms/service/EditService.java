package com.example.simpledms.service;

import com.example.simpledms.model.User;
import com.example.simpledms.repository.EditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : UserService
 * author : ds
 * date : 2022-12-21
 * description : 관리자의 유저 수정 service
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-21         ds          최초 생성
 */
@Service
public class EditService {
    @Autowired
    EditRepository editRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = editRepository.findAll(pageable);

        return page;
    }

    // 전체 삭제 함수
    public void removeAll() {
        editRepository.deleteAll();
    }

    //   회원 정보 저장 함수
    public User save(User user) {

        User user2 = editRepository.save(user);

        return user2;
    }

    //    유저 no로 조회하는 함수
//    Optional 객체 : null 방지 객체
//    주요 함수 : .get() - 안에 있는 객체 꺼내기 함수
//              .isPresent() - 안에 객체 있어요? 있으면  true, 없으면 false
    public Optional<User> findById(int userNum) {
//        findById(기본키속성)
        Optional<User> optionalUser = editRepository.findById(userNum);

        return optionalUser;
    }

    // no(eno)로 삭제하는 함수
    public boolean removeById(int userNum) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(editRepository.existsById(userNum) == true) {
            editRepository.deleteById(userNum);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }


    //    id like 검색 함수
    public Page<User> findAllByUsernameContaining(String username, Pageable pageable) {
        Page<User> page = editRepository.findAllByUsernameContaining(username, pageable);

        return page;
    }
}
