package com.jack.jkbase.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysModuleMapper;
import com.jack.jkbase.util.Helper;

@Service
public class SysModuleService{
	@Autowired SysModuleMapper mapper;
	
	public ViewSysModule selectByPrimaryKey(int moduleid) {
		return mapper.selectByPrimaryKey(moduleid);
	}
	//返回List
	public List<ViewSysModule> getModules(){
		return mapper.selectAll();
	}
	//返回权限模块
	public List<ViewSysModule> getModulesByUser(int userId){
		return mapper.selectByUserId(userId);
	}
	// 返回json格式的树形导航菜单
	public JSONArray getTreeMenu() {
		return treeMenuList(getModules(), 0);
	}
	public JSONArray getTreeMenuByUser(int userId){
		if(userId==Helper.adminId){//超级管理员
			return treeMenuList(getModules(), 0);
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
		List<ViewSysModule> all = getModules();
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
	public List<ViewSysModule> selectComboExcludeParent(){
		return mapper.selectComboExcludeParent();
	}
}
