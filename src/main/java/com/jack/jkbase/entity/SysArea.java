package com.jack.jkbase.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/*@Entity
@Table(name="sys_Area",uniqueConstraints = {@UniqueConstraint(columnNames = "A_AreaNo",name = "sys_Area_ix1")
						,@UniqueConstraint(columnNames = "A_AreaCode",name = "sys_Area_ix2")})*/
@TableName("sys_area")
public class SysArea implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "AreaId", type = IdType.AUTO)
    private int areaid;

    @TableField("A_AreaCode")
    private String aAreacode;

    @TableField("A_AreaName")
    private String aAreaname;

    @TableField("A_AreaNo")
    private String aAreano;

    @TableField("A_Level")
    private int aLevel;

    @TableField("A_LevelName")
    private String aLevelname;

    @TableField("A_ParentId")
    private int aParentid;

    @TableField("A_ShowOrder")
    private int aShoworder;

    @TableField("A_Zoning")
    private String aZoning;

	
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