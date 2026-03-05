package com.back.domain.post.controller;

import com.back.domain.post.service.PostService;
import com.back.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //UI부분
    @GetMapping("/posts/write-form")
    @ResponseBody
    public String writeForm() {

        return """
                <form method="post" action="/posts/write">
                  <input type="text" name="title">
                  <br>
                  <textarea name="content"></textarea>
                  <br>
                  <input type="submit" value="작성">
                </form>
                """;
    }


    //실제 데이터 처리하는 부분
    @PostMapping("/posts/write")
    @ResponseBody
    public String write(String title, String content) {

        Post post = postService.write(title, content);

        return "%d번 글이 작성되었습니다.".formatted(post.getId());
    }

}