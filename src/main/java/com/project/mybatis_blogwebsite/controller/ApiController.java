package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts") // 하위 url 경로 맨 앞에는
// 무조건 /api/posts를 붙인 상태가 된다.
@RequiredArgsConstructor
public class ApiController {

    private final PostService postService;

    @GetMapping
    public List<Post> apiGetAllPosts(){
        return postService.모두조회();
    }
}
