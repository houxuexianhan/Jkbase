package com.jack.jkbase.config;

import java.util.Properties;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ShiroConfig {
	private static String ALGORITHM_NAME=Md5Hash.ALGORITHM_NAME;
	private static int HashIterations = 1;
	@Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        //哪些请求可以匿名访问
        chain.addPathDefinition("/signOut.do", "logout");
        chain.addPathDefinition("/**/*.html", "anon");
        chain.addPathDefinition("/mylogin.do", "anon");
        chain.addPathDefinition("/error", "anon");
        //除了以上的请求外，其它请求都需要登录
        chain.addPathDefinition("/", "authc");
        chain.addPathDefinition("/**/*.do", "authc");
        chain.addPathDefinition("/**/*.page", "authc");
        return chain;
    }
	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
		mappings.setProperty("UnauthorizedException","403");
		r.setExceptionMappings(mappings);  // None by default
		r.setDefaultErrorView("moduleClosed");    // No default
		r.setExceptionAttribute("ex");     // Default is "exception"
		//r.setWarnLogCategory("example.MvcLogger");     // No default
		return r;
	}
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = 
				new HashedCredentialsMatcher(ALGORITHM_NAME);
		hashedCredentialsMatcher.setHashIterations(HashIterations);
		return hashedCredentialsMatcher;
	}
	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm r =  new MyShiroRealm();
		r.setCredentialsMatcher(hashedCredentialsMatcher());
		return r;
	}
	/**
	 * 
	 * @param pwd	
	 * @param salt
	 * @return
	 */
	public static String hashUserPwd(String pwd,String salt){
		return new SimpleHash(ALGORITHM_NAME,pwd,null,HashIterations).toHex(); 
	}
	/*
	public static void main(String[] args) {
		String salt = "9e77501e-725f-4d69-812e-56b0c2186f11";
		System.out.println(ByteSource.Util.bytes(salt));
		System.out.println(hashUserPwd("654321888",salt));
		//b4f92a719c98cd13a50a117092f04250809a303ce0d63d5861b37e59d02d4b90
	}*/
}
