package com.jack.jkbase;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@SpringBootApplication
@EnableCaching
@MapperScan("com.jack.jkbase.mapper")
public class JkbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkbaseApplication.class, args);
	}
}
