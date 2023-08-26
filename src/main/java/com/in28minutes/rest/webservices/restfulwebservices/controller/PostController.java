package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Post;
import com.in28minutes.rest.webservices.restfulwebservices.service.PostService;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<Post>> findAllByUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok(postService.findAllByUserId(id));
    }

    @PostMapping("/create-by-user/{id}")
    public ResponseEntity<Post> createPost(@PathVariable("id") int id, @RequestParam("description") String description) {
        return ResponseEntity.ok(Post.builder()
                .user(userService.findById(id))
                .description(description)
                .build());
    }
}
