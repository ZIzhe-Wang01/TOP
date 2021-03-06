package com.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.top.mapper")

@MapperScan("com.top.dao.mapper")

@MapperScan("com.top.mapper")

public class TopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TopApplication.class, args);
		System.out.print("start");
	}
	
}
