package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public void modify(WiseSaying wiseSaying, String new_content, String new_author){
        wiseSaying.setContent(new_content);
        wiseSaying.setAuthor(new_author);


    }

    public WiseSaying write(String content, String author){
        //생성자 이용해서 같이 넣기

        return wiseSayingRepository.save(content,author);
    }

}
