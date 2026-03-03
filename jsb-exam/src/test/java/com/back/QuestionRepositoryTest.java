package com.back;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

//    @Test
//    void t1() {
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        questionRepository.save(q1);
//
//        Answer a1 = new Answer();
//        a1.setContent("sbb는 스프링부트 게시판입니다.1");
//        a1.setQuestion(q1);
//        answerRepository.save(a1);
//
//        Answer a2 = new Answer();
//        a2.setContent("sbb는 스프링부트 게시판입니다.2");
//        a2.setQuestion(q1);
//        answerRepository.save(a2);
//
//    }

    /*@Test
    @Transactional
    void t2() {
        Question q1 = questionRepository.findById(1).get();
        System.out.println(q1.getSubject());
        System.out.println(q1.getContent());

        // q1 질문에 대한 답글
        List<Answer> answers = q1.getAnswerList();

        for (Answer a : answers) {
            System.out.println(a.getContent());
        }

    }*/

    @Test
    void t1() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
        System.out.println(q.getSubject());
    }

    @Test
    void t2() {
        Question q1 = questionRepository.findById(1).get();

        assertThat(q1.getSubject()).isEqualTo("sbb가 무엇인가요?");

    }


    @Test
    void t3() {

        Question q1 = questionRepository.findById(1).get();
        questionRepository.findBySubject("sbb가 무엇인가요?");
        assertThat(q1.getId()).isEqualTo(1);
        assertThat(q1.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }

    @Test
    @DisplayName ("질문수정")
    void t4() {
        Question q1 = questionRepository.findById(1).get();

        q1.setSubject("sbb가 무엇인가요? - 수정");
        questionRepository.save(q1);
        questionRepository.flush(); // 변경 내용을 DB에 즉시 반영시키기

        Question q2 = questionRepository.findById(1).get();
        assertThat(q2.getSubject()).isEqualTo("sbb가 무엇인가요? - 수정");

    }

    @Test
    @DisplayName("질문 삭제")
    void t5() {
        Question q1 = questionRepository.findById(1).get();
        questionRepository.delete(q1);

        assertThat(questionRepository.count()).isEqualTo(1);

    }

    @Test
    @DisplayName("답글 저장")
    @Transactional
    void t6() {
        Question q1 = questionRepository.findById(1).get();
        q1.addAnswer("답글 1");
        questionRepository.flush();

        Answer foundedAnswer = answerRepository.findById(1).get();

        assertThat(foundedAnswer.getId()).isEqualTo(1);
        assertThat(foundedAnswer.getContent()).isEqualTo("답글 1");

    }

    @Test
    @DisplayName("질문 삭제")
    void t7() {
        //외래키 삭제

        Question q1 = questionRepository.findById(1).get();
        questionRepository.delete(q1);
    }

    @Test
    @Transactional
    void t8(){
        Question q1 = questionRepository.findById(1).get();
        // t8에 @Transactional 안 붙여줄 경우 윗줄 실행 후 transaction종료되는 것
        // DB도 종료된다. lazy 상황에서 한함
        // 만약 EAGER를 사용했다면 -> 아직 살아있음.

        //질문 목록
        // lazy -> 댓글을 최대한 나중(필요한 순간)에 가져온다.
        // Eager -> 질문과 댓글을 한번에 가져온다.
        System.out.println(q1.getSubject()); // 댓글 가져 오지 않는다.

        System.out.println(q1.getContent());
        //질문 상세 내용 + 답글 목록
        q1.getAnswerList().  // 댓글 가져온다
                stream()
                .forEach(answer -> System.out.println(answer.getContent()));

    }

}