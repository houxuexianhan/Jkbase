package com.jack.jkbase.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.jkbase.entity.SysFieldValue;

public interface SysFieldValueMapper extends BaseMapper<SysFieldValue>{
	List<SysFieldValue> findAll();
	List<SysFieldValue> findByvFieldid(int fid);
}