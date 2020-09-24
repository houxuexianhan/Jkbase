package com.jack.jkbase.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jack.jkbase.config.ShiroConfig;
import com.jack.jkbase.entity.SysArea;
import com.jack.jkbase.entity.SysCompany;
import com.jack.jkbase.entity.SysEvent;
import com.jack.jkbase.entity.SysFieldValue;
import com.jack.jkbase.entity.SysRole;
import com.jack.jkbase.entity.SysRoleApp;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.SysUserRole;
import com.jack.jkbase.entity.ViewSysRoleApp;
import com.jack.jkbase.entity.ViewSysUser;
import com.jack.jkbase.service.impl.SysAreaServiceImpl;
import com.jack.jkbase.service.impl.SysCompanyServiceImpl;
import com.jack.jkbase.service.impl.SysEventServiceImpl;
import com.jack.jkbase.service.impl.SysFieldValueServiceImpl;
import com.jack.jkbase.service.impl.SysFunctionServiceImpl;
import com.jack.jkbase.service.impl.SysRoleAppServiceImpl;
import com.jack.jkbase.service.impl.SysRoleModuleServiceImpl;
import com.jack.jkbase.service.impl.SysRoleServiceImpl;
import com.jack.jkbase.service.impl.SysUserRoleServiceImpl;
import com.jack.jkbase.service.impl.SysUserServiceImpl;
import com.jack.jkbase.util.ConfigInfo;
import com.jack.jkbase.util.ConfigUtil;
import com.jack.jkbase.util.ExcelUtil;
import com.jack.jkbase.util.Helper;
import com.jack.jkbase.util.Page;
import com.jack.jkbase.util.Result;

@Controller
@RequestMapping("/SysMgr")
public class SysMgrController {
	
