package com.jack.jkbase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewUserRolePerm;
import com.jack.jkbase.exception.AuthorizationException;
import com.jack.jkbase.mapper.SysRolePermissionMapper;
import com.jack.jkbase.util.Helper;


@Service
public class SysUserRolePermService{
	@Autowired
	SysRolePermissionMapper mapper;
	
	@Autowired
	private HttpServletRequest request;
	
	//获取用户 模块的权限值,如果为超级用户，则返回-1，具有所有权限
	public int getModulePerm(int userId,int moduleId){
		if(userId == Helper.adminId) return -1;
		List<ViewUserRolePerm> list =  mapper.selectModulePerm(userId,moduleId);
		int p = 0;
		for(ViewUserRolePerm urp : list){
			
			p |= urp.getpValue(); 
		}
		return p;
	}
	/**
	 * 校验当前用户在某个模块的某个功能的权限
	 * @param functionId
	 * @return 空字符串表示 有权限 ，否则是错误信息
	 * @throws Exception 
	 */
	public String permissionValidate(int functionId){
		Object o =  request.getSession().getAttribute(Helper.SESSION_USER);
		if(o==null)  throw new AuthorizationException(); 
		SysUser loginUser= (SysUser)o;
		if(loginUser.getUserid() == Helper.adminId) return "";
		try{
			return mapper.permissionValidate(loginUser.getUserid(),functionId);
		}catch(Exception ex){
			ex.printStackTrace();
			return "数据库操作出现异常！";
		}
	}
}
