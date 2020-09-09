package com.jack.jkbase.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
/**
 * 应用程序辅助类 ，常量类
 *
 */
public class Helper {
	// 前台页面action
	public static final String F_ACTION_CREATE = "create";
	public static final String F_ACTION_EDIT = "edit";
	public static final String F_ACTION_REMOVE = "remove";
	// Session key
	public static final String SESSION_USER = "user";
	public static final String SESSION_LOGIN_TOKEN = "login_token";
	public static final String SESSION_PROFILE_TOKEN = "profile_token";
	public static final String SESSION_LOGIN_FAILURE_COUNT = "login_failure_count";//登录失败剩余次数，用于判断显示验证码
	public static final String SESSION_CHECKCODE = "code";
	//
	public static final String MVALUE = "MVALUE";//模块权限值
	public static final String FUNCS = "FUNCS";//该模块下的功能权限列表
	//
	public static final String PARAM_MODULE_ID = "moduleId";
	public static final String PARAM_FUNCTION_ID = "fid";
	//
	public static final String KEY_FUNCTIONS = "funcs";
	//
	public static final String KEY_MODULE_CODE = "moduleCode";
	public static final String KEY_MODULE_VALUE = "mValue";
	public static final int logTypeSecurity = 1;//安全日志
	public static final int logTypeOperation = 2;//操作日志
	//
	public static final int UPLOAD_TYPE_USER_IMG = 1;
	
	
	public static final int adminId =1 ;
	public static final int user_status_normal = 0;
	public static final int MODULE_NOT_CLOSE = 0;
	public static final String KEY_ERROR = "error"; 
	//msg
	public static final String KEY_COUNT_MEMBER = "KEY_COUNT_MEMBER";
	public static final String KEY_COUNT_CAR = "KEY_COUNT_CAR";
	public static final String KEY_MESSAGE_COUNT = "KEY_MESSAGE_COUNT";
	//dash 主面板
	public static final String CACHE_PATH="/resources/upload/cache/";
	public static enum UserType{
		Admin("超级用户",0),Manager("管理用户",1),Enterprise("企业用户",2);
		public String text;
		public int value;
		private UserType(String text,int value){
			this.text = text;
			this.value= value;
		}
	}
	//数据库操作 枚举
	public static enum DBAction {
		Insert("Insert"),Update("Update"),Delete("Delete");//Clear("Clear")
		public String name;
		private DBAction(String name){
			this.name = name;
		}
	}
	//车辆状态枚举
	public static enum CarStatus{
		Cancel("注销",0),Apply("申请营运",1),Unapprove("审核未通过、打回",2),Approve("审核通过",3);
		public String text;
		public int value;
		private CarStatus(String text,int value){
			this.text = text;
			this.value = value;
		}
		public static CarStatus getStatus(int value){
			for(CarStatus c : CarStatus.values()){
				if(c.value == value){
					return c;
				}
			}
			return null;
		}
	}
	
	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 * 
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
	 * 192.168.1.100
	 * 
	 * 用户真实IP为： 192.168.1.110
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/**
	 * 判断x是否为2的正指数
	 * @param x
	 * @return
	 */
	public static boolean is2pow(double x){
		double a = Math.log10(x)/Math.log10(2);
		return x>0 && (int)a == a ;
	}
	//递归删除某目录下所有文件
	public static void deleteFile(File file) {
		if(!file.exists()) return;
		if(file.isFile()) {
			file.delete();
			return;
		}
		File[] files =  file.listFiles();
		if(files==null) return;
		for(File f: files) {
			if(f.isDirectory()) {
				deleteFile(file);
				//删除目录本身
				f.delete();
			}else {
				f.delete();
			}
		}
		file.delete();
	}
}
