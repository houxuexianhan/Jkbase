package com.jack.jkbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.entity.SysRolePermission;
import com.jack.jkbase.mapper.SysRolePermissionMapper;
import com.jack.jkbase.util.Helper;

@Service
public class SysRolePermissionService {
	@Autowired
	SysRolePermissionMapper mapper;
	//此service 将开启事务
	public int insertBatch(int roleId,int appId,JSONArray array){
		int rs = 0;
		for(int i=0;i<array.size();i++){
			JSONObject jo = array.getJSONObject(i);
			SysRolePermission p = new SysRolePermission();
			p.setPermissionid(-1);
			p.setpAppid(appId);
			p.setpRoleid(roleId);
			p.setpModuleid(jo.getIntValue((Helper.KEY_MODULE_CODE)));
			p.setpValue(jo.getIntValue(Helper.KEY_MODULE_VALUE));
			rs += mapper.insertOrUpdate(p);
		}
		return rs;
	}
	public List<SysRolePermission> selectByRoleApp(int roleId,int appId){
		return mapper.selectByRoleApp(roleId,appId);
	}
}