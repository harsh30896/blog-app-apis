package com.codewithharsh.blog.controllers;

import com.codewithharsh.blog.entities.Post;
import com.codewithharsh.blog.payloads.PostDto;
import com.codewithharsh.blog.repositories.CategoryRepo;
import com.codewithharsh.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
    {
     PostDto createPost =  this.postService.createPost(postDto,userId, categoryId);
     return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }
}
