package com.jack.jkbase.controller;

import java.util.List;
import java.util.Optional;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.mapper.SysRoleMapper;
import com.jack.jkbase.repo.SysModuleRepo;
import com.jack.jkbase.service.SysFunctionService;
import com.jack.jkbase.service.SysModuleService;
import com.jack.jkbase.service.SysUserRolePermService;
import com.jack.jkbase.util.Helper;
@Controller
public class PageController {
	@Autowired SysRoleMapper roleRepo ;
	@Autowired SysUserRolePermService sysUserRolePermService;
	@Autowired SysFunctionService sysFunctionService;
	@Autowired SysModuleRepo moduleService ;
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
		if("UserMng".equals( templeteName)) model.addAttribute("roles",roleRepo.findAll());
		//获取该模块的权限
		Optional<SysModule> optMod = moduleService.findById(moduleId);
		//if(optMod.isEmpty()||optMod.get().getmIsclose())
		SysUser loginUser = SecurityUtils.getSubject().getPrincipals().oneByType(SysUser.class);
		List<ViewSysFunction> funcs =  sysFunctionService.selectByModule(moduleId);
		int pValue = sysUserRolePermService.getModulePerm(loginUser.getUserid(),moduleId);
		for(ViewSysFunction f : funcs){
			//超级用户无限制, 然后对于普通用户在按钮本身可用 的前提下，pValue小于0或者等于与模块权限值相与后的值 都有权限
			int fValue = f.getfValue();
			f.setAccess(pValue==-1 || (f.getfEnable()==1 && (pValue&fValue)==fValue ));
			model.addAttribute("f"+f.getFunctionid(),f);//以功能f{id}作为键值返回给模块页面
		}
		return moduleDir+"/"+templeteName;
	}
}
