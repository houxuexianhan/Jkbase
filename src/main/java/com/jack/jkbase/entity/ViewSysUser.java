package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
@TableName("view_sys_user")
public class ViewSysUser extends SysUser {
    @TableField("U_TypeText")
    private String uTypetext;

    @TableField("U_StatusText")
    private String uStatustext;

    @TableField("U_CompanyName")
    private String uCompanyname;
    
	@TableField(exist = false) 
	private String comboText;

	public String getComboText() {
		comboText = getuLoginname() + "(" + getuCname() + ")";
		return comboText;
	}

	public String getuTypetext() {
		return uTypetext;
	}

	public void setuTypetext(String uTypetext) {
		this.uTypetext = uTypetext;
	}

	public String getuStatustext() {
		return uStatustext;
	}

	public void setuStatustext(String uStatustext) {
		this.uStatustext = uStatustext;
	}

	public String getuCompanyname() {
		return uCompanyname;
	}

	public void setuCompanyname(String uCompanyname) {
		this.uCompanyname = uCompanyname;
	}

	public void setComboText(String comboText) {
		this.comboText = comboText;
	}
	
}
