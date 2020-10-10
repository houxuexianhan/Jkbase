package com.jack.jkbase.service.impl;

import com.jack.jkbase.annotation.Operation;
import com.jack.jkbase.config.ShiroConfig;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysUser;
import com.jack.jkbase.mapper.SysUserMapper;
import com.jack.jkbase.mapper.ViewSysUserMapper;
import com.jack.jkbase.service.ISysUserService;
import com.jack.jkbase.util.Helper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	@Autowired ViewSysUserMapper viewMapper;
	
	public ViewSysUserMapper getViewMapper() {
		return viewMapper;
	}
	@Operation(type=Helper.logTypeOperation,desc="用户更改个人密码",arguDesc={"用户ID",""})
	public boolean updatePassword(int userid,String password,String salt){
		return update(null,Wrappers.lambdaUpdate(SysUser.class).eq(SysUser::getUserid, userid)
				.set(SysUser::getuPwd, ShiroConfig.hashUserPwd(password,salt))
			);
	}
	public boolean updateUserInfo(int userid,int companyid,String mobile,String nick){
		return update(null,Wrappers.lambdaUpdate(SysUser.class).eq(SysUser::getUserid, userid)
				.set(SysUser::getuCompanyid, companyid)
				.set(SysUser::getuCname, nick)
				.set(SysUser::getuMobileno, mobile)
			);
	}
	//@Operation(type=Helper.logTypeOperation,desc="用户修改头像",arguDesc={"用户ID",""})
	public boolean updatePhoto(int userid,String photo){
		return update(null,Wrappers.lambdaUpdate(SysUser.class).eq(SysUser::getUserid, userid)
				.set(SysUser::getuPhotourl, photo)
			);
	}
	//根据角色id查找用户列表，不包含超级管理员
	public List<ViewSysUser> selectByRoleExclude(int roleId){
		String sql = String.format("select R_UserID from sys_user_role where R_RoleID =%d ",roleId);
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysUser.class)
				.select(SysUser::getUserid,SysUser::getuCname,ViewSysUser::getuCompanyname)
				.ne(SysUser::getUserid, Helper.adminId)
				.notInSql(ViewSysUser::getUserid, sql) );
	}
	//根据角色id查找用户列表
	public List<ViewSysUser> selectByRoleid(int roleId){
		String sql = String.format("select R_UserID from sys_user_role where R_RoleID =%d ",roleId);
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysUser.class)
				.inSql(ViewSysUser::getUserid, sql) );
	}
	public List<ViewSysUser> selectAll(){
		return viewMapper.selectList(null);
	}
	public ViewSysUser selecById(int id) {
		return viewMapper.selectById(id);
	}
	public ViewSysUser selectByUsername(String username) {
		return viewMapper.selectOne(Wrappers.lambdaQuery(ViewSysUser.class)
				.eq(ViewSysUser::getuLoginname, username));
	}
}
