package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_App",uniqueConstraints = @UniqueConstraint(columnNames = "A_AppName",name = "sys_App_ix"))
public class SysApp {
	@Id
	@Column(name = "AppID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appid;

	@Column(name = "A_AppName",columnDefinition = "nvarchar(50) ",nullable = false)//COMMENT '应用系统名称'
    private String aAppname;

	@Column(name = "A_AppDesc",columnDefinition = "nvarchar(100) ")//COMMENT' 应用系统描述'
    private String aAppdesc;

	@Column(name = "A_AppUrl",columnDefinition = "nvarchar(100) ")// COMMENT' 应用系统URL'
    private String aAppurl;
	
	@Column(name = "A_IsSys",nullable = false,columnDefinition = "int default 0")//comment' 是否框架应用，框架应用不允许非超级用户访问'
    private int aIssys;

	@Column(name = "A_Version",columnDefinition = "nvarchar(50) ")//"COMMENT' 版本号'
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