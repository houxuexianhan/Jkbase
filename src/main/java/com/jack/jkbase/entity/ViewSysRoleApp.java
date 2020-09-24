package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("view_sys_role_app")
public class ViewSysRoleApp extends SysRoleApp {
	@TableField("R_RoleName")
	private String rRolename;

	@TableField("A_AppName")
	private String aAppname;

	public String getrRolename() {
		return rRolename;
	}

	public void setrRolename(String rRolename) {
		this.rRolename = rRolename;
	}

	public String getaAppname() {
		return aAppname;
	}

	public void setaAppname(String aAppname) {
		this.aAppname = aAppname;
	}
	
	
}