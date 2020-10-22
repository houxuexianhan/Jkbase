package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 注意此视图以companyid作为主键，没有roleid字段
 * @author LIBO
 *
 */
@TableName("view_sys_company_role")
public class ViewSysCompanyRole extends SysCompany{
	//@TableField("roles")
	private String roles=""; //逗号分隔的角色列表

	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
