package com.jack.jkbase.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigInfo {
	
	public static final String PROPERTIES_AUTH = "auth.properties";//车站授权文件
	public static final String PROPERTIES_IP="ip.properties";//检票口 ip文件
	public static final String PROPERTIES_CONFIG = "config.properties";
	public static String default_password;
	//mail
	public static String mail_host;
	public static int mail_port;
	public static String mail_from;
	public static String mail_username;
	public static String mail_password;
	public static int mail_smtp_timeout;

	public static String resources_upload_user_image;
	public static String resources_upload_public_video;
	public static String resources_upload_public_image;
	
	static{
		initOrRefresh();
	}
	//初始化或更新缓存
	public static void initOrRefresh(){
		Properties p=new Properties();
        try {
		    //InputStream in = new FileInputStream(ConfigUtil.getPathForWebinf()+PROPERTIES_CONFIG);
        	InputStream in = ConfigInfo.class.getClassLoader().getResourceAsStream(PROPERTIES_CONFIG);
            p.load(in);
            in.close();
            default_password = p.getProperty("default_password","654321888");
            mail_host = p.getProperty("mail_host","smtp.163.com");
            mail_port = Integer.parseInt(p.getProperty("mail_port","25"));
            mail_from = p.getProperty("mail_from");
            mail_username = p.getProperty("mail_username");
            mail_password = p.getProperty("mail_password");
            mail_smtp_timeout = Integer.parseInt(p.getProperty("mail_smtp_timeout","25000"));
            
            resources_upload_user_image = p.getProperty("resources_upload_user_image","/resources/upload/user/image/");
            resources_upload_public_video = p.getProperty("resources_upload_public_video","/resources/upload/public/video/");
            resources_upload_public_image = p.getProperty("resources_upload_public_image","/resources/upload/public/image/");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
}
