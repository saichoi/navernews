package com.cos.navernews.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.navernews.doamin.Article;
import com.cos.navernews.doamin.ArticleRepository;
import com.cos.navernews.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ArticleController {
	
	private final ArticleRepository articleRepository;
	
	@GetMapping("/article")
	   public CMRespDto<List<Article>> findAll(){
	      return new CMRespDto<>(1, "성공", articleRepository.findAll());
	   }
	
}
