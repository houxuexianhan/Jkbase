package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysApp;

public interface SysAppMapper {
	List<SysApp> findAll();
	List<SysApp> findByRole(int roleid);
	List<SysApp> findByaIssys(int isSys);
	//
    int deleteByPrimaryKey(Integer appid);

    int insert(SysApp record);

    int insertSelective(SysApp record);

    SysApp selectByPrimaryKey(Integer appid);

    int updateByPrimaryKeySelective(SysApp record);

    int updateByPrimaryKey(SysApp record);
}