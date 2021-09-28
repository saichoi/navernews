package com.cos.navernews.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.cos.navernews.doamin.Article;

@Component
public class NaverCraw {
	int aidNum = 1;

	public List<Article> collect5() {
		List<Article> articles = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=" + aid;

			try {
				Document doc = Jsoup.connect(url).get();
				
				Element companyElement = doc.selectFirst(".press_logo img");
				Element titleElement = doc.selectFirst("#articleTitle");
				Element createdAtElement = doc.selectFirst(".t11");
				
				String company = companyElement.attr("alt");
				String title = titleElement.text();
				String createdAt = createdAtElement.text();
				
				Article article = Article.builder().
						company(company)
						.title(title)
						.createdAt(createdAt)
						.build();
				articles.add(article);

				aidNum++;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return articles;
	}
}
