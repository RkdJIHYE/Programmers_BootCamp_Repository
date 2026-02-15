package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer>{}
