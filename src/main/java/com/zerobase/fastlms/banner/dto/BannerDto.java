package com.zerobase.fastlms.banner.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class BannerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String subject;
    String imagePath; //이미지
    String imageInfo; //이미지 정보
    LocalDate regDate;

    long totalCount;
    long seq;

}
