package com.back.global;

import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.repository.PostRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {
    @Bean
    ApplicationRunner initDataRunner(PostRepository postRepository) {
        return args -> {

            if (postRepository.count() > 0){
                return;
            }
            System.out.println("초기 데이터를 로딩합니다.");

            Post post1 = new Post("제목1","내용1");
            postRepository.save(post1);

            postRepository.findById(1);
        };
    }
}