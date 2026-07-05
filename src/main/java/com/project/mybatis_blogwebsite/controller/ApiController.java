package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
백엔드 개발자는
@Controller를 쓸 일이 거의 없다.
@RestController 주로 사용한다.
html css js 관리할 일이 없기 때문에 프론트엔드에
개발자들끼리 약속한 api 경로로 데이터를 전달해주면 되는 것1

초보 개발자
a-z 다 만든다음에 잘 되는지 확인xxxx
1. DataBase ↔ springboot 연결이 잘 되었는지
   아래와 같은 방법으로 확인
   /api/posts
   에서는 데이터가 잘 넘어가는지 확인되었다.
   [
  {
    "id": 1,
    "title": "첫 번째 글",
    "content": "안녕하세요"
  },
  {
    "id": 2,
    "title": "두 번째 글",
    "content": "mybatis로 연습 중 입니다."
  }
]

두 번 째로 controller 와 index.html을 연결해서 데이터를 프론트엔드 코드로
전달하여 controller ↔ index.html 연결간의 변수이름 작성을 잘못하지는 않았는지
와 같은 문제를 확인하며 에러를 해결할 수 있다.
 */
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class ApiController {

    private final PostService postService;

    @GetMapping
    public List<Post> apiGetAllPosts(){
        return postService.모두조회();
    }
}
