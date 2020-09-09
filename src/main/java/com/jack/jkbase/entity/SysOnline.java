package com.jack.jkbase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sys_Online")
public class SysOnline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OnlineID")
    private int onlineid;
    
    @Column(name="O_SessionID",length = 24,nullable=false)
    private String oSessionid;
    
    @Column(name="O_UserName",columnDefinition = "nvarchar(20)",nullable=false)
    private String oUsername;

    @Column(name="O_Ip",columnDefinition = "varchar(20)",nullable=false)
    private String oIp;

    @Column(name="O_LoginTime",nullable=false,columnDefinition = "datetime")
    private Date oLogintime;

    @Column(name="O_LastTime",nullable=false,columnDefinition = "datetime")
    private Date oLasttime;

    @Column(name="O_LastUrl",nullable=false,columnDefinition = "nvarchar(200)")
    private String oLasturl;

    public String getoSessionid() {
        return oSessionid;
    }

    public void setoSessionid(String oSessionid) {
        this.oSessionid = oSessionid == null ? null : oSessionid.trim();
    }

    public int getOnlineid() {
        return onlineid;
    }

    public void setOnlineid(int onlineid) {
        this.onlineid = onlineid;
    }

    public String getoUsername() {
        return oUsername;
    }

    public void setoUsername(String oUsername) {
        this.oUsername = oUsername == null ? null : oUsername.trim();
    }

    public String getoIp() {
        return oIp;
    }

    public void setoIp(String oIp) {
        this.oIp = oIp == null ? null : oIp.trim();
    }

    public Date getoLogintime() {
        return oLogintime;
    }

    public void setoLogintime(Date oLogintime) {
        this.oLogintime = oLogintime;
    }

    public Date getoLasttime() {
        return oLasttime;
    }

    public void setoLasttime(Date oLasttime) {
        this.oLasttime = oLasttime;
    }

    public String getoLasturl() {
        return oLasturl;
    }

    public void setoLasturl(String oLasturl) {
        this.oLasturl = oLasturl == null ? null : oLasturl.trim();
    }
}