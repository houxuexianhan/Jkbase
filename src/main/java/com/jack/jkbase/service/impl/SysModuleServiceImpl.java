package com.jack.jkbase.service.impl;

import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.ViewSysModule;
import com.jack.jkbase.mapper.SysModuleMapper;
import com.jack.jkbase.mapper.ViewSysModuleMapper;
import com.jack.jkbase.service.ISysModuleService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements ISysModuleService {
	@Autowired ViewSysModuleMapper viewMapper;
	
	public ViewSysModuleMapper getViewMapper() {
		return viewMapper;
	}
	public void setViewMapper(ViewSysModuleMapper viewMapper) {
		this.viewMapper = viewMapper;
	}
	public List<ViewSysModule> selectAll(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysModule.class)
				.orderByAsc(ViewSysModule::getmAppid,ViewSysModule::getmOrderlevel));
	}
	public ViewSysModule selectById(int id) {
		return viewMapper.selectById(id);
	}
	//查询M_URL不为空的非顶级模块
	public List<ViewSysModule> selectComboExcludeParent(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysModule.class)
				.isNotNull(ViewSysModule::getmUrl).ne(ViewSysModule::getmUrl, "")
				.ne(ViewSysModule::getmParentid, 0)
				.orderByAsc(ViewSysModule::getmAppid,ViewSysModule::getmOrderlevel));
	}
}
