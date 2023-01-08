package com.example.simpledms.dto.filedb;

import lombok.*;

/**
 * packageName : com.example.simpledms.dto.filedb
 * fileName : ResponseFileDto
 * author : ds
 * date : 2022-11-10
 * description : FileDb DTO
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-10         ds          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFileDto {
    private Integer goodsId;
    private String Category;
    private String Title;
    private Integer SellPrice;
    private String SellerId;
    private String InsertTime;
    private String Status;
    private String Tag;
    private String Address;

    private String sellingAreaId;

    private String description;
    private Integer viewCount;

//    가공된 속성
    private Integer fileSize; // 이미지 크기
    private String fileUrl;   // 이미지 다운로드 URL
}







