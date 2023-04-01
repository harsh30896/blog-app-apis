package com.codewithharsh.blog.services.impl;

import com.codewithharsh.blog.entities.Cateogory;
import com.codewithharsh.blog.entities.Post;
import com.codewithharsh.blog.entities.User;
import com.codewithharsh.blog.exceptions.ResourceNotFoundException;
import com.codewithharsh.blog.payloads.PostDto;
import com.codewithharsh.blog.repositories.CategoryRepo;
import com.codewithharsh.blog.repositories.PostRepo;
import com.codewithharsh.blog.repositories.UserRepo;
import com.codewithharsh.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostsServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user id", userId));
        Cateogory cateogory = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Cateogory", "Category Id", categoryId));

        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(cateogory);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
      return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
