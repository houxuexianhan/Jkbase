package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_Module",indexes = {@Index(name="sys_Module_idx1",columnList = "M_AppID,M_CName",unique = true)
//			,@Index(name="sys_Module_idx2",columnList = "M_Code",unique = true)})
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_module")
public class SysModule implements Serializable {

    private static final long serialVersionUID = 1L;
    public SysModule() {}
    public SysModule(int moduleid,String name) {
    	this.moduleid = moduleid;
    	this.mCname = name;
    }
    
    @TableId(value = "ModuleID", type = IdType.AUTO)
    private int moduleid;

    @TableField("M_AppID")
    private int mAppid;

    @TableField("M_CName")
    private String mCname;

    @TableField("M_Code")
    private String mCode;

    @TableField("M_Icon")
    private String mIcon;

    @TableField("M_IsClose")
    private int mIsclose;

    @TableField("M_OrderLevel")
    private String mOrderlevel;

    @TableField("M_ParentID")
    private int mParentid;

    @TableField("M_URL")
    private String mUrl;

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
	
    public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
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