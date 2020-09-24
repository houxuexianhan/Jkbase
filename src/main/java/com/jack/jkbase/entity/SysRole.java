package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole {
	private static final long serialVersionUID = 1L;

	@TableId(value = "RoleID", type = IdType.AUTO)
	private int roleid;

	@TableField("R_Description")
	private String rDescription;

	@TableField("R_RoleName")
	private String rRolename;

	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public String getrRolename() {
		return rRolename;
	}

	public void setrRolename(String rRolename) {
		this.rRolename = rRolename;
	}
	
}