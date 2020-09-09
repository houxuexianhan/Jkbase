package com.jack.jkbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jack.jkbase.entity.SysUserRole;
import com.jack.jkbase.entity.ViewUserRole;

public interface SysUserRoleMapper {
	List<ViewUserRole> selectByRoleId(int roleId);
    
    int insertbatchForRole(@Param("users")int[] users,@Param("roleId")int roleId);
    
    List<SysUserRole> selectByUser(int userId);
    
    int insertbatchForUser(@Param("roles")int[] roles,@Param("userId")int userId);
    int deleteByUser(int userId);
    int deleteByRole(int roleId);
    
    //
    int deleteByPrimaryKey(SysUserRole key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}