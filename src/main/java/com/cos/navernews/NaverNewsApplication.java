package com.cos.navernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NaverNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverNewsApplication.class, args);
	}

}
