package com.example.simpledms.repository;

import com.example.simpledms.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.example.simplelogin.repository
 * fileName : UserRepository
 * author : ds
 * date : 2022-11-29
 * description : 유저 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-29         ds          최초 생성
 */
// JpaRepository<모델명, 모델기본키타입>
@Repository
public interface EditRepository extends JpaRepository<User, Integer> {

    //    쿼리메소드
//    userId(로그인id) 으로 조회하는 함수
    Page<User> findAllByUsernameContaining(String username, Pageable pageable);


}




