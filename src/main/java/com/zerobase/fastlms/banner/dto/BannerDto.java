package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    LocalDateTime udtDate;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .openValue(banner.getOpenValue())
                .sortValue(banner.getSortValue())
                .publicYn(banner.isPublicYn())
                .regDate(banner.getRegDate())
                .udtDate(banner.getUptDate())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .build();
    }
}
