package com.jack.jkbase;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
@MapperScan("com.jack.jkbase.mapper")
public class JkbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkbaseApplication.class, args);
	}
	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
	    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
	    chainDefinition.addPathDefinition("/**", "anon"); 
	    // logged in users with the 'admin' role
	    //chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
	    // logged in users with the 'document:read' permission
	    //chainDefinition.addPathDefinition("/docs/**", "authc, perms[document:read]");
	    // all other paths require a logged in user
	    //chainDefinition.addPathDefinition("/**", "authc");
	    return chainDefinition;
	}
}
