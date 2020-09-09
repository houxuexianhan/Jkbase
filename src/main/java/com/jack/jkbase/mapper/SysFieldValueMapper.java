package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysFieldValue;

public interface SysFieldValueMapper {
	List<SysFieldValue> findAll();
	List<SysFieldValue> findByvFieldid(int fid);
	//
    int deleteByPrimaryKey(Integer valueid);

    int insert(SysFieldValue record);

    int insertSelective(SysFieldValue record);

    SysFieldValue selectByPrimaryKey(Integer valueid);

    int updateByPrimaryKeySelective(SysFieldValue record);

    int updateByPrimaryKey(SysFieldValue record);
}