package com.jack.jkbase.exception;
/**
 * 拒绝访问异常，表示无权限
 * 此异常表示功能未授权时抛出的，为全局异常类，将会把请求转发至accessDenied
 * @author Administrator
 *
 */
public class AccessDeniedException extends RuntimeException{

	public AccessDeniedException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
	
}
