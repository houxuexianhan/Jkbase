package com.jack.jkbase.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_Area",uniqueConstraints = {@UniqueConstraint(columnNames = "A_AreaNo",name = "sys_Area_ix1")
						,@UniqueConstraint(columnNames = "A_AreaCode",name = "sys_Area_ix2")})
public class SysArea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AreaId")
    private int areaid;

	@Column(name="A_AreaNo",nullable = false,columnDefinition = "varchar(10)")//行政区域代码(国家标准)
    private String aAreano;

	@Column(name="A_AreaCode",nullable = false,columnDefinition = "varchar(10)")//行政区自编码(字母缩写)
    private String aAreacode;

	@Column(name="A_AreaName",nullable=false,columnDefinition = "nvarchar(30)")//行政区名称(地名)
    private String aAreaname;

	@Column(name="A_ParentId",nullable=false)
    private int aParentid;

	@Column(name="A_Level",nullable=false)	//层级
    private int aLevel;

	@Column(name="A_LevelName",nullable=false,columnDefinition = "nvarchar(10)")//行政级别(省(直辖市)/市/县/市辖区/乡镇)
    private String aLevelname;

	@Column(name="A_Zoning",nullable=false,columnDefinition = "nvarchar(50)")//行政区划(中国行政区划：如华北、东北、华东、华中、华南、西北、西南、港澳台等)
    private String aZoning;

	@Column(name="A_ShowOrder",nullable = false)//显示顺序
    private int aShoworder;

	
	public static Map<String,String> getHeadMap(){
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("aAreano","国家标准代码");
    	map.put("aAreacode","自定义编码");
    	map.put("aAreaname","行政区名称");
    	map.put("aParentname","所属行政区");
    	map.put("aLevel","等级");
    	map.put("aLevelname","行政区级别");
    	map.put("aZoning","行政区划");
    	return map;
    }
	
    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getaAreano() {
        return aAreano;
    }

    public void setaAreano(String aAreano) {
        this.aAreano = aAreano == null ? null : aAreano.trim();
    }

    public String getaAreacode() {
        return aAreacode;
    }

    public void setaAreacode(String aAreacode) {
        this.aAreacode = aAreacode == null ? null : aAreacode.trim();
    }

    public String getaAreaname() {
        return aAreaname;
    }

    public void setaAreaname(String aAreaname) {
        this.aAreaname = aAreaname == null ? null : aAreaname.trim();
    }

    public int getaParentid() {
        return aParentid;
    }

    public void setaParentid(int aParentid) {
        this.aParentid = aParentid;
    }

    public int getaLevel() {
        return aLevel;
    }

    public void setaLevel(int aLevel) {
        this.aLevel = aLevel;
    }

    public String getaLevelname() {
        return aLevelname;
    }

    public void setaLevelname(String aLevelname) {
        this.aLevelname = aLevelname == null ? null : aLevelname.trim();
    }

    public String getaZoning() {
        return aZoning;
    }

    public void setaZoning(String aZoning) {
        this.aZoning = aZoning == null ? null : aZoning.trim();
    }

    public int getaShoworder() {
        return aShoworder;
    }

    public void setaShoworder(int aShoworder) {
        this.aShoworder = aShoworder;
    }
    
}