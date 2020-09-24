package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_RoleApp")
//@IdClass(SysRoleApp.class)
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_app")
public class SysRoleApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("A_RoleID")
    private int aRoleid;

    @TableField("A_AppID")
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