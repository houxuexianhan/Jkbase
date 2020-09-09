package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysArea;

public interface SysAreaMapper {
	List<SysArea> selectAll();
	int deleteAllByParent(int parentId);
	//
    int deleteByPrimaryKey(Integer areaid);

    int insert(SysArea record);

    int insertSelective(SysArea record);

    SysArea selectByPrimaryKey(Integer areaid);

    int updateByPrimaryKeySelective(SysArea record);

    int updateByPrimaryKey(SysArea record);
}