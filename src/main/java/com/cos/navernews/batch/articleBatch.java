package com.cos.navernews.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.navernews.doamin.Article;
import com.cos.navernews.doamin.ArticleRepository;
import com.cos.navernews.util.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class articleBatch {
	private final ArticleRepository articleRepository;
	private final NaverCraw naverCraw;

	// 초 분 시 일 월 주
	@Scheduled(fixedDelay = 1000 * 60 * 1, zone = "Asia/Seoul")
	public void newsCrawAndSave() {
		List<Article> articles = naverCraw.collect5();
		articleRepository.saveAll(articles); 
	}
}
