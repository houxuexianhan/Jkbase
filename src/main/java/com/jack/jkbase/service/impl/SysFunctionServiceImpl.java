package com.jack.jkbase.service.impl;

import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.ViewSysFunction;
import com.jack.jkbase.mapper.SysFunctionMapper;
import com.jack.jkbase.mapper.ViewSysFunctionMapper;
import com.jack.jkbase.service.ISysFunctionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysFunctionServiceImpl extends ServiceImpl<SysFunctionMapper, SysFunction> implements ISysFunctionService {
	@Autowired private ViewSysFunctionMapper viewMapper;
	public ViewSysFunctionMapper getViewMapper() {
		return viewMapper;
	}
	//order by M_AppID,M_OrderLevel
	public List<ViewSysFunction> selectAll(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.orderByAsc(ViewSysFunction::getmAppid,ViewSysFunction::getmOrderlevel));
	} 
	public ViewSysFunction selectById(int id) {
		return viewMapper.selectById(id);
	}
	public List<ViewSysFunction> selectByModuleid(int moduleId){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.eq(ViewSysFunction::getfModuleid, moduleId)
				.orderByAsc(ViewSysFunction::getfValue));
	}
	public List<ViewSysFunction> selectByAppid(int appid){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysFunction.class)
				.eq(ViewSysFunction::getmAppid, appid)
				.orderByAsc(ViewSysFunction::getmOrderlevel,ViewSysFunction::getfValue));
	}
	@Transactional
	@Override
	public boolean save(SysFunction entity) {
		Integer maxValue = getBaseMapper().selectMaxValue(entity.getfModuleid());
		entity.setfValue(maxValue==null?1:maxValue*2);
		return super.save(entity);
	}
}
