package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_RolePermission",uniqueConstraints =@UniqueConstraint(columnNames = {"P_RoleID","P_AppID","P_ModuleID"}
//				,name = "sys_RolePermission_ix"))
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_module")
public class SysRoleModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("P_ModuleID")
    private int pModuleid;

    @TableField("P_RoleID")
    private int pRoleid;

    @TableField("P_Value")
    private int pValue;

    public int getpRoleid() {
        return pRoleid;
    }

    public void setpRoleid(int pRoleid) {
        this.pRoleid = pRoleid;
    }

    public int getpModuleid() {
		return pModuleid;
	}

	public void setpModuleid(int pModuleid) {
		this.pModuleid = pModuleid;
	}

    public int getpValue() {
        return pValue;
    }

    public void setpValue(int pValue) {
        this.pValue = pValue;
    }
}