package com.back.domain.post.service;

import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service   // @Component 랑 같은 기능을 한다. 그러나
//개발자가 볼때 해당 클래스가 서비스의 기능을 한다는 것을 보여줌
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(Member author, String title, String content){
        //객체로 생성
        Post post = new Post(author,title,content);
        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String newTitle, String newContent) {
        post.setTitle(newTitle);
        post.setContent(newContent);
        return postRepository.save(post);
    }
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public long count(){
        return postRepository.count();
    }
}
