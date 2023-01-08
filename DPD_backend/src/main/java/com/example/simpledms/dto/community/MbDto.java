package com.example.simpledms.dto.community;

import lombok.*;

/**
 * packageName : com.example.simpledms.dto
 * fileName : FbDto
 * author : ds
 * date : 2022-12-19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-12-19         ds          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MbDto {

    private Integer mno;
    private String nick;
    private String mbTitle;
    private String mbContent;
    private Integer mbCnt;
    private String mbCategory;
    private Integer mbRcnt;
    private Integer mbLike;
    private String mbTag;
    private String fileName;
    private byte[] blobFile;

    private String fileType;
    private Integer fileSize; // 이미지 크기
    private String fileUrl; // 이미지 다운로드 URL

    private String mbCid;

    private String mbCtitle;

    private String insertTime;

    private String deleteYn;

    private String deleteTime;

}

