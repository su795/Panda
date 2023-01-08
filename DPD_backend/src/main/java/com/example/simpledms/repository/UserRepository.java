package com.example.simpledms.repository;

import com.example.simpledms.dto.mypage.*;
import com.example.simpledms.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  //  oauth2 에서 사용할 함수
//  소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 함수
  Optional<User> findByEmail(String email);


  Page<User> findAllByUsernameContaining(String username, Pageable pageable);

  //  판매내역 조회 쿼리
  @Query(value = "SELECT u.ID as id, u.USERNAME as username, g.GOODS_ID as goodsId, g.SELLER_ID as sellerId, g.STATUS, g.CATEGORY as category, g.TITLE, g.INSERT_TIME as insertTime " +
          "FROM TB_USER u, TB_GOODS g " +
          "WHERE :username = g.SELLER_ID " +
          "AND :username = u.USERNAME " +
          " and g.delete_yn = 'N' " +
          " AND ROWNUM <= 8 ",
          nativeQuery = true)
  List<SoldDto> findGoodByUsername(@Param("username") String username);



//  // 마이페이지 - 글쓴내역 조회 쿼리
//  // @Query, 자유게시판 글쓴내역 조회 함수
//  @Query(value = "SELECT u.NICK, u.USERNAME as username, f.FNO, f.FB_CATEGORY as fbCategory, f.FB_TITLE as fbTitle, f.INSERT_TIME as insertTime " +
//          "FROM TB_USER u, TB_FB f " +
//          "WHERE :nick = f.NICK " +
//          " AND ROWNUM <= 8 ",
//          nativeQuery = true)
//  List<WroteDto> findFbByNick(@Param("nick") String nick);

  // TODO : 마이페이지 목록 여러개 생성 수정 (2023-01-08 유슬기)
  // 마이페이지 - 글쓴내역 조회 쿼리
  // @Query, 자유게시판 글쓴내역 조회 함수
  @Query(value = "SELECT f.NICK, f.FNO, f.FB_CATEGORY as fbCategory, f.FB_TITLE as fbTitle, f.INSERT_TIME as insertTime " +
          "FROM TB_FB f " +
          "WHERE :nick = f.NICK " +
          " AND ROWNUM <= 8 ",
          nativeQuery = true)
  List<WroteDto> findFbByNick(@Param("nick") String nick);


  // @Query, 모임게시판 글쓴내역 조회 함수
  @Query(value = "SELECT u.NICK, u.USERNAME as username, m.MNO, m.MB_CATEGORY as mbCategory, m.MB_TITLE as mbTitle, m.INSERT_TIME as insertTime " +
          "FROM TB_USER u, TB_MB m " +
          "WHERE :nick = m.NICK " +
          " AND ROWNUM <= 8 ",
          nativeQuery = true)
  List<WroteMbDto> findMbByNick(@Param("nick") String nick);


  // @Query, 추천게시판 글쓴내역 조회 함수
  @Query(value = "SELECT u.NICK, u.USERNAME as username, b.BNO, b.BB_CATEGORY as bbCategory, b.BB_TITLE as bbTitle, b.INSERT_TIME as insertTime " +
          "FROM TB_USER u, TB_BB b " +
          "WHERE :nick = b.NICK " +
          " AND ROWNUM <= 8 ",
          nativeQuery = true)
  List<WroteBbDto> findBbByNick(@Param("nick") String nick);


  // @Query, 분실게시판 글쓴내역 조회 함수
  @Query(value = "SELECT u.NICK, u.USERNAME as username, l.LNO, l.LB_CATEGORY as lbCategory, l.LB_TITLE as lbTitle, l.INSERT_TIME as insertTime " +
          "FROM TB_USER u, TB_LB l " +
          "WHERE :nick = l.NICK " +
          " AND ROWNUM <= 8 ",
          nativeQuery = true)
  List<WroteLbDto> findLbByNick(@Param("nick") String nick);

}








