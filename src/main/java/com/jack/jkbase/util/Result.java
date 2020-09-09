package com.jack.jkbase.util;

public class Result {
	private boolean success;
	private String info;
	private Object data;//也可用来标识错误代码
	
	//data字段对应的错误编码
	public static final String CODE_LOGIN_TIMEOUT = "CODE_LOGIN_TIMEOUT";//登录超时，前端需要重新登录
	public static final String CODE_NEED_VERIFICATION_CODE = "CODE_NEED_VERIFICATION_CODE";//需要显示验证码
	public static final String CODE_VERIFICATION_CODE_ERROR = "CODE_VERIFICATION_CODE_ERROR";//验证码错误
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result(boolean success){
		this.success = success;
	}
	public Result(boolean success,String info){
		this.success = success;
		this.info = info;
	}
	public Result(boolean success,String info,Object data){
		this.success = success;
		this.info = info;
		this.data = data;
	}
}
