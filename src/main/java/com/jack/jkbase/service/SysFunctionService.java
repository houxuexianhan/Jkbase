package com.jack.jkbase.service;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.SysRolePermission;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysFunctionMapper;
import com.jack.jkbase.mapper.SysModuleMapper;
import com.jack.jkbase.mapper.SysRolePermissionMapper;
import com.jack.jkbase.util.Helper;

@Service
public class SysFunctionService {
	@Autowired
	SysFunctionMapper mapper;
	@Autowired
	SysModuleMapper frmModuleMapper;
	@Autowired 
	SysRolePermissionMapper sysRolePermissionMapper;
	public JSONArray selectByApp(int appId,int roleId){
		List<ViewSysFunction> list = mapper.selectByApp(appId);
		Set<ViewSysModule> mSet = new LinkedHashSet<ViewSysModule>(); 
		Map<Integer, String> parentMap= new LinkedHashMap<Integer, String>();
		//先获取模块的集合
		for(ViewSysFunction v : list){
			mSet.add(v.getModule());
			int parentId = v.getModule().getmParentid();
			parentMap.put(parentId,parentId==0?"":v.getModule().getmParentname());
		}
		//获取权限列表
		List<SysRolePermission> pList = sysRolePermissionMapper.selectByRoleApp(roleId,appId); 
		
		JSONArray rootJa = new JSONArray();
		for(Entry<Integer, String> parent : parentMap.entrySet()){
			JSONObject joParent = new JSONObject();
			joParent.put("parent",parent.getValue());
			//解析，按模块分组
			JSONArray jaModule = new JSONArray();
			for(ViewSysModule m : mSet){
				if(parent.getKey().equals(m.getmParentid())){
					JSONObject jo = (JSONObject) JSONObject.toJSON(m);
					JSONArray jaFunction = new JSONArray();
					for(ViewSysFunction func : list){
						if(func.getfModuleid()==m.getModuleid()){
							//判断是否具有权限,如果设置的模块权限值小于0表示无限制
							for(SysRolePermission p : pList){
								if(p.getpModuleid()==m.getModuleid()){
									int pValue = p.getpValue();
									func.setAccess((pValue&func.getfValue())==func.getfValue());
								}
							}
							
							jaFunction.add(func);
						}
					}
					//如果该模块没有功能，则不显示该模块的权限设置
					if(jaFunction.size()>0){
						jo.put(Helper.KEY_FUNCTIONS,jaFunction);
						jaModule.add(jo);
					}
				}
			}
			joParent.put("modules",jaModule);
			rootJa.add(joParent);
		}
		return rootJa;
	}
	public List<ViewSysFunction> selectByModule(int moduleId){
		return mapper.selectByModule(moduleId);
	}
	public List<ViewSysFunction> selectAll(){
		return mapper.selectAll();
	}

	/*
	 * @Operation(type=Helper.logTypeOperation,desc="更新功能表",arguDesc={"功能","操作类型"})
	 * public int access(SysFunction model,String action) throws Exception{ int rs =
	 * mapper.access(model,action); if(rs == -2) throw new
	 * Exception("操作失败，同一模块的功能名称或权限值不能重复！"); return rs; }
	 */
	public SysFunction selectByPrimaryKey(int funtionid) {
		return mapper.selectByPrimaryKey(funtionid);
	}
}
