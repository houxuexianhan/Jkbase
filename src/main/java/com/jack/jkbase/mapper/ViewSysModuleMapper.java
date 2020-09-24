package com.jack.jkbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.jkbase.entity.ViewSysModule;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
public interface ViewSysModuleMapper extends BaseMapper<ViewSysModule> {

	@Select("select * from view_sys_user_role_module where R_UserID =#{value}")
	List<ViewSysModule> selectByUserid(int userid);
	
	//查询某用户的模块权限值,由于多角色，可能有多个值
	@Select("select P_Value from view_sys_user_role_module where R_UserID=#{param1} and P_ModuleID=#{param2}")
	List<Integer> getModValueForUser(int userid,int moduleid);
}
