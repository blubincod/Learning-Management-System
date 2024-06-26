package com.zerobase.fastlms.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String bannerName;
    String linkAddr;

    String filename;
    String urlFilename;

    long openValue; // 오픈 방법
    long sortValue; // 정렬 순서
    boolean publicYn; // 공개 비공개

    LocalDateTime regDate;
    LocalDateTime uptDate;

}
