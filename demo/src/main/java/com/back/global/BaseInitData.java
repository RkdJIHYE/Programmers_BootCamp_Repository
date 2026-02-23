package com.back.global;

import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)  //여기에 걸면 해당 클래스의 모든 메소드에
// 리드온니 트랜잭션이 걸어진다.
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {

            self.work1();
            self.work2();

//            new Thread(() -> {
//                self.work1();
//            }).start();
//
//            self.work2();
        };
    }
    // 다음과 같이 그냥 트랜잭션이 필요한 경우에 메소드 앞에 선언
    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }


        // 어떤 기능을 테스트 데이터가 2개인 것을 가정하고 개발
        postService.write("제목1", "내용1");

// 확인하기 위한 작업 (예외 처리 하기 위해서)
//        if (true) {
//            throw new RuntimeException("테스트 예외");
//        }

        postService.write("제목2", "내용2");

    }
    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }
}