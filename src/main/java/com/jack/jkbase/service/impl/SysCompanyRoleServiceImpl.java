package com.jack.jkbase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysCompany;
import com.jack.jkbase.entity.SysCompanyRole;
import com.jack.jkbase.entity.ViewSysCompanyRole;
import com.jack.jkbase.mapper.SysCompanyRoleMapper;
import com.jack.jkbase.mapper.ViewSysCompanyRoleMapper;
import com.jack.jkbase.service.ISysCompanyRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysCompanyRoleServiceImpl extends ServiceImpl<SysCompanyRoleMapper, SysCompanyRole> implements ISysCompanyRoleService {
	@Autowired ViewSysCompanyRoleMapper viewMapper;
	public List<ViewSysCompanyRole> selectAll(){
		return viewMapper.selectList(null);
	}
	public ViewSysCompanyRole selectByCompanyid(int companyid) {
		return viewMapper.selectOne(Wrappers.lambdaQuery(ViewSysCompanyRole.class)
				.eq(ViewSysCompanyRole::getCompanyid, companyid));
	}
	public JSONObject getTree(){
		JSONObject jo = new JSONObject();
		List<ViewSysCompanyRole> list = selectAll();
		JSONArray ja = new JSONArray();
		for(SysCompany item: list){
			JSONObject joItem = (JSONObject) JSON.toJSON(item);
			if(item.getcParentid()!=0) joItem.put("_parentId",item.getcParentid());
			//第一层(顶层
			joItem.put("iconCls",item.getcLevel()==1?"fa fa-circle-o":"fa fa-circle");
			ja.add(joItem);
		}
		jo.put("rows", ja);
		return jo;
	}
	public boolean removeByKey(SysCompanyRole entity) {
		return remove(Wrappers.lambdaQuery(entity));
	}
	public boolean deleteByCompanyid(int companyid) {
		return remove(Wrappers.lambdaQuery(SysCompanyRole.class).eq(SysCompanyRole::getCompanyid, companyid));
	}
	public boolean deleteByRoleid(int roleid) {
		return remove(Wrappers.lambdaQuery(SysCompanyRole.class).eq(SysCompanyRole::getRoleid, roleid));
	}
	/**
	 * 根据部门id查找角色id列表
	 */
	public List<SysCompanyRole> selectRolesByCompanyid(int companyid){
		return list(Wrappers.lambdaQuery(SysCompanyRole.class).eq(SysCompanyRole::getCompanyid, companyid));
	}
	/*
	 * public List<SysRole> selectRolesByCompanyid(int companyid){ String sql
	 * =String.format("select A_AppId from sys_RoleApp where A_RoleID = %d ",
	 * roleid); return list(Wrappers.lambdaQuery(SysApp.class).eq(SysApp::getaIssys,
	 * 0) .notInSql(SysApp::getAppid, sql)); }
	 */
	/**
	 * 批量添加某部门的角色列表
	 */
	@Transactional
	public boolean insertbatchForCompany(int companyid,int[] roleids) {
		deleteByCompanyid(companyid);//先删除
		if(roleids.length==0) return true;
		List<SysCompanyRole> list = new ArrayList<>();
		for(int roleid:roleids) {
			list.add(new SysCompanyRole(companyid, roleid));
		}
		return saveBatch(list);
	}
}
