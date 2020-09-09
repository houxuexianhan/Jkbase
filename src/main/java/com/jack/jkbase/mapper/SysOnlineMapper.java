package com.jack.jkbase.mapper;

import com.jack.jkbase.entity.SysOnline;

public interface SysOnlineMapper {
    int deleteByPrimaryKey(String oSessionid);

    int insert(SysOnline record);

    int insertSelective(SysOnline record);

    SysOnline selectByPrimaryKey(String oSessionid);

    int updateByPrimaryKeySelective(SysOnline record);

    int updateByPrimaryKey(SysOnline record);
}