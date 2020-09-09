package com.jack.jkbase.entity;

public class ViewSysModule extends SysModule{
	private String aAppname="";
	private String mParentname="";
	
	public String getmParentname() {
		return getmParentid()==0?"顶级模块": this.mParentname;
	}

	public void setmParentname(String mParentname) {
		this.mParentname = mParentname;
	}

	public String getaAppname() {
		return aAppname;
	}

	public void setaAppname(String aAppname) {
		this.aAppname = aAppname;
	}
}