	@Autowired SysUserServiceImpl sysUserService;
	@Autowired SysRoleServiceImpl sysRoleService;
	@Autowired SysUserRoleServiceImpl sysUserroleService ;
	@Autowired SysRoleAppServiceImpl sysRoleappService ;
	@Autowired SysFunctionServiceImpl sysFunctionService ;
	@Autowired SysRoleModuleServiceImpl sysRolePermissionService;
	@Autowired SysFieldValueServiceImpl sysFieldValueService;
	@Autowired SysAreaServiceImpl sysAreaService;
	@Autowired SysCompanyServiceImpl sysCompanyService;
	@Autowired SysEventServiceImpl sysEventService;
	//用户
	@RequestMapping(value = "/SystemParam.page", method = RequestMethod.GET, params = Helper.PARAM_MODULE_ID)
	public String page_systemParam(Model model) {
		try {
			model.addAllAttributes(ConfigUtil.pro2Map(ConfigUtil.readProperties(ConfigInfo.PROPERTIES_CONFIG, false)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return "sys/SystemParam";
	}
	//---------------------event--------------------------------------
	
	@RequestMapping(value = "/event_query.do", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String event_query(String username, Integer eventType, String beginDateStr, String endDateStr, int draw,
			int start, int length) {

		LocalDate beginDate = LocalDate.now(), endDate = LocalDate.now();
		if (beginDateStr != null && !beginDateStr.trim().isEmpty())
			beginDate = LocalDate.parse(beginDateStr);
		if (endDateStr != null && !endDateStr.trim().isEmpty())
			endDate = LocalDate.parse(endDateStr);
		/*Page<SysEvent> page = sysEventService.selectByPage(length, start / length + 1, username, eventType, beginDate,
				endDate);*/
		IPage<SysEvent> page = sysEventService.selectByPage(length, start / length + 1, username, eventType, beginDate,
				endDate);
		JSONObject joPage =new JSONObject();// (JSONObject) JSONObject.toJSON(page);
		joPage.put(Page.draw, draw);
		joPage.put(Page.recordsFiltered, page.getTotal());
		joPage.put(Page.recordsTotal, page.getTotal());
		joPage.put("data", page.getRecords());

		return joPage.toJSONString();

	}
	 
	//---------------------角色--------------------------------------
	@RequestMapping(value = "/role_getAll.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String role_getAll() {
		JSONObject jo = new JSONObject();
		List<SysRole> list =sysRoleService.list();// roleRepo.findAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		System.out.println(jo.toJSONString());
		return jo.toJSONString();
	}
	@RequestMapping(value = "/role_combo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String role_combo() {
		return  JSON.toJSONString(sysRoleService.list());
	}
	@RequestMapping(value = "/role_access.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String role_access(String action,SysRole model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(model.getrRolename()))
			return JSON.toJSONString(new Result(false,"操作失败：角色名称不能为空！"));
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				if(sysRoleService.save(model))
					return JSON.toJSONString(new Result(true,"添加成功！",model));
				else  return JSON.toJSONString(new Result(false,"添加失败！"));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				if(sysRoleService.updateById(model))return JSON.toJSONString(new Result(true,"修改成功！",model));
				else return JSON.toJSONString(new Result(false,"修改失败！"));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				if(sysRoleService.removeById(model.getRoleid())) return  JSON.toJSONString(new Result(true,"删除成功！",model));
				else return JSON.toJSONString(new Result(false,"删除失败！"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	//-----------------------------角色用户--------------------
	@RequestMapping(value = "/roleuser_getUsersByRoleid.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_getUsersByRoleid(int roleid) {
		JSONObject jo = new JSONObject();
		List<ViewSysUser> list = sysUserService.selectByRoleid(roleid);//.selectByRoleId(roleid);
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		System.out.println(jo.toJSONString());
		return jo.toJSONString();
	}
	@RequestMapping(value = "/roleuser_getByUser.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_getByUser(int userId) {
		return  JSON.toJSONString(sysUserroleService.selectByUserid(userId));
	}
	@RequestMapping(value = "/roleuser_adduser.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_adduser(int[] users,int roleid){
		if(users==null||users.length == 0){
			return JSON.toJSONString(new Result(false,"用户不能为空!"));
		}
		try{
			if( sysUserroleService.insertbatchForRole(users,roleid))return JSON.toJSONString(new Result(true,"该角色批量添加用户成功！"));
			else return JSON.toJSONString(new Result(false,"该角色添加用户失败！"));
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常："+e.getMessage()));
		}
	}
	@RequestMapping(value = "/roleuser_delete.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_delete(int userId,int roleId){
		SysUserRole key = new SysUserRole(userId,roleId);
		try{
			sysUserroleService.removeByKey(key);
			return  JSON.toJSONString(new Result(true,"删除成功！"));
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常："+e.getMessage()));
		}
	}
	@RequestMapping(value = "/roleuser_deleteByUser.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_deleteByUser(int userId){
		try{
			if(sysUserroleService.deleteByUserid(userId))return  JSON.toJSONString(new Result(true,"删除成功！"));
			else return JSON.toJSONString(new Result(false,"删除失败！"));
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常："+e.getMessage()));
		}
	}
	@RequestMapping(value = "/roleuser_deleteByRole.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleuser_deleteByRole(int roleId){
		try{
			if(sysUserroleService.deleteByRoleid(roleId))return  JSON.toJSONString(new Result(true,"删除成功！"));
			else return JSON.toJSONString(new Result(false,"删除失败！"));
			
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常："+e.getMessage()));
		}
	}
	//---------------------- 用户  ------------------------------------
	@RequestMapping(value = "/user_selectByRoleExcludeCombo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String user_selectByRoleExcludeCombo(int roleId) {
		return JSON.toJSONString(sysUserService.selectByRoleExclude(roleId));
	}
	@RequestMapping(value = "/user_combo.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String user_combo() {
		List<ViewSysUser> list = sysUserService.selectAll();//sysUserMapper.selectAll();
		for(SysUser u:list) {
			if(u.getuType()==0) {
				list.remove(u);
				break;
			}
		}
		return  JSON.toJSONString(list);
	}
	//获取所有用户列表
	@RequestMapping(value = "/user_getAll.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String user_getAll() {
		JSONObject jo = new JSONObject();
		List<ViewSysUser> list = sysUserService.selectAll();//sysUserMapper.selectAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		return jo.toJSONString();
	}
	@RequestMapping(value = "/user_access.do",params=Helper.PARAM_FUNCTION_ID, method = RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String user_access(String action,SysUser model,int[] roles) {
		if(roles==null) roles = new int[]{};
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				if(StringUtils.isEmpty(model.getuLoginname())) 
					return JSON.toJSONString(new Result(false,"操作失败：登录名不能为空！"));
				//添加默认密码
				//model.setuPwd(DigestUtils.md5Hex(ConfigInfo.default_password));
				String salt = UUID.randomUUID().toString();
				model.setuSalt(salt);
				model.setuPwd(ShiroConfig.hashUserPwd(ConfigInfo.default_password
						,salt));
				boolean b = sysUserService.save(model);
				if(b) {
					ViewSysUser su = sysUserService.selectByUsername(model.getuLoginname());
					//成功生成用户后，再添加角色
					if(roles.length>0){
						sysUserroleService.insertbatchForUser(su.getUserid(),roles);
					}
					return  JSON.toJSONString(new Result(true,"添加成功！",su));
				}else {
					return JSON.toJSONString(new Result(false,"添加失败！"));
				}
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				if(StringUtils.isEmpty(model.getuLoginname())) 
					return JSON.toJSONString(new Result(false,"操作失败：登录名不能为空！"));
				sysUserService.updateById(model);
				//sysUserMapper.updateById(model);// .updateByPrimaryKeySelective(model);
				//编辑用户权限
				if(roles.length>0)sysUserroleService.insertbatchForUser(model.getUserid(),roles);
				return JSON.toJSONString(new Result(true,"修改成功！",sysUserService.selecById(model.getUserid())));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysUserService.removeById(model.getUserid());
				return  JSON.toJSONString(new Result(true,"删除成功！",model));
			}else if("reset".equals(action)){
				boolean b= sysUserService.updatePassword(model.getUserid(), ConfigInfo.default_password,null);
				return JSON.toJSONString(new Result(b,b?"重置密码成功!":"重置密码失败:"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	//--------------------角色应用--------------------------
	@RequestMapping(value = "/roleapp_getAll.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String roleapp_getAll() {
		JSONObject jo = new JSONObject();
		List<ViewSysRoleApp> list = sysRoleappService.selectAll();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		System.out.println(jo.toJSONString());
		return jo.toJSONString();
	}
	@RequestMapping(value = "/roleapp_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String roleapp_access(String action,SysRoleApp model) {
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				sysRoleappService.save(model);
				return  JSON.toJSONString(new Result(true,"添加成功！",sysRoleappService.selectByKey(model)));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysRoleappService.removeByKey(model);
				return  JSON.toJSONString(new Result(true,"删除成功！"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:该角色和应用已经添加过了！"+e.getMessage().substring(0,40)));
		}
	}
	@RequestMapping(value = "/roleapp_getFuncs.do", produces="text/html;charset=utf-8")
	public String roleapp_getFuncs(int appId,int roleId,Model model) {
		model.addAttribute("data", sysFunctionService.selectByApp(appId,roleId));
		return "sys/permission";
	}
	@RequestMapping(value = "/roleapp_savePermission.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String roleapp_savePermission(int appId,int roleId,String values){
		//System.out.println(appId+","+roleId+","+values);
		JSONArray ja = JSONArray.parseArray(values);
		try{
			if(sysRolePermissionService.insertBatch(roleId,appId,ja)){
				return JSON.toJSONString(new Result(true,"权限设置保存成功！"));
			}else{
				return JSON.toJSONString(new Result(false,"保存权限设置失败！"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常，请联系管理员！"));
		}
	}
	//**************数据字段值***************************************
	@RequestMapping(value = "/fieldvalue_getAll.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String fieldvalue_getAll(){
		JSONObject jo = new JSONObject();
		List<SysFieldValue> list = sysFieldValueService.list();
		JSONArray ja = new JSONArray();
		ja.addAll(list);
		jo.put("data", ja);
		return jo.toJSONString();
	}
	@RequestMapping(value = "/fieldvalue_combo.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String fieldvalue_combo(int key){
		return  JSON.toJSONString(sysFieldValueService.selectByFieldid(key));
	}
	@RequestMapping(value = "/fieldvalue_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String fieldvalue_access(String action,SysFieldValue model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(model.getvText())) 
			return JSON.toJSONString(new Result(false,"操作失败：字段名称不能为空！"));
		try{
			if(Helper.F_ACTION_CREATE.equals(action)){
				sysFieldValueService.save(model);
				return JSON.toJSONString(new Result(true,"添加成功！",model));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				sysFieldValueService.updateById(model);
				return JSON.toJSONString(new Result(true,"修改成功！",model));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysFieldValueService.removeById(model.getValueid());
				return  JSON.toJSONString(new Result(true,"删除成功！"));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	//**************行政区***************************************
	@RequestMapping(value = "/area_getAll.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String area_getAll(){
		return  sysAreaService.getTreeArea().toJSONString();
	}
	@RequestMapping(value = "/area_export.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void area_export(HttpServletResponse response){
		JSONArray ja = new JSONArray();
		ja.addAll(sysAreaService.list());//获取业务数据集
        Map<String,String> headMap = SysArea.getHeadMap();//获取属性-列头
        String title = "行政区列表";
        ExcelUtil.downloadExcelFile(title,headMap,ja,response);
	}
	@RequestMapping(value = "/area_getTreeSelect.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String area_getTreeSelect(){
		return  JSON.toJSONString(new Result(true,"",sysAreaService.getTreeSelect()));
	}
	@RequestMapping(value = "/area_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String area_access(String action,SysArea model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&(StringUtils.isEmpty(model.getaAreaname())
				||StringUtils.isEmpty(model.getaAreaname())||StringUtils.isEmpty(model.getaAreacode())  )) 
			return JSON.toJSONString(new Result(false,"操作失败：行政区名称、自定义编码、标准代码都不能为空！"));
		try{
			if(Helper.F_ACTION_CREATE.equals(action) || "addTop".equals(action)){//添加顶级或子级行政区
				sysAreaService.save(model);
				return JSON.toJSONString(new Result(true,"添加成功！",model));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				sysAreaService.updateById(model);
				return JSON.toJSONString(new Result(true,"修改成功！",model));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysAreaService.removeById(model.getAreaid());
				return  JSON.toJSONString(new Result(true,"删除成功！",model));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	//**************单位部门***************************************
	@RequestMapping(value = "/company_access.do", produces="text/html;charset=utf-8",params=Helper.PARAM_FUNCTION_ID,method=RequestMethod.POST)
	@ResponseBody
	public String company_access(String action,SysCompany model) {
		if(!Helper.F_ACTION_REMOVE.equals(action)&&StringUtils.isEmpty(model.getcCname() )) 
			return JSON.toJSONString(new Result(false,"操作失败：单位名称不能为空！"));
		try{
			if(Helper.F_ACTION_CREATE.equals(action) || "addTop".equals(action)){//添加顶级或子级
				sysCompanyService.save(model);
				return JSON.toJSONString(new Result(true,"添加成功！",sysCompanyService.selectById(model.getCompanyid())));
			}else if(Helper.F_ACTION_EDIT.equals(action)){
				sysCompanyService.updateById(model); 
				return JSON.toJSONString(new Result(true,"添加成功！",sysCompanyService.selectById(model.getCompanyid())));
			}else if(Helper.F_ACTION_REMOVE.equals(action)){
				sysCompanyService.removeById(model.getCompanyid());
				return  JSON.toJSONString(new Result(true,"删除成功！",model));
			}else{
				return JSON.toJSONString(new Result(false,"请求参数action错误："+action));
			}
		}catch(Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"操作出现异常:"+e.getMessage().substring(0,40)));
		}
	}
	@RequestMapping(value = "/company_getAll.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String company_getAll() {
		return sysCompanyService.getTreeCompany().toJSONString();
	}
	@RequestMapping(value = "/company_export.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void company_export(HttpServletResponse response){
		JSONArray ja = new JSONArray();
		ja.addAll(sysCompanyService.selectAll());//获取业务数据集
        Map<String,String> headMap = SysCompany.getHeadMap();//获取属性-列头
        String title = "单位部门列表";
        ExcelUtil.downloadExcelFile(title,headMap,ja,response);
	}
	@RequestMapping(value = "/company_getTreeSelect.do", produces="text/html;charset=utf-8")
	@ResponseBody
	public String company_getTreeSelect(){
		return  JSON.toJSONString(new Result(true,"",sysCompanyService.getTreeSelect()));
	}
	//*****************************系统参数设置************************************************
	@RequestMapping(value = "/params_modify.do",params=Helper.PARAM_FUNCTION_ID, produces="text/html;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String params_modify(@RequestBody String data){
		try {
			JSONObject jo = JSONObject.parseObject(data);
			ConfigUtil.writeProperties(ConfigInfo.PROPERTIES_CONFIG,ConfigUtil.entrySet2Pro(jo.entrySet(),true));
			return JSON.toJSONString(new Result(true,"参数设置成功！"));
		} catch (IOException e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"出现IO异常:可能配置文件找不到"));
		}
	}
	/*
	@RequestMapping(value = "/params_sendTestMail.do", produces="text/html;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String params_sendTestMail(String mail_host,int mail_port,String mail_username,String mail_password,
					String mail_from,String mail_to){
		try{
			MailUtil.sendMailForTest(mail_host,mail_port,mail_username,mail_password,mail_from,mail_to);
			return JSON.toJSONString(new Result(true,"测试邮件发送成功,请注意查收！"));
		}catch (MailAuthenticationException e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"邮件认证异常：authentication failure(认证失败)"));
		}catch(MailSendException e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"邮件发送异常：failure when sending the message(发送消息失败)"));
		}catch(MailParseException  e){
			e.printStackTrace();
			return JSON.toJSONString(new Result(false,"邮件消息解析异常：failure when parsing the message(消息解析失败)"));
		}
	}
	*/
}
