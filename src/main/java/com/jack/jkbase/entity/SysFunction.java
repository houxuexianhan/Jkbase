package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_Function",uniqueConstraints = {@UniqueConstraint(columnNames = {"F_ModuleId","F_Value"},name="sys_Function_ix1")
	//s			,@UniqueConstraint(columnNames = {"F_ModuleId","F_Name"},name="sys_Function_ix2")})
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_function")
public class SysFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FunctionId", type = IdType.AUTO)
    private int functionid;

    @TableField("F_Desc")
    private String fDesc;

    @TableField("F_Enable")
    private int fEnable;

    @TableField("F_ModuleId")
    private int fModuleid;

    @TableField("F_Name")
    private String fName;

    @TableField("F_Value")
    private int fValue;

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