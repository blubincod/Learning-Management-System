package com.zerobase.fastlms.admin.controller;


import com.zerobase.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.admin.model.CategoryInput;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.admin.service.CategoryService;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminBannerController {

//    private final CategoryService categoryService;

    @GetMapping("/admin/banner/list.do")
    public String list() {

//        List<CategoryDto> list = categoryService.list();
//        model.addAttribute("list", list);

        return "admin/banner/list";
    }


    @GetMapping(value = {"/admin/banner/add.do", "/admin/banner/edit.do"})
    public String add() {

        //카테고리 정보를 내려줘야 함.
//        model.addAttribute("category", categoryService.list());

//        boolean editMode = request.getRequestURI().contains("/edit.do");
//        CourseDto detail = new CourseDto();

//        if (editMode) {
//            long id = parameter.getId();
//            CourseDto existCourse = courseService.getById(id);
//            if (existCourse == null) {
//                // error 처리
//                model.addAttribute("message", "강좌정보가 존재하지 않습니다.");
//                return "common/error";
//            }
//            detail = existCourse;
//        }
//
//        model.addAttribute("editMode", editMode);
//        model.addAttribute("detail", detail);

        return "admin/banner/add";
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
