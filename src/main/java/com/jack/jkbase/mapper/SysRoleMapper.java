package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysRole;

public interface SysRoleMapper {
	List<SysRole> findAll();
	//
    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}