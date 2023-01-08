package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : UserRoleDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 구매목록 dto
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */
public interface OnSaleDto {
    //    User 클래스 getter
    Integer userNum();    //유저번호
    //    goods 클래스 getter
    Integer sellerId();   //유저번호

    String userId(); //판매자아이디
    Integer categoryId(); //카테고리번호
    String title(); //제목

    String insertTime();  //생성날짜

}
