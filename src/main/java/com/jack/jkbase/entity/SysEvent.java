package com.jack.jkbase.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
//@Entity
//@Table(name = "sys_Event")
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_event")
public class SysEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EventID", type = IdType.AUTO)
    private long eventid;

    @TableField("E_AppID")
    private int eAppid;

    @TableField("E_AppName")
    private String eAppname;

    @TableField("E_DateTime")
    private Date eDatetime;

    @TableField("E_From")
    private String eFrom;

    @TableField("E_IP")
    private String eIp;

    @TableField("E_ModCode")
    private String eModcode;

    @TableField("E_ModName")
    private String eModname;

    @TableField("E_Record")
    private String eRecord;

    @TableField("E_Type")
    private int eType;

    @TableField("E_UserID")
    private int eUserid;

    @TableField("E_UserName")
    private String eUsername;

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public String geteUsername() {
        return eUsername;
    }

    public void seteUsername(String eUsername) {
        this.eUsername = eUsername == null ? null : eUsername.trim();
    }

    public int geteUserid() {
        return eUserid;
    }

    public void seteUserid(int eUserid) {
        this.eUserid = eUserid;
    }

    public Date geteDatetime() {
        return eDatetime;
    }

    public void seteDatetime(Date eDatetime) {
        this.eDatetime = eDatetime;
    }

    public int geteAppid() {
        return eAppid;
    }

    public void seteAppid(int eAppid) {
        this.eAppid = eAppid;
    }

    public String geteAppname() {
        return eAppname;
    }

    public void seteAppname(String eAppname) {
        this.eAppname = eAppname == null ? null : eAppname.trim();
    }

    public String geteModname() {
        return eModname;
    }

    public void seteModname(String eModname) {
        this.eModname = eModname == null ? null : eModname.trim();
    }

    public String geteModcode() {
        return eModcode;
    }

    public void seteModcode(String eModcode) {
        this.eModcode = eModcode == null ? null : eModcode.trim();
    }

    public String geteFrom() {
        return eFrom;
    }

    public void seteFrom(String eFrom) {
        this.eFrom = eFrom == null ? null : eFrom.trim();
    }

    public int geteType() {
        return eType;
    }

    public void seteType(int eType) {
        this.eType = eType;
    }

    public String geteIp() {
        return eIp;
    }

    public void seteIp(String eIp) {
        this.eIp = eIp == null ? null : eIp.trim();
    }

    public String geteRecord() {
        return eRecord;
    }

    public void seteRecord(String eRecord) {
        this.eRecord = eRecord == null ? null : eRecord.trim();
    }
}