package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="sys_Module",indexes = {@Index(name="sys_Module_idx1",columnList = "M_AppID,M_CName",unique = true)})
public class SysModule {
	@Id
	@Column(name="ModuleID")//COMMENT '模块ID'
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moduleid;
	
	@Column(name="M_AppID",nullable = false)//,columnDefinition = "comment '应用ID'")
    private int mAppid;

	@Column(name="M_ParentID",nullable=false)
    private int mParentid;

	@Column(name="M_CName",nullable=false,columnDefinition = "nvarchar(50)")//COMMENT '模块名称,当ParentID为0,为模组名称'
    private String mCname;

	@Column(name="M_URL",columnDefinition = "nvarchar(100)")//comment '模块路径URL'
    private String mUrl;

	@Column(name="M_OrderLevel",length=4)//comment '当前所在排序级别支持双层99级菜单'
    private String mOrderlevel;

	@Column(name="M_IsSys",nullable=false)//comment '是否系统模块(1-是,0-否),如为系统则不允许修改'
    private int mIssys;

	@Column(name="M_IsClose",nullable=false)//comment '是否关闭(1-是,0-否)'
    private int mIsclose;

	@Column(name="M_Icon",length=50)//
    private String mIcon;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + moduleid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysModule other = (SysModule) obj;
		if (moduleid != other.moduleid)
			return false;
		return true;
	}

	public void setmAppid(int mAppid) {
        this.mAppid = mAppid;
    }
	
    public int getmAppid() {
        return mAppid;
    }

    public int getModuleid() {
        return moduleid;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

	public int getmParentid() {
        return mParentid;
    }

    public void setmParentid(int mParentid) {
        this.mParentid = mParentid;
    }

    public String getmCname() {
        return mCname;
    }

    public void setmCname(String mCname) {
        this.mCname = mCname == null ? null : mCname.trim();
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public String getmOrderlevel() {
        return mOrderlevel;
    }

    public void setmOrderlevel(String mOrderlevel) {
        this.mOrderlevel = mOrderlevel == null ? null : mOrderlevel.trim();
    }

    public int getmIssys() {
        return mIssys;
    }

    public void setmIssys(int mIssys) {
        this.mIssys = mIssys;
    }

    public int getmIsclose() {
        return mIsclose;
    }

    public void setmIsclose(int mIsclose) {
        this.mIsclose = mIsclose;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon == null ? null : mIcon.trim();
    }
}