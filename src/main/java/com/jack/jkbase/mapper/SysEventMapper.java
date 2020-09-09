package com.jack.jkbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jack.jkbase.entity.SysEvent;

public interface SysEventMapper {
	//分页返回一页数据以及记录总数
	List<List<?>> selectByPage(@Param("pageSize") int pageSize ,@Param("pageIndex") int pageIndex ,
			@Param("username")String username,@Param("eventType")Integer eventType,
			@Param("startDate")String startDate,@Param("endDate")String endDate);
	//
    int deleteByPrimaryKey(Long eventid);

    int insert(SysEvent record);

    int insertSelective(SysEvent record);

    SysEvent selectByPrimaryKey(Long eventid);

    int updateByPrimaryKeySelective(SysEvent record);

    int updateByPrimaryKey(SysEvent record);
}