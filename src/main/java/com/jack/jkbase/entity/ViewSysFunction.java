package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("view_sys_function")
public class ViewSysFunction extends SysFunction{
	@TableField("M_CName")
    private String mCname;
	
	@TableField("M_AppID")
    private int mAppid;
	
	@TableField("M_OrderLevel")
    private String mOrderlevel;
	
    @TableField("M_ParentName")
    private String mParentname;
    
    @TableField("A_AppName")
    private String aAppname;
	 //某个角色下对本功能是否有权限，默认无权限
    @TableField(exist = false)
    private boolean access = false;
    
    public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public String getmParentname() {
		return mParentname;
	}

	public void setmParentname(String mParentname) {
		this.mParentname = mParentname;
	}

	public String getmCname() {
		return mCname;
	}

	public void setmCname(String mCname) {
		this.mCname = mCname;
	}
	
	public int getmAppid() {
		return mAppid;
	}

	public void setmAppid(int mAppid) {
		this.mAppid = mAppid;
	}

	public String getmOrderlevel() {
		return mOrderlevel;
	}

	public void setmOrderlevel(String mOrderlevel) {
		this.mOrderlevel = mOrderlevel;
	}

	public String getaAppname() {
		return aAppname;
	}

	public void setaAppname(String aAppname) {
		this.aAppname = aAppname;
	}
		
}
