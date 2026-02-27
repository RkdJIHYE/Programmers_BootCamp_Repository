package com.back;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subject;
    private String content;

    // 1:N Question이 지금 one 이고, 결과가 many이기에 list로 받는다
    @OneToMany (mappedBy = "question")
    private List<Answer> answerList = new ArrayList<>();


}