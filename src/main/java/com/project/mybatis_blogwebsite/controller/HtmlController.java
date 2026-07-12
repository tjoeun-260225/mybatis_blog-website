package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        // 만약 글작성을 완료하고 다시 글쓰기 페이지로 이동시키고 싶다면
        // "redirect:/new" 를 작성하는 것이 아니라
        // "redirect:/api/posts/new" 처럼 new.html 을 볼 수 있는
        //             주소를 작성해주어야 한다.
    }

    // 풀스택 기반으로 수정 삭제 컨트롤러 만들기
    // 수정할 포스트 화면 보여주기
    // 먼저 포스트를 클릭했을 때 어떤 id 의 포스터를 수정할 것인지 선택
    // 소비자가 클릭한 포스팅 id 가 url 내부 들어갈 것
    // 소비자가 선택한 id에 해당하는 데이터를 sql에서 아이디조회 라는
    // 기능으로 가져오기
    @GetMapping("posts/{id}/edit")
    public String 수정폼(@PathVariable Long id, Model model){
        model.addAttribute("post", postService.아이디조회(id));
        return "edit";
    }
    // edit.html 아이디조회 생성 글수정기능 삭제기능 완성

    // 수정 폼에서 제출된 데이터로 실제 수정 처리
    @PostMapping("/posts/{id}/edit")
    public String 글수정기능(@PathVariable Long id, Post post) {
        // AI 를 이용한 코딩으로 작업할 경우
        // AI MVC 패턴 규칙에 맞지 않게 코딩을 줄 가능성이 높다.
        // post.setId(id) html에서 받은 id 를 사용하는 로직을 추가
        // 위와 같은 작업은 모두다 service 에서 진행한다.
        // controller 에서는 setter getter 의 기능을 사용할 일이 거의 없다.
        postService.수정하기(id,post);
        return "redirect:/";

    }

//    @PostMapping("/posts/{id}/delete")
    @GetMapping("/posts/{id}/delete")
    public String 글삭제기능(@PathVariable Long id) {
        postService.삭제하기(id);
        return "redirect:/";
    }
}
