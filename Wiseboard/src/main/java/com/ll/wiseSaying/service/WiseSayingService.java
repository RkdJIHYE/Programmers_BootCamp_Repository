package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public void modify(WiseSaying wiseSaying, String new_content, String new_author){
        wiseSaying.setContent(new_content);
        wiseSaying.setAuthor(new_author);

        wiseSayingRepository.save(wiseSaying);
    }

    public WiseSaying write(String content, String author){
        //객체하나 생성 후 -> 객체로 넘기기
        WiseSaying wiseSaying = new WiseSaying(0,content,author);
        return wiseSayingRepository.save(wiseSaying);
    }

}
