package com.jack.jkbase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.SysUserRole;
import com.jack.jkbase.entity.ViewSysUser;
import com.jack.jkbase.mapper.SysUserRoleMapper;
import com.jack.jkbase.service.ISysUserRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
	public boolean removeByKey(SysUserRole entity) {
		return remove(Wrappers.lambdaQuery(entity));
	}
	public boolean deleteByUserid(int userid) {
		return remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getrUserid, userid));
	}
	public boolean deleteByRoleid(int roleid) {
		return remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getrRoleid, roleid));
	}
	/**
	 * 根据用户id查找角色id列表
	 */
	public List<SysUserRole> selectByUserid(int userid){
		return list(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getrUserid, userid));
	}
	/**
	 * 批量添加某角色的用户列表
	 */
	public boolean insertbatchForRole(int[] users,int roleid) {
		List<SysUserRole> list = new ArrayList<>();
		for(int userid:users) {
			list.add(new SysUserRole(userid, roleid));
		}
		return saveBatch(list);
	}
	/**
	 * 批量添加某用户的角色列表
	 */
	@Transactional
	public boolean insertbatchForUser(int userid,int[] roleids) {
		deleteByUserid(userid);//先删除
		List<SysUserRole> list = new ArrayList<>();
		for(int roleid:roleids) {
			list.add(new SysUserRole(userid, roleid));
		}
		return saveBatch(list);
	}
}
