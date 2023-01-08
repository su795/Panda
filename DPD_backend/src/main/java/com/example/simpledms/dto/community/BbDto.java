package com.example.simpledms.dto.community;

import lombok.*;

/**
 * packageName : com.example.simpledms.dto
 * fileName : BbDto
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
public class BbDto {

    private Integer bno;
    private String nick;
    private String bbTitle;
    private String bbContent;
    private Integer bbCnt;
    private String bbCategory;
    private Integer bbRcnt;
    private Integer bbLike;
    private String bbTag;
    private String fileName;
    private byte[] blobFile;

    private String fileType;
    private Integer fileSize; // 이미지 크기
    private String fileUrl; // 이미지 다운로드 URL

    private String bbCid;

    private String bbCtitle;

    private String insertTime;

    private String deleteYn;

    private String deleteTime;

}

