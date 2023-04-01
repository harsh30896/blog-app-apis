package com.codewithharsh.blog.payloads;

import com.codewithharsh.blog.entities.Cateogory;
import com.codewithharsh.blog.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private Cateogory category;
    private User user;


}
