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
    /*
    글쓰기 등록 기능
    파라미터로 받은 post 객체의 title, content 값을 posts 테이블 저장
    id는 db에서 autoincrement로 자동 생성되기 때문에 따로 넘겨주지 않음
    useGeneratedKeys="true" keyProperty="id" 설정을 xml에서 해주면
    insert 후 자동 생성된 id 값을 post.id에 다시 채워서 사용할 수 있다.
    맨 앞 자료형이 void 인 이유
    상품 데이터를 대량으로 넣거나, 게시물을 한 번에 2개 이상 작성할 일이
    존재하지 않으면 글쓰기 작업까지만 하고,
    몇 개 저장되었는지 와 같은 세부설정이 필요하지 않을 때 사용
    int 또는 void 형태로 많이 사용
    int = 몇 개 저장되었는가 반환
    void = 저장 기능만 수행
     */
    void 글쓰기(Post post);
}
