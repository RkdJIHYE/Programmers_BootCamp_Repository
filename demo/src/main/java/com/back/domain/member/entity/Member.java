package com.back.domain.member.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username; //로그인의 아이디
    @Column(length = 100) //암호화를 하기 위해서 100정도는 잡아줘야한다.
    private String password;
    @Column(length = 30)
    private String nickname;
}
