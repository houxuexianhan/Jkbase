package com.jack.jkbase.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_Company",indexes = {@Index(name="sys_Company_idx1",columnList = "C_CName",unique = true)})
public class SysCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompanyID")
    private int companyid;
	
	@Column(name="C_CName",nullable = false,columnDefinition ="nvarchar(50)" )//单位部门名称
    private String cCname;

	@Column(name = "C_ParentID",nullable = false,columnDefinition = "int default 0")//上级单位部门ID,0:为最高级
    private int cParentid;

	@Column(name="C_ShowOrder",nullable=false,columnDefinition = "int default 0")//显示顺序
    private int cShoworder;

	@Column(name="C_Level",nullable=false,columnDefinition = "int default 1")//所在层数
    private int cLevel;

	@Column(name="C_ChildCount",nullable=false,columnDefinition = "int default 0")//子部门数
    private int cChildcount;
	
	@Column(name="C_AreaId",nullable = false)//所属行政区ID(一个单位必属于某个行政区)
	private int cAreaid;

	
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