package com.jack.jkbase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysCompanyRole;
import com.jack.jkbase.mapper.SysCompanyRoleMapper;
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
	public List<SysCompanyRole> selectByCompanyid(int companyid){
		return list(Wrappers.lambdaQuery(SysCompanyRole.class).eq(SysCompanyRole::getCompanyid, companyid));
	}
	/**
	 * 批量添加某角色的用户列表
	 */
	public boolean insertbatchForRole(int[] companyids,int roleid) {
		List<SysCompanyRole> list = new ArrayList<>();
		for(int userid:companyids) {
			list.add(new SysCompanyRole(userid, roleid));
		}
		return saveBatch(list);
	}
	/**
	 * 批量添加某部门的角色列表
	 */
	@Transactional
	public boolean insertbatchForCompany(int companyid,int[] roleids) {
		deleteByCompanyid(companyid);//先删除
		List<SysCompanyRole> list = new ArrayList<>();
		for(int roleid:roleids) {
			list.add(new SysCompanyRole(companyid, roleid));
		}
		return saveBatch(list);
	}
}
