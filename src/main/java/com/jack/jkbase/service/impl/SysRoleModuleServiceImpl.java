package com.jack.jkbase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysRoleModule;
import com.jack.jkbase.mapper.SysRoleModuleMapper;
import com.jack.jkbase.service.ISysRoleModuleService;
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
public class SysRoleModuleServiceImpl extends ServiceImpl<SysRoleModuleMapper, SysRoleModule> implements ISysRoleModuleService {
	@Transactional
	public boolean insertBatch(int roleId,int appid,JSONArray array) {
		//先删除
		String insql =String.format("select ModuleID from sys_module where M_AppID=%d",appid);
		remove(Wrappers.lambdaQuery(SysRoleModule.class)
				.eq(SysRoleModule::getpRoleid, roleId)
				.inSql(SysRoleModule::getpModuleid, insql));
		List<SysRoleModule> list = new ArrayList<>();
		for(int i=0;i<array.size();i++) {
			JSONObject jo = array.getJSONObject(i);
			int val = jo.getIntValue(Helper.KEY_MODULE_VALUE);
			if(val==0) continue;
			SysRoleModule p = new SysRoleModule();
			p.setpRoleid(roleId);
			p.setpModuleid(jo.getIntValue((Helper.KEY_MODULE_CODE)));
			p.setpValue(val);
			list.add(p);
		}
		return saveBatch(list);
	}
}
