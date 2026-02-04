package com.ll.wiseSaying.controller;

import com.ll.wiseSaying.Rq;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WiseSayingController {
    private Scanner sc = new Scanner(System.in);

    private int last_cnt = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();


    public void actionModify(Rq rq){

        int id = rq.getParamInt("id",-1);

        if (id ==-1){
            System.out.println("아이디를 제대로 입력해주세요");
            return;
        }
        WiseSaying wiseSaying=findByID(id);
        if (wiseSaying==null){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        //사용자 상호작용만 따로 뺀다.
        System.out.print("명언(기존) : %s\n".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String new_content = sc.nextLine();
        System.out.print("작가(기존) : %s\n".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String new_author = sc.nextLine();

        modify(wiseSaying,new_content,new_author);
    }

    private void modify(WiseSaying wiseSaying, String new_content, String new_author){
        wiseSaying.setContent(new_content);
        wiseSaying.setAuthor(new_author);
    }

    private WiseSaying findByID(int id){
        int ModifyTarget = id;

        int findIdx =findIndexById(id);
        if (findIdx==-1){
            return null;
        }
        else{
            return wiseSayings.get(findIdx);
        }
    }

    private int findIndexById(int id){

        return IntStream
                .range(0,wiseSayings.size())
                .filter(i->wiseSayings.get(i).getCnt()==id)
                .findFirst()
                .orElse(-1);

    }

    public void actionDelete(Rq rq) {

        //String num = cmd.substring(6,cmd.length());
        int id = rq.getParamInt("id",-1);
        if (id==-1){
            System.out.println("아이디를 제대로 입력해주세요");
            return;
        }
        Boolean answer =delete(id);

        if (answer == true){
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        }
        else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

    }

    private boolean delete(int id){
        return wiseSayings.removeIf((wiseSaying)-> wiseSaying.getCnt() == id);

    }

    //목록
    public void actionShow() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = findList();
        //리스트 버전

        //배열 버전
        //com.ll.wiseSaying.entity.WiseSaying[] foundedWiseSayings = findList();

        for (WiseSaying wiseSaying : wiseSayingList){
            System.out.printf("%d / %s / %s \n",wiseSaying.getCnt(),wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }

    public void actionWrite() {
        ++last_cnt;
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        write(content,author);
        System.out.println(last_cnt+"번이 등록되었습니다.");

    }

    private void write(String content, String author){
        //생성자 이용해서 같이 넣기

        WiseSaying wiseSaying = new WiseSaying(last_cnt,content,author);

        wiseSayings.add(wiseSaying);
    }

    private  List<WiseSaying> findList(){
        //리스트 버전
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        //배열 버전
        //com.ll.wiseSaying.entity.WiseSaying[] foundedWiseSayings = new com.ll.wiseSaying.entity.WiseSaying[last_idx + 1];
        int foundedWiseSayingIndex = -1;

        for (int i = wiseSayings.size()-1; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings.get(i);
            wiseSayingList.add(foundedWiseSaying);
        }

        return wiseSayingList;
    }

}








