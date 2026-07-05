package com.project.mybatis_blogwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    // mybatis 에서도 @Id 와 @GenerType을 지정해주는 것이 좋다.
    // 회원가입해서 유저 등록을 하지 않기 때문에
    // 생략한 것일 뿐이다. 추후 추가해야한다.
    // schema.sql 에서 자동으로 추가설정을 했기 때문에 안써준 것도 있다.
    private  Long id;
    // 되도록이면 카멜케이스 스네이크케이스 상관없이
    // sql 에 작성한 컬럼명과 일치하게 작성
    private String name;
    private String email;
}
/*
개발자가 파일만드는 순서
1. sql 생성(단, mysql 이나 postgresql 자체 sql에서
create 문을 작성해주면 .sql 파일은 만들 필요가 없다.
springboot 에서 테이블생성까지 하고 싶다면
.sql 생성해주는 것이 맞다.

2. dto 생성
3. mapper.java 생성
    회사에서 보통 pm 위치에서 사용할 기능의 명칭까지 모두 지정
    반환할 메서드 타입 자료형까지 모두 지정
    백엔드가 할 일

    Service.java 에서 보완할 로직에 코드 몇 줄 추가

4. mapper.xml 생성하러 가기
   없을 경우  mapper.xml 생성
   (하지만 대부분 회사는 만들어놓은xml이 있다.)

5. service.java 생성하러 가기

6. controller 연결하러 가기

만약 조직적으로 팀 안에서 작업을 한다면
대부분의 회사에는
xml dto mapper controller 모두 만들어진 상태
- service 에서 메서드를 추가하거나, 기능 수정
 */