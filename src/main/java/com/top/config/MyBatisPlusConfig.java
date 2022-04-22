package com.top.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
<<<<<<< HEAD
<<<<<<< HEAD
 * 分页配置
=======
 * Paging configuration
>>>>>>> 7c4da5c (new update)
=======
 * 分页配置
>>>>>>> a0f95bad5e82b48112f84d31c3fbcae296fc8039
 */
@Configuration
public class MyBatisPlusConfig {
	
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}
	
	
}
