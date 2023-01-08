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
public class FbDto {

    private Integer fno;
    private String nick;
    private String fbTitle;
    private String fbContent;
    private Integer fbCnt;
    private String fbCategory;
    private Integer fbRcnt;
    private Integer fbLike;
    private String fbTag;
    private String fileName;
    private byte[] blobFile;

    private String fileType;
    private Integer fileSize; // 이미지 크기
    private String fileUrl; // 이미지 다운로드 URL

    private String fbCid;

    private String fbCtitle;

    private String insertTime;

    private String deleteYn;

    private String deleteTime;

}

