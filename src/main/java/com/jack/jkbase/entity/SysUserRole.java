package com.jack.jkbase.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="sys_UserRole")
@IdClass(SysUserRole.class)
public class SysUserRole implements Serializable{
	@Id
	@Column(name="R_UserID")
    private int rUserid;
	
	@Id
	@Column(name="R_RoleID")
    private int rRoleid;

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