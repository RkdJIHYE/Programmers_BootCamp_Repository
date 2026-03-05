package com.back.global.entity.initData;


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
    public ApplicationRunner initData(){
        return args -> {
          work1();
        };
    }


    public void work1(){
        if(postService.count()>0){
            return;
        }
        //한번만 수행해 주면 돼서.

        postService.write("제목1","내용1");
        postService.write("제목2","내용2");
        postService.write("제목3","내용3");

    }
}
