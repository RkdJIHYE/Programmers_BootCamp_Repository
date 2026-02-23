package com.back.global;

import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {
            work1();
            work2();
        };
    }

    void work1() {
        if(postService.count() > 0) {
            return;
        }
        try{
            //어떤 기능을 테스트 데이터가 2개인 것을 가정하고 개발했다.
            postService.write("제목1","내용1");

            if(true){
                throw new RuntimeException("테스트 예외");
            }

            postService.write("제목2","내용2");


        }catch(Exception e){
            System.out.println("시스템 종료됨");

        }
    }

    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }
}