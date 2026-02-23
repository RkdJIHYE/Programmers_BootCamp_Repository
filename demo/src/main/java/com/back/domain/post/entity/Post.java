package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}