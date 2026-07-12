package com.project.mybatis_blogwebsite.service;

import com.project.mybatis_blogwebsite.dto.Post;
import com.project.mybatis_blogwebsite.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// service.PostService
@Service
@RequiredArgsConstructor
public class PostService {
    // postMapper 라는 공간을 생성한 상태일 뿐
    // 사용한 상태가 아니기 때문에 글씨가 죽어있는 표현이 맞음
    private final PostMapper postMapper;
    /*
    @RequiredArgsConstructor 를 작성하지 않으면

    를 작성해야 한다.
    이 클래스가 갖고있는 필드와 생성자가 파라미터로 받은 값을 지정

    파라미터로 들어온 값을 클래스 필드에서 사용할 수 있도록 설정
     */


    public List<Post> 모두조회() {
        return postMapper.모두조회();
    }

    public void 글쓰기(Post post) {
        // 비공개 설정과 같은 글쓰기 작업을 할 경우
        // 서비스 내부 로직에 코드를 상세히 기입한다.
        // 현재는 단순 글쓰기 저장 정도만 확인하기 때문에
        // 코드가 간결한 것이다.
        postMapper.글쓰기(post);
    }
    public Post 아이디조회(Long id){
        return postMapper.아이디조회(id);
    }

    public void 수정하기(Long id, Post post) {
        post.setId(id);
        postMapper.수정하기(post);
    }

    public void 삭제하기(Long id) {
        postMapper.삭제하기(id);
    }

}
