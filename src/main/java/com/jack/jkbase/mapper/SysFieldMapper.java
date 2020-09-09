package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysField;

public interface SysFieldMapper {
	List<SysField> findAll();
	//
    int deleteByPrimaryKey(Integer fieldid);

    int insert(SysField record);

    int insertSelective(SysField record);

    SysField selectByPrimaryKey(Integer fieldid);

    int updateByPrimaryKeySelective(SysField record);

    int updateByPrimaryKey(SysField record);
}