package com.back.domain.post.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor // 매개변수 생성자
@NoArgsConstructor //기본 생성자
public class Post extends BaseEntity {

    private String title ;
    private String content;

}
