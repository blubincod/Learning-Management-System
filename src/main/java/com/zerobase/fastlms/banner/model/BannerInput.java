package com.zerobase.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {

    long id;

    String bannerName;
    String linkAddr;

    String filename;
    String urlFilename;

    long openValue; // 오픈 방법
    long sortValue; // 정렬 순서
    boolean publicYn; // 공개 비공개

    String idList;
}
