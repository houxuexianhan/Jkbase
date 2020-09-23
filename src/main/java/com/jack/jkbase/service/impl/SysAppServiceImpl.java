package com.jack.jkbase.service.impl;

import com.jack.jkbase.entity.SysApp;
import com.jack.jkbase.mapper.SysAppMapper;
import com.jack.jkbase.service.ISysAppService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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
public class SysAppServiceImpl extends ServiceImpl<SysAppMapper, SysApp> implements ISysAppService {
	//select * from sys_App where A_IsSys =0 and AppID not in ( select A_AppId from sys_RoleApp where A_RoleID = #{value} )
	public List<SysApp> selectByRoleid(int roleid){
		String sql =String.format("select A_AppId from sys_RoleApp where A_RoleID = %d ", roleid);
		return list(Wrappers.lambdaQuery(SysApp.class).eq(SysApp::getaIssys, 0)
				.notInSql(SysApp::getAppid, sql));
	}
	public List<SysApp> findByaIssys(int isSys){
		return list(Wrappers.lambdaQuery(SysApp.class).eq(SysApp::getaIssys, isSys));
	}
}
