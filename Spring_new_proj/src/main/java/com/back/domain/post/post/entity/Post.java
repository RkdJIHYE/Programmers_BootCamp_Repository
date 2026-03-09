package com.back.domain.post.post.entity;

import com.back.domain.post.comment.entity.Comment;
import com.back.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {

    private String title;
    private String content;

    @OneToMany
    private List<Comment> comments;


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}