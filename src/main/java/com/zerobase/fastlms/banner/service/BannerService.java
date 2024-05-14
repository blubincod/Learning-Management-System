package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;

import java.util.List;

public interface BannerService {

    /***
     * 배너 등록
     * @param parameter
     * @return
     */
    boolean add(BannerInput parameter);

    /***
     * 배너 삭제
     * @param parameter
     * @return
     */
    boolean del(String parameter);

    /**
     * 배너 목록
     * @param parameter
     * @return
     */
    List<BannerDto> list(BannerParam parameter);
}
