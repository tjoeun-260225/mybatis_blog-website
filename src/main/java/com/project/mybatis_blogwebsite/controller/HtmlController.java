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
    @GetMapping("/posts/{id}/edit")
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
/*
@GetMapping("/posts/{id}/delete")
@PathVariable Long id
- URL 경로에 포함된 값을 메서드 파라미터로 받아올 때 사용하는 어노테이션

위 코드에서 /posts/1/delete 로 요청하면 id 에 1 이 담겨서 전달된다.
@PathVariable Long id
위의 경우 id 값을 필수로 전달받아야 하는 주소

아래의 경우 id 값을 생략해서 프론트엔드로 전달받아 되는 주소
- 만약 프론트엔드에서 클릭한 데이터가 null 일 경우
  service 에서 알아서 null 일 경우를 처리하여 전달
@PathVariable(required=false) Long id
/{}/
@RequestParam
?
 */
/*
HTTP method
HTTP 메서드는 클라이언트가 서버에게 어떤 동작을 요청하는지 나타내는 방식
GET
 - 용도 : 리소스 조회(데이터 가져오기)
 - 특징 : 서버 상태를 변경하지 않음(안전)
 - 여러 번 처리해도 결과 동일
 - 웹 페이지 접속, 게시글 목록 조회
   로그인의 경우 회사마다 방향성이 다르며, GET 을 사용하는 회사도 존재
   1. 예전 시스템으로 사용할 때 (보안 안됨)
   2. OAuth 인증 흐름 : 소셜 로그인(구글, 카카오 등) 에서는 인증코드를 주고 받을 때
      비밀번호가 아니라 임시 토큰/코드 만 오가므로 단순히 주고 받는 용도에서 사용
POST
 - 용도 : 새로운 리소스 생성, 데이터 제출
 - 특징 : 서버 상태를 변경함
 - 같은 요청을 여러 번 보내면 여러번 데이터가 저장될 수 있다.
 - 예시 : 회원가입, 게시글 작성, 로그인

PUT
 - 용도 : 리소스 전체 수정(덮어쓰기와 같이 수정작업 진행)
 - 특징 : 지정한 리소스를 통째로 교체
 - 같은 요청을 여러 번 보내도 결과 동일
 - 사용자 프로필 전체 정보 업데이트
 - 게시물 전체 수정하여 전체 업데이트

PATCH
 - 용도 : 리소스의 일부만 수정
 - 수정이 필요한 필드만 부분적으로 변경
 - 구현에 따라 여러 번 변경될 수 있으며
 - 비밀번호만 수정, 이메일만 수정, 배송지만 수정, 닉네임만 수정
 특정 목적을 가지고 부분적으로 수정할 때
 개발자가 원하는 범위를 부분적으로 수정할 때 사용

DELETE
 - 용도 : 리소스 삭제
 - 특징 : 지정한 리소스 제거
 - 게시글 삭제, 계정 삭제 이나
   실제로 삭제하는 회사는 없음...
   컬럼에서 보이기
   위에서는 삭제가 SQL 에서 되는 것을 보기 위하여 가볍게 GetMapping 을 사용했지만
   보통은 Patch나 put 을 이용하여 소비자에게 제거된 것처럼 보이게 처리

HEAD
 - 용도 : GET 과 동일하지만 응답 본문(body) 없이 헤더만 받음
 - 예시 : 리소스 존재 여부나 메타 데이터만 확인할 때 사용

OPTION
 - 용도 : 서버가 지원하는 메서드나 CORS 설정 확인
HEAD OPTION 은 그렇게까지 사용하지 않음
 */






