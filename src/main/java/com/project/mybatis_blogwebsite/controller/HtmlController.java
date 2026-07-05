package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// controller.HtmlController
@Controller
@RequiredArgsConstructor
public class HtmlController {

    private  final PostService postService;

    @GetMapping
    // springframework.ui.Model
    public String 메인페이지(Model model){
        model.addAttribute(
                "posts",
                postService.모든게시물_SQL에서_가져오는기능()
        );
        return "index";
    }
}
