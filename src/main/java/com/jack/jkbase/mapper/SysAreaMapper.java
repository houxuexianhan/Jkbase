package com.jack.jkbase.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.jkbase.entity.SysArea;

public interface SysAreaMapper extends BaseMapper<SysArea>{
	List<SysArea> selectAll();
	int deleteAllByParent(int parentId);
	
	
}