package com.codewithharsh.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="categories" )
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cateogory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(name = "title, length = 100")
	private String categoryTitle;
	
	@Column(name = "description")
	private String categoryDescription;
	
   
}
