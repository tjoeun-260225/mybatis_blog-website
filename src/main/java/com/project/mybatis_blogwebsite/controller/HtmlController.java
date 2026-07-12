package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// controller.HtmlController
@Controller
@RequiredArgsConstructor
public class HtmlController {
    private  final PostService postService;
    @GetMapping("/")
    // springframework.ui.Model
    public String 메인페이지(Model model){
        // 풀스택 개발자는 이렇게 하는게 맞음
        model.addAttribute(
                "posts",
                postService.모두조회()
        );
        return "index";
    }
    /*
    <a href="/posts/new">
        <button type="button">새 글쓰기</button>
    </a>
    여기까지는 html ~ controller 흐름 연결
    백엔드 연결은
    dto → mapper.java → mapper.xml → service.java → controller.java
    처음부터 진행할 때는 위와 같은 형태로 작업한다.
    이후부터는 본인이 필요한 상황에 따라 알아서 작업을 진행한다.
    예를 들어 dto 는 완성되었다.
    mapper.java ~~~ controller 까지 작업
     */
    @GetMapping("/posts/new")
    public String 글쓰기폼(){
        // 새 글쓰기를 클릭했을 때
        // src/main/resources/templates/new.html 화면에 보여줌
        return "new";
    }

    //  풀스택 개발자가 데이터 저장하고
    // 저장한 후 페이지 이동하는 방법
    @PostMapping("/api/posts/new")
    public String 글작성기능(Post post) {
        postService.글쓰기(post);
        return "redirect:/";
    }
}
