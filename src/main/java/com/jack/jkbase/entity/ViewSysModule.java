package com.jack.jkbase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("view_sys_module")
public class ViewSysModule extends SysModule{
	@TableField("A_AppName")
	private String aAppname="";
	
	@TableField("M_ParentName")
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
