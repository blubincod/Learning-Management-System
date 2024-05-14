package com.zerobase.fastlms.banner.controller;


import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.banner.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController extends BaseController {

    private final BannerService bannerService;

    @GetMapping("/admin/banner/list.do")
    public String list(Model model, BannerParam parameter) {

        parameter.init();

        List<BannerDto> bannerList = bannerService.list(parameter);

        long totalCount = 0;

        if (!CollectionUtils.isEmpty(bannerList)) {
            totalCount = bannerList.get(0).getTotalCount();
        }

        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);


        model.addAttribute("list", bannerList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/banner/list";
    }

    @GetMapping("/admin/banner/add.do")
    public String add(Model model) {

        return "admin/banner/add";
    }

    @PostMapping("/admin/banner/add.do")
    public String addSubmit(Model model, BannerInput parameter, MultipartFile file) {

        boolean result = bannerService.add(parameter);

//        if (file != null) {
//            String localPath = "/Users/jyp/Documents/Rocket/Backend/Spring/Practice/fastlms3/files";
//
//            try {
//                File newFile = new File(localPath);
//                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(newFile));
//            } catch (IOException e) {
//                log.info("######################## - 1");
//                e.printStackTrace();
//            }
//        }

        return "redirect:/admin/banner/list.do";
    }

//
//    @PostMapping("/admin/category/delete.do")
//    public String del(Model model, CategoryInput parameter) {
//
//        boolean result = categoryService.del(parameter.getId());
//
//        return "redirect:/admin/category/list.do";
//    }
//
//    @PostMapping("/admin/category/update.do")
//    public String update(Model model, CategoryInput parameter) {
//
//        boolean result = categoryService.update(parameter);
//
//        return "redirect:/admin/category/list.do";
//    }

}
