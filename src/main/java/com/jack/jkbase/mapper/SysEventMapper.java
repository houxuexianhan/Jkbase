package com.jack.jkbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jack.jkbase.entity.SysEvent;

public interface SysEventMapper extends BaseMapper<SysEvent>{
	//分页返回一页数据以及记录总数
	/*
	List<List<?>> selectByPage(@Param("pageSize") int pageSize ,@Param("pageIndex") int pageIndex ,
			@Param("username")String username,@Param("eventType")Integer eventType,
			@Param("startDate")String startDate,@Param("endDate")String endDate);
	*/
	//
	
}