package com.example.simpledms.dto.community;

public interface FbCategoryDto {
    // TB_FB
    Integer getFno();
    String getNick();
    String getFbTitle();
    String getFbContent();

    Integer getFbCnt();
    String getFbCategory();

    Integer getFbRcnt();
    Integer getFbLike();
    String getFbTag();

    String getFileName();
    //    업로드 이미지

    // TB_FB_CATEGORY
    String getFbCid();
    String getFbCtitle();

    String getFileUrl(String fileDownloadUri);
    String setFileUrl(String fileDownloadUri);

    String getInsertTime();

    byte[] getBlobFile();

    Integer setFileSize(int fileSize);

}
