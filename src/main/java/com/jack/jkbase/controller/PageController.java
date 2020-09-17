package com.jack.jkbase.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jack.jkbase.mapper.SysRoleMapper;
@Controller
public class PageController {
	@Autowired SysRoleMapper roleRepo ;
	
	/**
	 * 	通用模板映射
	 * @param moduleDir 模板文件存放路径
	 * @param templeteName 模板文件名称
	 * @param moduleId 模块id
	 * @return
	 */
	@RequestMapping("/{moduleDir}/{templeteName}/module.page")
	public String commonModuleMapper(@PathVariable String moduleDir ,
			@PathVariable String templeteName,Model model ) {
		if("UserMng".equals( templeteName)) model.addAttribute("roles",roleRepo.findAll());
		return moduleDir+"/"+templeteName;
	}
	
}
