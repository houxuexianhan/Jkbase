package com.jack.jkbase.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.jkbase.entity.SysEvent;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.mapper.SysEventMapper;
import com.jack.jkbase.util.Helper;
import com.jack.jkbase.util.Page;

@Service
public class SysEventService{
	@Autowired
	private HttpServletRequest request;
	@Autowired
	SysEventMapper mapper;
	//生成事件日志 //1:登录日志  2：操作日志
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
	@SuppressWarnings("unchecked")
	public Page<SysEvent> selectByPage(int pageSize,int pageIndex, String username, Integer eventType, LocalDate startDate, LocalDate endDate) {
		List<List<?>> dataset = mapper.selectByPage( pageSize,pageIndex, username, eventType, startDate.toString(), endDate.plusDays(1).toString());
		List<SysEvent> data = (List<SysEvent>) dataset.get(0);
		int recordCount = ((List<Integer>)dataset.get(1)).get(0);//记录总数 
		return new Page<SysEvent>(pageSize,pageIndex,recordCount,data);
	}
}
