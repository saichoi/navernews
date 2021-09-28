package com.cos.navernews.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import com.cos.navernews.doamin.Article;

public class NaverCrawTest {
	int aidNum = 1;

	@Test
	public void test(){
		List<Article> articles = new ArrayList<>();
		
		for(int i = 1; i < 3; i++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid="+aid;
			
			try {
				Document doc = Jsoup.connect(url).get();
				Element companyElement = doc.selectFirst(".press_logo img");
				Element titleElement = doc.selectFirst("#articleTitle");
				Element createdAtElement = doc.selectFirst(".t11");
				String company = companyElement.attr("alt");
				String title = titleElement.text();
				String createdAt = createdAtElement.text();
				System.out.println(title);
				System.out.println(createdAt);
				Article article = Article.builder().company(company).title(title).createdAt(createdAt).build();
				articles.add(article);

				System.out.println(company);
				System.out.println(title);
				System.out.println(createdAt);
				
				articles.add(article); // null 일 때 try ~ catch 처리해야함 
				
				aidNum++;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
