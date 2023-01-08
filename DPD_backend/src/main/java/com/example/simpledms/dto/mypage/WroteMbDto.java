package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : UserRoleDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 내가 쓴 글 모임게시판 dto
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */
public interface WroteMbDto {
    //    User 클래스 getter
    String getNick();    //유저 닉네임
    String getUsername();    //유저 ID

    //    모임게시판(Mb) 클래스 getter
    Integer getMno(); // 글번호
    String getMbTitle(); // 글제목
    String getMbCategory(); // 카테고리
    String getInsertTime();  //생성날짜


}
