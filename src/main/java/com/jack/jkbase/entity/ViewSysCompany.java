package com.jack.jkbase.entity;

public class ViewSysCompany extends SysCompany {
	private SysArea area;
	private String cAreaname;

	public SysArea getArea() {
		return area;
	}

	public void setArea(SysArea area) {
		this.area = area;
	}

	public String getcAreaname() {
		return cAreaname;
	}

	public void setcAreaname(String cAreaname) {
		this.cAreaname = cAreaname;
	}
	
}
