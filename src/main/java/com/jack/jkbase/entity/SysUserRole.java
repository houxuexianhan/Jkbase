package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_UserRole")
//@IdClass(SysUserRole.class)
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role")
public class SysUserRole implements Serializable{
	private static final long serialVersionUID = 1L;
	public SysUserRole() {}
	@TableField("R_UserID")
    private int rUserid;

    @TableField("R_RoleID")
    private int rRoleid;
    public SysUserRole(int rUserid, int rRoleid) {
		this.rUserid = rUserid;
		this.rRoleid = rRoleid;
	}
	public int getrUserid() {
		return rUserid;
	}

	public void setrUserid(int rUserid) {
		this.rUserid = rUserid;
	}

	public int getrRoleid() {
		return rRoleid;
	}

	public void setrRoleid(int rRoleid) {
		this.rRoleid = rRoleid;
	}
    
}