package com.jack.jkbase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.entity.SysApp;
import com.jack.jkbase.entity.SysField;
import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysFieldMapper;
import com.jack.jkbase.mapper.SysFunctionMapper;
import com.jack.jkbase.service.impl.SysAppServiceImpl;
import com.jack.jkbase.service.impl.SysModuleServiceImpl;
import com.jack.jkbase.util.Helper;
import com.jack.jkbase.util.Result;
@Controller
@RequestMapping("/FrmMgr")
public class FrmMgrController {
	@Autowired HttpSession session ;
	@Autowired SysAppServiceImpl sysAppService;
	@Autowired SysModuleServiceImpl sysModuleService ;
	@Autowired SysFunctionMapper funcMapper ;
	@Autowired SysFieldMapper fieldMapper ;
	//--------------------------应用--------------------------------------------------
	
	@RequestMapping(value = "/getAppsCombo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String app_getAppsCombo(){
		return JSON.toJSONString(sysAppService.list());
	}
	@RequestMapping(value = "/getAppsByRoleCombo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String app_getAppsByRoleCombo(int roleId){
		return JSON.toJSONString(sysAppService.selectByRoleid(roleId));
	}
	@RequestMapping(value = "/getAppsExcludeSysCombo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String app_getAppsExcludeSysCombo(){
		SysUser loginUser = (SysUser)session.getAttribute(Helper.SESSION_USER);
		if(loginUser.getUserid()==Helper.adminId) return JSON.toJSONString(sysAppService.list());
		else return JSON.toJSONString(sysAppService.findByaIssys(0));
	}
	//*************************************模块 应用*******************************
	@RequestMapping(value = "/module_getApps.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String module_getApps(){
		JSONObject jo = new JSONObject();
		List<SysApp> list = sysAppService.list();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		return jo.toJSONString();
	}
	@RequestMapping(value = "/module_appAccess.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String module_appAccess(int fid,String action,SysApp app) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(app.getaAppname()))
			return JSON.toJSONString(new Result(false,"操作失败：应用名称不能为空！"));  
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				sysAppService.save(app);
				return JSON.toJSONString(new Result(true,"添加成功！",app));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				sysAppService.updateById(app);
				return JSON.toJSONString(new Result(true,"修改成功！",app));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysAppService.removeById(app.getAppid());
				return  JSON.toJSONString(new Result(true,"删除成功！"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作失败出现异常：请检查应用名称是否重复！"));
		}
	}
	@RequestMapping(value = "/module_moduleAccess.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String module_moduleAccess(int fid,String action,SysModule module) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(module.getmCname()))
			return JSON.toJSONString(new Result(false,"操作失败：模块名称不能为空！"));  
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				sysModuleService.save(module);
				return JSON.toJSONString(new Result(true,"添加成功！",sysModuleService.selectById(module.getModuleid())));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				sysModuleService.updateById(module);
				return JSON.toJSONString(new Result(true,"修改成功！",sysModuleService.selectById(module.getModuleid())));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysModuleService.removeById(module.getModuleid());
				return  JSON.toJSONString(new Result(true,"删除成功！"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	@RequestMapping(value = "/getModules.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String module_getModules() {
		List<ViewSysModule> list = sysModuleService.selectAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		JSONObject jo = new JSONObject();
		jo.put("data", ja);
		return jo.toJSONString();
	}
	@RequestMapping(value = "/module_getComboExcludeParent.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String module_getComboExcludeParent(){
		return JSON.toJSONString(sysModuleService.selectComboExcludeParent());
	}
	
	//************************模块功能******************************
	@RequestMapping(value = "/function_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String function_access(String action,SysFunction model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(model.getfName()))
			return JSON.toJSONString(new Result(false,"操作失败：功能名称不能为空！")); 
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				model.setfValue(funcMapper.selectMaxValue(model.getfModuleid()));
				funcMapper.insertSelective(model);
				return JSON.toJSONString(new Result(true,"添加成功！",funcMapper.selectByPrimaryKey(model.getFunctionid())));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				funcMapper.updateByPrimaryKey(model);
				return JSON.toJSONString(new Result(true,"修改成功！",funcMapper.selectByPrimaryKey(model.getFunctionid())));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				funcMapper.deleteByPrimaryKey(model.getFunctionid());
				return  JSON.toJSONString(new Result(true,"删除成功！",model));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,30)));
		}
	}
	@RequestMapping(value = "/function_getAll.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String function_getAll() {
		JSONObject jo = new JSONObject();
		List<ViewSysFunction> list = funcMapper.selectAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		return jo.toJSONString();
	}
	
	////**************字段****************************************
	@RequestMapping(value = "/field_getAll.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String field_getAll(){
		JSONObject jo = new JSONObject();
		List<SysField> list = fieldMapper.findAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		return jo.toJSONString();
	}
	@RequestMapping(value = "/field_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String field_access(String action,SysField model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(model.getfCname())) 
			return JSON.toJSONString(new Result(false,"操作失败：字段名称不能为空！"));
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				fieldMapper.insert(model);
				return JSON.toJSONString(new Result(true,"添加成功！",fieldMapper.selectByPrimaryKey(model.getFieldid())));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				fieldMapper.updateByPrimaryKey(model);
				return JSON.toJSONString(new Result(true,"修改成功！",fieldMapper.selectByPrimaryKey(model.getFieldid())));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				fieldMapper.deleteByPrimaryKey(model.getFieldid());
				return  JSON.toJSONString(new Result(true,"删除成功！",model));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	@RequestMapping(value = "/field_combo.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String field_combo(){
		return  JSON.toJSONString(fieldMapper.findAll());
	}
	
}
