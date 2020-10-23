package com.jack.jkbase.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysModuleMapper;
import com.jack.jkbase.mapper.ViewSysModuleMapper;
import com.jack.jkbase.service.ISysModuleService;
import com.jack.jkbase.util.Helper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements ISysModuleService {
	@Autowired ViewSysModuleMapper viewMapper;
	
	public List<ViewSysModule> selectAll(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysModule.class)
				.orderByAsc(ViewSysModule::getmAppid,ViewSysModule::getmOrderlevel));
	}
	public ViewSysModule selectById(int id) {
		return viewMapper.selectById(id);
	}
	//查询M_URL不为空的非顶级模块
	public List<ViewSysModule> selectComboExcludeParent(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysModule.class)
				.isNotNull(ViewSysModule::getmUrl).ne(ViewSysModule::getmUrl, "")
				.ne(ViewSysModule::getmParentid, 0)
				.orderByAsc(ViewSysModule::getmAppid,ViewSysModule::getmOrderlevel));
	}
	/*
	<select id="selectByUserId" resultMap="BaseResultMap">
  	select m.* from sys_user_role r inner join sys_rolepermission p on r.R_RoleID=p.P_RoleID and p.P_Value>0 
	inner join view_sys_module m on m.ModuleId=p.P_ModuleID order by M_AppID,M_OrderLevel;
  </select>
	 */
	//返回权限模块
	
	public List<ViewSysModule> getModulesByUser(int userId){
		return viewMapper.selectByUserid(userId);
	}
	// 返回json格式的树形导航菜单
	public JSONArray getTreeMenuByUser(int userId){
		if(userId==Helper.adminId){//超级管理员
			return treeMenuList(selectAll(), 0);
		}else{
			return treeMenuList(getPriModules(userId), 0);
		}
	}
	// 菜单树形结构
	public JSONArray treeMenuList(List<ViewSysModule> menuList, int parentId) {
		JSONArray childMenu = new JSONArray();
		for (ViewSysModule menu : menuList) {
			if (parentId == menu.getmParentid() && menu.getmIsclose()==Helper.MODULE_NOT_CLOSE) {
				JSONObject jo = (JSONObject) JSONObject.toJSON(menu);
				JSONArray c_node = treeMenuList(menuList, menu.getModuleid());
				jo.put("children", c_node);
				childMenu.add(jo);
			}
		}
		return childMenu;
	}
	
	public List<ViewSysModule> getPriModules(int userId){
		List<ViewSysModule> all = selectAll();
		List<ViewSysModule> pri = getModulesByUser(userId);
		
		return new ArrayList<ViewSysModule>( generateModules(pri,all));
	}
	
	//递归的添加父节点 直到顶级
	public Set<ViewSysModule> generateModules(List<ViewSysModule> pri,List<ViewSysModule> all){
		Set<ViewSysModule> set = new LinkedHashSet<ViewSysModule>();
		set.addAll(pri);
		for(ViewSysModule m :pri){
			set.addAll(getParentModule(m.getmParentid(),all));
		}
		return set;
	}
	//递归获取某个模块的父节点集合
	public Set<ViewSysModule> getParentModule(int parentId,List<ViewSysModule> all){
		Set<ViewSysModule> set = new LinkedHashSet<ViewSysModule>();
		ViewSysModule p = getModule(parentId,all);
		if(p==null){//说明其父节点是顶级节点
			
		}else{
			set.add(p);
			set.addAll(getParentModule(p.getmParentid(),all));
		}
		return set;
	}
	//从list中获得muduleId
	private ViewSysModule getModule(int moduleId,List<ViewSysModule> list){
		for(ViewSysModule m : list){
			if(m.getModuleid() == moduleId){
				return m;
			}
		}
		return null;
	}
	public int getModulePerm(int userid, int moduleid) {
		if(userid==Helper.adminId) return -1;
		List<Integer> arr = viewMapper.getModValueForUser(userid, moduleid);
		if(arr.size()==0) return 0;
		int mod = 0;
		for(int val : arr) {
			mod |= val;  //按位 或 运算
		}
		return mod;
	}
}
