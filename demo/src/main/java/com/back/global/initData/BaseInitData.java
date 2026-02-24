package com.back.global.initData;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
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
    ApplicationRunner devInitData() {
        return args -> {

            self.work2();
            self.work1();
        };

    }
    // 다음과 같이 그냥 트랜잭션이 필요한 경우에 메소드 앞에 선언
    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }
        Member author1 = memberService.findById(3).get();
        Member author2 = memberService.findById(4).get();
        // 어떤 기능을 테스트 데이터가 2개인 것을 .가정하고 개발
        postService.write(author1,"제목1", "내용1");
        postService.write(author2,"제목2", "내용2");

    }

    @Transactional
    void work2(){
        memberService.join("systemUser","1234","시스템");
        memberService.join("adminUser","1234","관리자");
        memberService.join("user1","1234","유저1");
        memberService.join("user2","1234","유저2");
        memberService.join("user3","1234","유저3");


    }

    @Autowired
    private MemberService memberService;
}