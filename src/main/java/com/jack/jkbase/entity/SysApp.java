package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_App",uniqueConstraints = @UniqueConstraint(columnNames = "A_AppName",name = "sys_App_ix"))
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_app")
public class SysApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "AppID", type = IdType.AUTO)
    private int appid;

    @TableField("A_AppDesc")
    private String aAppdesc;

    @TableField("A_AppName")
    private String aAppname;

    @TableField("A_AppUrl")
    private String aAppurl;

    @TableField("A_IsSys")
    private int aIssys;

    @TableField("A_Version")
    private String aVersion;

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getaAppname() {
        return aAppname;
    }

    public void setaAppname(String aAppname) {
        this.aAppname = aAppname == null ? null : aAppname.trim();
    }

    public String getaAppdesc() {
        return aAppdesc;
    }

    public void setaAppdesc(String aAppdesc) {
        this.aAppdesc = aAppdesc == null ? null : aAppdesc.trim();
    }

    public String getaAppurl() {
        return aAppurl;
    }

    public void setaAppurl(String aAppurl) {
        this.aAppurl = aAppurl == null ? null : aAppurl.trim();
    }

    public int getaIssys() {
        return aIssys;
    }

    public void setaIssys(int aIssys) {
        this.aIssys = aIssys;
    }

    public String getaVersion() {
        return aVersion;
    }

    public void setaVersion(String aVersion) {
        this.aVersion = aVersion == null ? null : aVersion.trim();
    }
}