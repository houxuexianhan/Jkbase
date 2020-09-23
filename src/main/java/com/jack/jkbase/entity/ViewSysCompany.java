package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("view_sys_company")
public class ViewSysCompany extends SysCompany {
	@TableField("A_AreaName")
	private String aAreaname;
	
	@TableField("C_ParentName")
	private String cParentname;

	public String getaAreaname() {
		return aAreaname;
	}

	public void setaAreaname(String aAreaname) {
		this.aAreaname = aAreaname;
	}

	public String getcParentname() {
		return cParentname;
	}

	public void setcParentname(String cParentname) {
		this.cParentname = cParentname;
	}
}
