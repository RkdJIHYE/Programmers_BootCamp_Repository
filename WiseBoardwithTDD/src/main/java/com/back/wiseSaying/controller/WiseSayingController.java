package com.back.wiseSaying.controller;

import com.back.global.Rq;
import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.service.WiseSayingService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WiseSayingController {
    private Scanner sc;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    int lst_id =0;


    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }


    public void actionDelete(Rq rq) {

        int id = rq.getParamAsInt("id", -1);
        boolean rst = WiseSayingService.delete(id);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));

    }


    public void actionAdd() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        lst_id++;
        WiseSaying wiseSaying = new WiseSaying(lst_id, saying, author);
        wiseSayings.add(wiseSaying);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(lst_id));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        wiseSayings
                .reversed()
                .stream()
                .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                        wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getSaying()));

    }


}
