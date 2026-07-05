package com.project.mybatis_blogwebsite.service;

import com.project.mybatis_blogwebsite.dto.Users;
import com.project.mybatis_blogwebsite.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public List<Users> 전체유저조회기능(){
        // 지금은 우리가 추가적으로 커스텀할 자바 로직이 없기 때문에
        // 단조롭게 작성하지만 나중에는 여기가 제일 코드가 긴 구간
        // 보안 / 정규식 / 인증과 같은 세부 로직을 여기서 추가
        return userMapper.유저전체();
    }
}
