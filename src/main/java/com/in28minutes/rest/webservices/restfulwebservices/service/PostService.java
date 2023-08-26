package com.in28minutes.rest.webservices.restfulwebservices.service;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Post;
import com.in28minutes.rest.webservices.restfulwebservices.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAllByUserId(int id) {
        return postRepository.findAllByUserId(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
