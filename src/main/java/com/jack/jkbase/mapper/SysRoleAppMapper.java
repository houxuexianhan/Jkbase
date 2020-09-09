package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysRoleApp;
import com.jack.jkbase.entity.ViewRoleApp;

public interface SysRoleAppMapper {
	List<ViewRoleApp> selectAll();
	ViewRoleApp selectByPK(SysRoleApp key);
	//
	int deleteByPrimaryKey(SysRoleApp key);
    int insert(SysRoleApp record);
    int insertSelective(SysRoleApp record);
}