package com.jack.jkbase.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jack.jkbase.annotation.Operation;
import com.jack.jkbase.config.ShiroConfig;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysUser;
import com.jack.jkbase.mapper.SysUserMapper;
import com.jack.jkbase.mapper.SysUserRoleMapper;
import com.jack.jkbase.util.ConfigInfo;
import com.jack.jkbase.util.Helper;

//@Service
public class SysUserService{
	//@Autowired 
	SysUserMapper mapper;
	//@Autowired 
	SysUserRoleMapper userRolemapper;
	//access
	@Operation(type=Helper.logTypeOperation,desc="更新用户表",arguDesc={"用户","操作类型"})
	public int access(SysUser model,String action) throws Exception{
		/*
		 * int rs = mapper.access(model,action); if(rs == -2) throw new
		 * Exception("操作失败，账号(登录名重复！"); return rs;
		 */
		return 1;
	}
	@Operation(type=Helper.logTypeOperation,desc="删除用户",arguDesc={"用户","角色Ids"})
	public int deleteUser(SysUser model,int[] roles)throws Exception{
		/*
		 * if(model.getuType()==0) throw new Exception("不能删除超级账号!!");
		 * userRolemapper.deleteByUser(model.getUserid()); int rs =
		 * mapper.access(model,DBAction.Delete.name); return rs;
		 */
		return 1;
	}
	/*
	 * public SysUser selectByUsername(String username){ return
	 * mapper.selectUsername(username); }
	 */

	/*
	 * public List<ViewSysUser> selectByRoleExclude(int roleId){ return
	 * mapper.selectByRoleExclude(roleId); }
	 */
	@Operation(type=Helper.logTypeOperation,desc="用户更改个人密码",arguDesc={"用户ID",""})
	public int updatePassword(int userid,String password,String salt){
		return mapper.update(null,new LambdaUpdateWrapper<SysUser>().eq(SysUser::getUserid, userid)
				.set(SysUser::getuPwd, ShiroConfig.hashUserPwd(password,salt))
			);
	}
	@Operation(type=Helper.logTypeOperation,desc="用户修改头像",arguDesc={"用户ID",""})
	public int updatePhoto(int userid,String photo){
		return mapper.update(null,new LambdaUpdateWrapper<SysUser>().eq(SysUser::getUserid, userid)
				.set(SysUser::getuPhotourl, photo)
			);
	}
	//校验输入,返回null表示成功
	public String validate(SysUser model){
		if(model.getuLoginname()==null||model.getuLoginname().trim().isEmpty()) return "登录名不能为空！";
		if(model.getuCname()==null||model.getuCname().trim().isEmpty()) return "用户姓名不能为空！";
		return null;
	}
	/*
	 * public SysUser selectByPrimaryKey(int id) { return
	 * mapper.selectByPrimaryKey(id); } public List<ViewSysUser> selectAll() {
	 * return mapper.selectAll(); }
	 */
}
