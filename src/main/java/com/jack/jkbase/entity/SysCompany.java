package com.jack.jkbase.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name = "sys_Company",indexes = {@Index(name="sys_Company_idx1",columnList = "C_CName",unique = true)})
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_company")
public class SysCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CompanyID", type = IdType.AUTO)
    private int companyid;

    @TableField("C_AreaId")
    private int cAreaid;

    @TableField("C_ChildCount")
    private int cChildcount;

    @TableField("C_CName")
    private String cCname;

    @TableField("C_Level")
    private int cLevel;

    @TableField("C_ParentID")
    private int cParentid;

    @TableField("C_ShowOrder")
    private int cShoworder;
	public static Map<String,String> getHeadMap(){
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("cCname","部门名称");
    	map.put("cParentname","所属部门");
    	map.put("cLevel","部门级别");
    	map.put("cAreaName","所属行政区");
    	return map;
    }
    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getcCname() {
        return cCname;
    }

    public void setcCname(String cCname) {
        this.cCname = cCname == null ? null : cCname.trim();
    }

    public int getcParentid() {
        return cParentid;
    }

    public void setcParentid(int cParentid) {
        this.cParentid = cParentid;
    }

    public int getcShoworder() {
        return cShoworder;
    }

    public void setcShoworder(int cShoworder) {
        this.cShoworder = cShoworder;
    }

    public int getcLevel() {
        return cLevel;
    }

    public void setcLevel(int cLevel) {
        this.cLevel = cLevel;
    }

    public int getcChildcount() {
        return cChildcount;
    }

    public void setcChildcount(int cChildcount) {
        this.cChildcount = cChildcount;
    }
	public int getcAreaid() {
		return cAreaid;
	}
	public void setcAreaid(int cAreaid) {
		this.cAreaid = cAreaid;
	}
}