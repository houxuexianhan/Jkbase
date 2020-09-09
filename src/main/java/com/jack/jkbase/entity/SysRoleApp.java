package com.jack.jkbase.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="sys_RoleApp")
@IdClass(SysRoleApp.class)
public class SysRoleApp implements Serializable{
	@Id
    @Column(name="A_RoleID")
    private int aRoleid;
	
	@Id
	@Column(name="A_AppID")
    private int aAppid;

    public int getaRoleid() {
        return aRoleid;
    }

    public void setaRoleid(int aRoleid) {
        this.aRoleid = aRoleid;
    }

    public int getaAppid() {
        return aAppid;
    }

    public void setaAppid(int aAppid) {
        this.aAppid = aAppid;
    }
}