package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int last_cnt = 0;


    public WiseSaying findByID(int id){
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

    public List<WiseSaying> findList(){
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

    public boolean delete(int id){
        return wiseSayings.removeIf((wiseSaying)-> wiseSaying.getCnt() == id);

    }

    public WiseSaying save(WiseSaying wiseSaying){
        //객체 상태 통째로 넘기기
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

}
