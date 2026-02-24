package com.back.domain.post.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}