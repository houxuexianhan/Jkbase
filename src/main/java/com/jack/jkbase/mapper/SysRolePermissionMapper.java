package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysRolePermission;
import com.jack.jkbase.entity.ViewUserRolePerm;

public interface SysRolePermissionMapper {
	List<ViewUserRolePerm> selectModulePerm(int userId,int moduleId);
    
    String permissionValidate(int userId,int functionId);
    //通过存储过程的方式，插入或者更新记录
    int insertOrUpdate(SysRolePermission record);
    
    List<SysRolePermission> selectByRoleApp(int roleId,int appId);
    //
    int deleteByPrimaryKey(Integer permissionid);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}