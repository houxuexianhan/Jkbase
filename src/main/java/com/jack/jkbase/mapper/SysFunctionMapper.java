package com.jack.jkbase.mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.jkbase.entity.SysFunction;

public interface SysFunctionMapper extends BaseMapper<SysFunction>{
	//返回空值或者最大值
	@Select("select max(F_Value) from sys_function where F_ModuleId=#{value}")
	Integer selectMaxValue(int moduleid);
}