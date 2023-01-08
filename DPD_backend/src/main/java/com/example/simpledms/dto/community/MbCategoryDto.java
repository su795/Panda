package com.example.simpledms.dto.community;

public interface MbCategoryDto {
    // TB_MB
    Integer getMno();
    String getNick();
    String getMbTitle();
    String getMbContent();

    Integer getMbCnt();
    String getMbCategory();

    Integer getMbRcnt();
    Integer getMbLike();
    String getMbTag();

    String getFileName();
    //    업로드 이미지

    // TB_MB_CATEGORY
    String getMbCid();
    String getMbCtitle();

    String getFileUrl(String fileDownloadUri);
    String setFileUrl(String fileDownloadUri);

    String getInsertTime();

    byte[] getBlobFile();

    Integer setFileSize(int fileSize);

}
