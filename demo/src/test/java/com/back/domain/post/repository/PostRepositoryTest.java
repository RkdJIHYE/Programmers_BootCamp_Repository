package com.back.domain.post.repository;

import com.back.domain.post.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@Rollback
// 즉 두개의 yaml 파일을 사용하는 것 -> 근데 추가로 사용하라고
// 했던 test yaml 파일에 있는 내용이 오버라이딩 되어 그 파일에 있는 것으로 사용
// 기본적으로 application.yaml 파일을 사용하되
@ActiveProfiles("test") // 추가로 application-test yaml 파일을 사용하겠다.
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void t1(){
        Post post = postRepository.findById(2).get();

        assertThat(post.getId()).isEqualTo(2);
        assertThat(post.getContent()).isEqualTo("내용2");
        assertThat(post.getTitle()).isEqualTo("제목2");
    }

    @Test
    void t2(){

        Post post = new Post("제목3","내용3");
        Post savedPost = postRepository.save(post);

        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getContent()).isEqualTo("내용3");
        assertThat(savedPost.getTitle()).isEqualTo("제목3");

    }

    @Test
    void t3(){
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(2);
    }
}
