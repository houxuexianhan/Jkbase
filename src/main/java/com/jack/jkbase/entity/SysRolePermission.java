package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_RolePermission",uniqueConstraints =@UniqueConstraint(columnNames = {"P_RoleID","P_AppID","P_ModuleID"}
				,name = "sys_RolePermission_ix"))
public class SysRolePermission {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PermissionID")
    private int permissionid;

	@Column(name="P_Value",nullable=false)//权限值（此值与功能表的值做与运算，若其和==功能值，表示对该功能有权限操作，否则无）
    private int pValue;
	
	@Column(name="P_RoleID",nullable=false)
    private int pRoleid;

	@Column(name="P_AppID",nullable=false)
    private int pAppid;

	@Column(name="P_ModuleID",nullable=false)
    private int pModuleid;

    public int getpRoleid() {
        return pRoleid;
    }

    public void setpRoleid(int pRoleid) {
        this.pRoleid = pRoleid;
    }

    public int getpAppid() {
        return pAppid;
    }

    public void setpAppid(int pAppid) {
        this.pAppid = pAppid;
    }

    
    public int getpModuleid() {
		return pModuleid;
	}

	public void setpModuleid(int pModuleid) {
		this.pModuleid = pModuleid;
	}

	public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    public int getpValue() {
        return pValue;
    }

    public void setpValue(int pValue) {
        this.pValue = pValue;
    }
}