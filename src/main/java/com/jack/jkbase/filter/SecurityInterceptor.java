package com.jack.jkbase.filter;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.service.SysFunctionService;
import com.jack.jkbase.service.SysUserRolePermService;
import com.jack.jkbase.service.impl.SysModuleServiceImpl;
import com.jack.jkbase.util.Helper;
import com.jack.jkbase.util.Result;

/**
 * 1.此拦截器用于拦截所有请求，用于登录权限验证
 * 2.拦截 带 moduleId 参数的请求，在渲染视图之前返回 模块权限值
 *  请参考路径拦截规则：WebMvcConfig.java
 */
//@Component
public class SecurityInterceptor implements HandlerInterceptor{
	@Autowired
	SysUserRolePermService sysUserRolePermService;
	@Autowired 
	SysFunctionService sysFunctionService;
	@Autowired
	SysModuleServiceImpl moduleService ;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("SecurityInterceptor preHandle:"+request.getContextPath()+","+request.getRequestURI()+","+request.getMethod());
		HttpSession session = request.getSession();
	    if (session.getAttribute(Helper.SESSION_USER) == null) {
	    	HandlerMethod hm = (HandlerMethod)handler;
	    	if(hm.hasMethodAnnotation(ResponseBody.class)) {
	    		response.setContentType("text/html; charset=utf-8");  
	    	    PrintWriter out = response.getWriter();   
	    		out.write(JSON.toJSONString(new Result(false,"登录已超时，请重新登录！",Result.CODE_LOGIN_TIMEOUT)));
	    		out.flush();
	    		out.close();
	    	}else {
	    		response.sendRedirect(request.getContextPath()+"/"); //重定向到登陆界面
	    	}
	    	return false;
	    }else {
	    	//模块是否关闭验证
	    	Object mObj = request.getParameter(Helper.PARAM_MODULE_ID);
	    	Object obj = request.getParameter(Helper.PARAM_FUNCTION_ID);
	    	if(mObj==null && obj==null) return true;//没有带模块ID 和功能ID参数，则不需要验证
	    	try{
		    	if(mObj!=null){
		    		int moduleId = Integer.parseInt(mObj.toString());
			    	SysModule m =  moduleService.getById(moduleId);
			    	if(m==null || m.getmIsclose()!=Helper.MODULE_NOT_CLOSE){
			    		response.sendRedirect(request.getContextPath()+"/moduleClosed.page"); 
			    		return false;
			    	}
		    	}
		    	//至此模块 权限校验通过
		    	if(obj==null) return true;//没带功能参数，则通过校验，否则需要校验功能权限
	    		int functionId = Integer.parseInt(obj.toString());
	    		String rs = sysUserRolePermService.permissionValidate(functionId);
				//System.out.println("SecurityInterceptor: 模块id："+",功能ID："+functionId+",校验结果:"+rs);  
				if(rs.trim().isEmpty()){	
					return true;//正常通过
				}else{
					response.setContentType("text/html; charset=utf-8");  
		    	    PrintWriter out = response.getWriter(); 
					out.write(JSON.toJSONString(new Result(false,rs)));
					out.flush();
		    		out.close();
		    		return false;
				}
	    	}catch (Exception e) {
	    		response.setContentType("text/html; charset=utf-8");  
	    	    PrintWriter out = response.getWriter(); 
	    		out.write(JSON.toJSONString(new Result(false,"请求出现异常："+e.getMessage())));
	    		out.flush();
	    		out.close();
	    		return false;
			}
	    }
	}
	//模块权限值
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Object obj = request.getParameter(Helper.PARAM_MODULE_ID);
		//System.out.println(Helper.PARAM_MODULE_ID+":"+obj);
		if(obj == null) return;//如果没有moduleId 参数，则什么都不做，否则返回模块权限值
		//System.out.println("SecurityInterceptor postHandle:"+request.getContextPath()+","+request.getRequestURI()+","+request.getMethod());
		SysUser loginUser = (SysUser)request.getSession().getAttribute(Helper.SESSION_USER);
		int moduleId = Integer.parseInt(obj.toString());
		int pValue = sysUserRolePermService.getModulePerm(loginUser.getUserid(),moduleId);
		modelAndView.addObject(Helper.MVALUE,pValue);
		//以及 功能 列表
		List<ViewSysFunction> funcs =  sysFunctionService.selectByModule(moduleId);
		for(ViewSysFunction f : funcs){
			//超级用户无限制, 然后对于普通用户在按钮本身可用 的前提下，pValue小于0或者等于与模块权限值相与后的值 都有权限
			int fValue = f.getfValue();
			f.setAccess(loginUser.getUserid()==Helper.adminId || (f.getfEnable()==1 && (pValue&fValue)==fValue ));
			modelAndView.addObject("f"+f.getFunctionid(),f);//以功能f{id}作为键值返回给模块页面
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
