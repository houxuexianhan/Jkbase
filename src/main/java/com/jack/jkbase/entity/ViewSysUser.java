package com.jack.jkbase.entity;

public class ViewSysUser extends SysUser {
	private String U_TypeText;
	private String U_StatusText;
	private String U_CompanyName;
	private SysCompany sysCompany;
	private String comboText;

	public String getComboText() {
		comboText = getuLoginname() + "(" + getuCname() + ")";
		return comboText;
	}

	public String getU_TypeText() {
		return U_TypeText;
	}

	public void setU_TypeText(String u_TypeText) {
		U_TypeText = u_TypeText;
	}

	public String getU_StatusText() {
		return U_StatusText;
	}

	public void setU_StatusText(String u_StatusText) {
		U_StatusText = u_StatusText;
	}

	public String getU_CompanyName() {
		return U_CompanyName;
	}

	public void setU_CompanyName(String u_CompanyName) {
		U_CompanyName = u_CompanyName;
	}

	public SysCompany getSysCompany() {
		return sysCompany;
	}

	public void setSysCompany(SysCompany sysCompany) {
		this.sysCompany = sysCompany;
	}
}
