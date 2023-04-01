package com.codewithharsh.blog.repositories;

import com.codewithharsh.blog.entities.Cateogory;
import com.codewithharsh.blog.entities.Post;
import com.codewithharsh.blog.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer>
{
    List<Post> findByUser(User user);
    List<Post> findByCategory(Cateogory category);


}
