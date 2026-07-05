package com.project.mybatis_blogwebsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class 삭제할Controller {
//    이 경로가 살아있으면 ApiController에 존재하는
//    GetMapping과 충돌나서 스프링부트 자체가 실행되지 않는다.
//    @GetMapping("/api/posts")
//    public String 삭제할기능(){
//        return "안녕하세요. 실행 안되시죠^^";
//    }
}
/*
com.project.mybatis_blogwebsite.controller.삭제할Controller#삭제할기능()
to {GET [/api/posts]}: There is already 'apiController' bean method
 */