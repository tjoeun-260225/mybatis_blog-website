package com.project.mybatis_blogwebsite.mapper;

import org.apache.ibatis.annotations.Mapper;
/*
myBatis 에서 mapper 폴더는
JPA     에서 repository 폴더와 유사한 기능을 하는 폴더

src/main/resources/mapper/*.xml로 작성한
SQL을 Java 와 연결하여 사용할 수 있다.
JPA와 다른 점은 SQL 문을 개발자가 A-Z 까지 관리하며 작성
 */

@Mapper
public interface PostMapper {
}
