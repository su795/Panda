package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : UserRoleDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 내가 쓴 글 자유게시판 dto 자유게시판
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */
public interface WroteDto {
    //    User 클래스 getter
    String getNick();    //유저 닉네임
    String getUsername();    //유저 ID

    //    자유게시판(fb) 클래스 getter
    Integer getFno(); // 글번호
    String getFbTitle(); // 글제목
    String getFbCategory(); // 카테고리
    String getInsertTime();  //생성날짜


}
