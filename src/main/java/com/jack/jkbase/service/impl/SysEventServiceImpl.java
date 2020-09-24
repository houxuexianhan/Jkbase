package com.jack.jkbase.service.impl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysEvent;
import com.jack.jkbase.mapper.SysEventMapper;
import com.jack.jkbase.service.ISysEventService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysEventServiceImpl extends ServiceImpl<SysEventMapper, SysEvent> implements ISysEventService {
	/*
	List<List<?>> selectByPage(@Param("pageSize") int pageSize ,@Param("pageIndex") int pageIndex ,
			@Param("username")String username,@Param("eventType")Integer eventType,
			@Param("startDate")String startDate,@Param("endDate")String endDate);*/
	public IPage<SysEvent> selectByPage(int pageSize ,int pageIndex ,
			String username,Integer eventType,LocalDate startDate,LocalDate endDate) {
		Page<SysEvent> p = new Page<>(pageIndex,pageSize);
		
		return page(p,Wrappers.lambdaQuery(SysEvent.class)
				.eq(!StringUtils.isEmpty(username) ,SysEvent::geteUsername, username)
				.eq(eventType!=null&&eventType>0 ,SysEvent::geteType, eventType)
				.ge(startDate!=null,SysEvent::geteDatetime, startDate)
				.lt(endDate!=null,SysEvent::geteDatetime,  endDate));
	}
	/*
	public int insertEventLog(int type,String log) {
		//System.out.println(log);
		Object o =  request.getSession().getAttribute(Helper.SESSION_USER);
		if(o==null) return -1; 
		SysUser loginUser= (SysUser) o;
		SysEvent sysEvent = new SysEvent();
		sysEvent.seteType(type);
		sysEvent.seteDatetime(new Date());
		if (loginUser != null) {
			sysEvent.seteUsername(loginUser.getuCname());
			sysEvent.seteUserid(loginUser.getUserid());
		}
		sysEvent.seteIp(Helper.getIpAddress(request));
		sysEvent.seteRecord(log);
		int rs = 0;
		try{
			rs = mapper.insertSelective(sysEvent);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	*/
}
