package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_company_role")
public class SysCompanyRole implements Serializable{
	
	public SysCompanyRole() {}
	public SysCompanyRole(int companyid,int roleid) {
		this.companyid = companyid;
		this.roleid = roleid;
	}
	
	@TableField(value = "Companyid")
	private int companyid;
	
	@TableField(value = "Roleid")
	private int roleid;

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
