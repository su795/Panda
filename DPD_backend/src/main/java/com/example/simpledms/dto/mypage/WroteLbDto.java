package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : UserRoleDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 내가 쓴 글 분실게시판 dto 분실게시판
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */
public interface WroteLbDto {
    //    User 클래스 getter
    String getNick();    //유저 닉네임
    String getUsername();    //유저 ID


    //    분실게시판(Lb) 클래스 getter
    Integer getLno(); // 글번호
    String getLbTitle(); // 글제목
    String getLbCategory(); // 카테고리
    String getInsertTime();  //생성날짜

}
