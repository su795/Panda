package com.example.simpledms.dto.community;

public interface LbCategoryDto {
    // TB_LB
    Integer getLno();
    String getNick();
    String getLbTitle();
    String getLbContent();

    Integer getLbCnt();
    String getLbCategory();

    Integer getLbRcnt();
    Integer getLbLike();
    String getLbTag();

    String getFileName();
    //    업로드 이미지

    // TB_LB_CATEGORY
    String getLbCid();
    String getLbCtitle();

    String getFileUrl(String fileDownloadUri);
    String setFileUrl(String fileDownloadUri);

    String getInsertTime();

    byte[] getBlobFile();

    Integer setFileSize(int fileSize);

}
