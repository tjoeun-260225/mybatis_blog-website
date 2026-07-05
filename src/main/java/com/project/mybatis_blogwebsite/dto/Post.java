package com.project.mybatis_blogwebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    // 카멜케이스나 스네이크케이스로 변수이름을 지정하지 않아
    // application.yml 에서 카멜케이스 변환설정과 같은 세팅을
    // 크게 구분하여 설정하지 않아도 되지만,
    // 변수이름은 되도록 상세하게 작성하는 것이 추후에
    // 상태관리하기 좋다.
    // 아래 변수이름은 초반에는 간단하여 작성하기 편하나
    // 시간이 갈수록 유지보수 할 때는 번거로울 수 있다.
    private Long id;
    private String title;
    private String content;
}
