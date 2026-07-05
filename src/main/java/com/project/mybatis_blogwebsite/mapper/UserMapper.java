package com.project.mybatis_blogwebsite.mapper;


// import org.apache.catalina.User;
// 100% 유저 테이블에서 유저저장하거나 유저 조회를 할 때
// 개발자가 만든 Users를 가져오는게 아니라
// 스프링 자체에서 무언가 하기위에 만들어 놓은 위 유저를 많이 가져온다.
import com.project.mybatis_blogwebsite.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 우리가 만든 데이터베이스에 유저를 저장하고 유저를 조회해야 하므로,
    // 우리가 만든 DTO 자료형을 기준으로 데이터 작업을 진행해야 한다.
    // 반드시!!!!!우리가 만든!!!! DTO 폴더 위치에 있는 User를 가져온다.
    // 하나의 데이터를 가져올 때 사용하는 자료형
    Users 유저한명();

    // 다수의 데이터를 유저 형태로 가져올 때 사용하는 자료형
    // 관리자 페이지나 전화번호부와 같은 곳에서 사용하는 기능
    List<Users> 유저전체();

}
