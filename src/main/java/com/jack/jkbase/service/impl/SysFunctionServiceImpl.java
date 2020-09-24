package com.jack.jkbase.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.SysRoleModule;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysFunctionMapper;
import com.jack.jkbase.mapper.SysRoleModuleMapper;
import com.jack.jkbase.mapper.ViewSysFunctionMapper;
import com.jack.jkbase.mapper.ViewSysModuleMapper;
import com.jack.jkbase.service.ISysFunctionService;
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
public class SysFunctionServiceImpl extends ServiceImpl<SysFunctionMapper, SysFunction> implements ISysFunctionService {
	@Autowired private ViewSysFunctionMapper viewMapper;
	@Autowired private SysRoleModuleMapper roleModuleMapper;
	@Autowired ViewSysModuleMapper  viewMduleMapper;
	public ViewSysFunctionMapper getViewMapper() {
		return viewMapper;
	}
	//order by M_AppID,M_OrderLevel
	public List<ViewSysFunction> selectAll(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.orderByAsc(ViewSysFunction::getmAppid,ViewSysFunction::getmOrderlevel));
	} 
	public ViewSysFunction selectById(int id) {
		return viewMapper.selectById(id);
	}
	public List<ViewSysFunction> selectByModuleid(int moduleId){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.eq(ViewSysFunction::getfModuleid, moduleId)
				.orderByAsc(ViewSysFunction::getfValue));
	}
	public List<ViewSysFunction> selectByAppid(int appid){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.eq(ViewSysFunction::getmAppid, appid)
				.orderByAsc(ViewSysFunction::getmOrderlevel,ViewSysFunction::getfValue));
	}
	@Transactional
	@Override
	public boolean save(SysFunction entity) {
		Integer maxValue = getBaseMapper().selectMaxValue(entity.getfModuleid());
		entity.setfValue(maxValue==null?1:maxValue*2);
		return super.save(entity);
	}
	public JSONArray selectByApp(int appId,int roleId){
		List<ViewSysFunction> list = selectByAppid(appId);
		List<ViewSysModule> mSet = viewMduleMapper.selectList(Wrappers.lambdaQuery(ViewSysModule.class)
				.eq(ViewSysModule::getmAppid, appId));
		//Set<ViewSysModule> mSet = new LinkedHashSet<ViewSysModule>(); 
		Map<Integer, String> parentMap= new LinkedHashMap<Integer, String>();
		//先获取模块的集合
		for(ViewSysModule v : mSet){
			int parentId = v.getmParentid();
			parentMap.put(parentId,parentId==0?"":v.getmParentname());
		}
		//获取权限列表
		List<SysRoleModule> pList = roleModuleMapper.selectList(Wrappers.lambdaQuery(SysRoleModule.class)
				.eq(SysRoleModule::getpRoleid, roleId)
				);
		
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
							for(SysRoleModule p : pList){
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
}
