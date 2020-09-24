package com.jack.jkbase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysRoleApp;
import com.jack.jkbase.entity.ViewSysRoleApp;
import com.jack.jkbase.mapper.SysRoleAppMapper;
import com.jack.jkbase.mapper.ViewSysRoleAppMapper;
import com.jack.jkbase.service.ISysRoleAppService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysRoleAppServiceImpl extends ServiceImpl<SysRoleAppMapper, SysRoleApp> implements ISysRoleAppService {
	@Autowired ViewSysRoleAppMapper viewMapper;
	public ViewSysRoleApp selectByKey(SysRoleApp key) {
		return viewMapper.selectOne(Wrappers.lambdaQuery(ViewSysRoleApp.class)
				.eq(SysRoleApp::getaRoleid, key.getaRoleid())
				.eq(SysRoleApp::getaAppid, key.getaAppid()));
	}
	public boolean removeByKey(SysRoleApp key) {
		return remove(Wrappers.lambdaQuery(key));
	}
	public List<ViewSysRoleApp> selectAll(){
		return viewMapper.selectList(null);
	}
}
