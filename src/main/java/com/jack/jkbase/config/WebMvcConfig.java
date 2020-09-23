package com.jack.jkbase.config;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	//@Autowired SecurityInterceptor securityInterceptor;
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("forward:/index.html");
		//registry.addViewController("/login.html").setViewName("login");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(securityInterceptor).addPathPatterns("/**/*.do"
		//		,"/**/*.page").excludePathPatterns("/","/login.do","/**/*.html");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	}
	//替换默认的JSON序列化工具为fastjson
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//1.构建了一个HttpMessageConverter  FastJson   消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2.定义一个配置，设置编码方式，和格式化的形式
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //3.设置成了PrettyFormat格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
        		SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteDateUseDateFormat
        		,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,
        		SerializerFeature.WriteNullListAsEmpty,SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //4.处理中文乱码问题
        List<MediaType> fastMediaTypes =  new ArrayList<>();
        fastMediaTypes.add(MediaType.TEXT_HTML);
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        
        //5.将fastJsonConfig加到消息转换器中
        fastConverter.setFastJsonConfig(fastJsonConfig);
        int idx = -1;
		for (int i=0;i<converters.size();i++) {
			HttpMessageConverter<?> c = converters.get(i);
			if(c.getClass()== MappingJackson2HttpMessageConverter.class) {
				idx = i;
				break;
			}
		}
		if (idx == -1)
			converters.add(fastConverter);
		else
			converters.add(idx, fastConverter);//只要保证顺序在默认的jackson前面即可
	}
	@Bean
	public DatabaseIdProvider getDatabaseIdProvider() {
	    DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
	    Properties properties = new Properties();
	    properties.setProperty("Oracle","oracle");
	    properties.setProperty("MySQL","mysql");
	    properties.setProperty("DB2","db2");
	    properties.setProperty("Derby","derby");
	    properties.setProperty("H2","h2");
	    properties.setProperty("HSQL","hsql");
	    properties.setProperty("Informix","informix");
	    properties.setProperty("Microsoft SQL Server","sqlserver");
	    properties.setProperty("PostgreSQL","postgresql");
	    properties.setProperty("Sybase","sybase");
	    properties.setProperty("Hana","hana");
	    databaseIdProvider.setProperties(properties);
	    return databaseIdProvider;
	}
}
