package com.example.simpledms.dto.mypage;

/**
 * packageName : com.example.simpledms.dto.response
 * fileName : SoldDto
 * author : ds
 * date : 2022-11-30
 * description : 마이페이지 - 가계부 dto
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-30         ds          최초 생성
 */

public interface AccountBookDto {
//    user.userNum == goods.sellerId

    //    User 클래스 getter
    String getNick();    //유저 닉네임


    //    goods 클래스 getter
    Integer getSellPrice();   //상품 가격
    String getSellerId();   //판매자 NO
    String getStatus();      //판매상태 -> 판매완료
    String getInsertTime();  //생성날짜 -> 검색함수 20xx-xx



}
