package com.jack.jkbase.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.service.impl.SysFunctionServiceImpl;
import com.jack.jkbase.service.impl.SysModuleServiceImpl;
import com.jack.jkbase.service.impl.SysRoleServiceImpl;
@Controller
public class PageController {
	@Autowired SysRoleServiceImpl sysRoleService ;
	@Autowired SysFunctionServiceImpl sysFunctionService;
	@Autowired SysModuleServiceImpl moduleService ;
	/**
	 * 	通用模板映射
	 * @param moduleDir 模板文件存放路径
	 * @param templeteName 模板文件名称
	 * @param moduleId 模块id
	 * @return
	 */
	@RequestMapping("/{moduleDir}/{templeteName}/module.page")
	public String commonModuleMapper(@PathVariable String moduleDir ,
			@PathVariable String templeteName,int moduleId,Model model ) {
		if("UserMng".equals( templeteName)) model.addAttribute("roles",sysRoleService.list());
		//获取该模块的权限
		SysModule optMod = moduleService.getById(moduleId);//校验模块
		//if(optMod.isEmpty()||optMod.get().getmIsclose())
		SysUser loginUser = SecurityUtils.getSubject().getPrincipals().oneByType(SysUser.class);
		List<ViewSysFunction> funcs =  sysFunctionService.selectByModuleid(moduleId);
		int pValue = moduleService.getModulePerm(loginUser.getUserid(),moduleId);
		for(ViewSysFunction f : funcs){
			//超级用户无限制, 然后对于普通用户在按钮本身可用 的前提下，pValue小于0或者等于与模块权限值相与后的值 都有权限
			int fValue = f.getfValue();
			f.setAccess(pValue<=-1 || (f.getfEnable()==1 && (pValue&fValue)==fValue ));
			model.addAttribute("f"+f.getFunctionid(),f);//以功能f{id}作为键值返回给模块页面
		}
		return moduleDir+"/"+templeteName;
	}
}
