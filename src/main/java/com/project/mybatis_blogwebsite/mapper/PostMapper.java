package com.project.mybatis_blogwebsite.mapper;

import com.project.mybatis_blogwebsite.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/*
myBatis 에서 mapper 폴더는
JPA     에서 repository 폴더와 유사한 기능을 하는 폴더

src/main/resources/mapper/*.xml로 작성한
SQL을 Java 와 연결하여 사용할 수 있다.
JPA와 다른 점은 SQL 문을 개발자가 A-Z 까지 관리하며 작성
 */

@Mapper
public interface PostMapper {
    /*
    @Mapper
    public interface PostMapper {

    <mapper
      namespace="com.project.mybatis_blogwebsite.mapper.PostMapper">

    <select id="모두조회">
        SELECT id, title, content FROM posts
    </select>
     */
    /*
    post 테이블 내에 있는 데이터는 0개 ~ n개 까지 조회가능
    이 메서드이름 모두조회 가 나중에 XML 파일의 <select id = "모두조회">
    와 이름으로 연결된다.
    xml mapper 내부에 작성한 id값과 mapper.java에서 작성한
    메서드명칭을 동일하게 작성해야 한다.
    xml sql 기능의 결과와 기능결과를 service로 가져올 기능의 명칭을
    서로 연결할 수 있다.
     */
    List<Post> 모두조회();
}
