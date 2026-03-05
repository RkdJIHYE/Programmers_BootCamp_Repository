package com.back.domain.post.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    //UI부분
    @GetMapping("/posts/write")
    @ResponseBody
    public String writeForm() {

        return """
                <form action="https://localhost:8080/">
                  <input type="text" name="title">
                  <br>
                  <textarea name="content"></textarea>
                  <br>
                  <input type="submit" value="작성">
                </form>
                """;
    }


    //실제 데이터 처리하는 부분
    public String write(){

    }

}