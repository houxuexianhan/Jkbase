package com.jack.jkbase.exception;
/**
 * 此异常表示未登录异常，为全局异常类，如果用户未登录，将会跳转到登录页面
 * @author Administrator
 *
 */
public class AuthorizationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

}
