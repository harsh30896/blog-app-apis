package com.codewithharsh.blog.services;

import com.codewithharsh.blog.entities.Post;
import com.codewithharsh.blog.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update

    Post updatePost(PostDto postDto, Integer postId);

    // delete

    void deletePost(Integer postId);

    // get all post

    List<Post> getAllPost();

    // GET single post

    Post getPostById(Integer postId);

    // get all post by category

    List<Post>  getPostsByCategory(Integer categoryId);

    // get all posts by user

    List<Post> getPostsByUser(Integer userId);

    // search post

    List<Post> searchPost(String keyword);

}
