package com.codewithharsh.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {

		private Integer categoryId;
		private String categoryTitle;
		private String categoryDescription;
	
}
