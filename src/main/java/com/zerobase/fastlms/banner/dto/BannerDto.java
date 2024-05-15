package com.zerobase.fastlms.banner.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class BannerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String bannerName;

    String filename;
    String urlFilename;

    long openValue; // 오픈 방법
    long sortValue; // 정렬 순서
    boolean publicYn; // 공개 비공개

    LocalDateTime regDate;

    long totalCount;
    long seq;

}
