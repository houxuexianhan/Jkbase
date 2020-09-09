package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_Function",uniqueConstraints = {@UniqueConstraint(columnNames = {"F_ModuleId","F_Value"},name="sys_Function_ix1")
				,@UniqueConstraint(columnNames = {"F_ModuleId","F_Name"},name="sys_Function_ix2")})
public class SysFunction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FunctionId")
	private int functionid;
	
	@Column(name="F_ModuleId",nullable=false)
	private int fModuleid;
	
	@Column(name="F_Value",nullable=false)
	private int fValue;
	
	@Column(name="F_Name",nullable=false,columnDefinition = "nvarchar(20)")
    private String fName;

	@Column(name="F_Desc",columnDefinition = "nvarchar(50)")
    private String fDesc;

	@Column(name="F_Enable",nullable=false)
    private int fEnable;

	public int getFunctionid() {
		return functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}

	public int getfModuleid() {
		return fModuleid;
	}

	public void setfModuleid(int fModuleid) {
		this.fModuleid = fModuleid;
	}

	public int getfValue() {
		return fValue;
	}

	public void setfValue(int fValue) {
		this.fValue = fValue;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfDesc() {
		return fDesc;
	}

	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}

	public int getfEnable() {
		return fEnable;
	}

	public void setfEnable(int fEnable) {
		this.fEnable = fEnable;
	}
	
	
}