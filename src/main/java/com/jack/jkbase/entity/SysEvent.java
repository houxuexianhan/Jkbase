package com.jack.jkbase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "sys_Event")
public class SysEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EventID")
    private long eventid;

	@Column(name="E_UserName",columnDefinition = "nvarchar(20) ")//操作员名称
    private String eUsername;

	@Column(name="E_UserID")
    private int eUserid;

	@Column(name="E_DateTime",nullable = false,insertable = false,updatable = false,
			columnDefinition ="datetime default CURRENT_TIMESTAMP" )//日志时间
    private Date eDatetime;

	@Column(name="E_AppID")
    private int eAppid;

	@Column(name="E_AppName",columnDefinition = "nvarchar(50)")//应用系统名
    private String eAppname;

	@Column(name="E_ModName",columnDefinition = "nvarchar(50)")//模块名称
    private String eModname;

	@Column(name="E_ModCode",length = 6)
    private String eModcode;

	@Column(name="E_From",columnDefinition = "nvarchar(100)")//来源页面
    private String eFrom;

	@Column(name="E_Type",nullable=false)
    private int eType;//日志类型(1-安全日志，2-操作日志)

	@Column(name="E_IP",length = 50)	//来源IP
    private String eIp;

	@Column(name="E_Record",columnDefinition = "nvarchar(500)")	//日志内容
    private String eRecord;

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