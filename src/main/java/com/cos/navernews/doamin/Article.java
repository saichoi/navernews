package com.cos.navernews.doamin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Document(collection = "naver_news")
public class Article {
	@Id
	private String _id;
	
	private String company;
	private String title;
	private String createdAt;
}
