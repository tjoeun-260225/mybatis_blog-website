package com.project.mybatis_blogwebsite.controller;

import com.project.mybatis_blogwebsite.dto.Users;
import com.project.mybatis_blogwebsite.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/users")
    public List<Users> 유저전체조회확인(){
        return userService.전체유저조회기능();
    }
}
