package com.back.domain.post.entity;

import com.back.domain.member.entity.Member;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)

public class Post extends BaseEntity{
    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //외래키 필요 : 회원의 post 내용을 알기 위해서
    @ManyToOne
    private Member author;
    //private int author; //여기서 작성자는 멤버 개개인의 아이디를 의미함

    public Post(Member author , String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}