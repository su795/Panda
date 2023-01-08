package com.example.simpledms.dto.community;

public interface BbCategoryDto {
    // TB_BB
    Integer getBno();
    String getNick();
    String getBbTitle();
    String getBbContent();

    Integer getBbCnt();
    String getBbCategory();

    Integer getBbRcnt();
    Integer getBbLike();
    String getBbTag();

    String getFileName();
    //    업로드 이미지

    // TB_BB_CATEGORY
    String getBbCid();
    String getBbCtitle();

    String getFileUrl(String fileDownloadUri);
    String setFileUrl(String fileDownloadUri);

    String getInsertTime();

    byte[] getBlobFile();

    Integer setFileSize(int fileSize);

}
