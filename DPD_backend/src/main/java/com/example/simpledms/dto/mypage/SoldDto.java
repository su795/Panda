package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : SoldDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 내 판매목록 dto
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */

public interface SoldDto {
//    user.userNum == goods.sellerId

    //    User 클래스 getter
    Integer getId();    //유저 NO
    String getUsername();    //유저 ID


    //    goods 클래스 getter
    Integer getGoodsId();   //상품 NO
    String getSellerId();   //판매자 NO
    String getStatus();      //판매상태
    String getCategory(); //카테고리번호
    String getTitle(); //제목
    String getInsertTime();  //생성날짜


}