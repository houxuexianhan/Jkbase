package com.jack.jkbase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="sys_User",uniqueConstraints = @UniqueConstraint(columnNames = "U_LoginName",name = "sys_User_ix1"))
public class SysUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int userid;

	@Column(name="U_LoginName",columnDefinition = "nvarchar(20)",nullable=false)
    private String uLoginname;

	@Column(name="U_CName",columnDefinition = "nvarchar(20)",nullable=false)
    private String uCname;

	@Column(name="U_Pwd",length = 32,nullable=false)
    private String uPwd;

	@Column(name="U_CompanyID",nullable=false)
    private int uCompanyid;

	@Column(name="U_MobileNo",length = 15)		//md5
    private String uMobileno;

	@Column(name="U_PhotoUrl",columnDefinition = "nvarchar(150)")	//头像
    private String uPhotourl;

	@Column(name="U_JoinTime",columnDefinition = "datetime default CURRENT_TIMESTAMP",nullable=false)//加入时间
    private Date uJointime;

	@Column(name="U_Type",nullable=false)
    private int uType;	//用户类型	0:超级用户	1:管理用户2:企业用户(注：超级用户只有一个)

	@Column(name="U_Status",nullable=false)
    private int uStatus;	//当前状态0:正常 1:禁止

	@Column(name="U_LastTime",columnDefinition = "datetime")
    private Date uLasttime;

	@Column(name="U_LastIp",length = 50)
    private String uLastip;

	@Column(name="U_ExtendField")
    private String uExtendfield;

	@Column(name="U_Expired",nullable=false,columnDefinition="int default 0")
    private int uExpired;
	
	@Column(name="U_Disabled",nullable=false,columnDefinition="int default 0")
    private int uDisabled;
	
	
	
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getuLoginname() {
        return uLoginname;
    }

    public void setuLoginname(String uLoginname) {
        this.uLoginname = uLoginname == null ? null : uLoginname.trim();
    }

    public String getuCname() {
        return uCname;
    }

    public void setuCname(String uCname) {
        this.uCname = uCname == null ? null : uCname.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public int getuCompanyid() {
        return uCompanyid;
    }

    public void setuCompanyid(int uCompanyid) {
        this.uCompanyid = uCompanyid;
    }

    public String getuMobileno() {
        return uMobileno;
    }

    public void setuMobileno(String uMobileno) {
        this.uMobileno = uMobileno == null ? null : uMobileno.trim();
    }

    public String getuPhotourl() {
        return uPhotourl;
    }

    public void setuPhotourl(String uPhotourl) {
        this.uPhotourl = uPhotourl == null ? null : uPhotourl.trim();
    }

    public Date getuJointime() {
        return uJointime;
    }

    public void setuJointime(Date uJointime) {
        this.uJointime = uJointime;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public int getuStatus() {
        return uStatus;
    }

    public void setuStatus(int uStatus) {
        this.uStatus = uStatus;
    }

    public Date getuLasttime() {
        return uLasttime;
    }

    public void setuLasttime(Date uLasttime) {
        this.uLasttime = uLasttime;
    }

    public String getuLastip() {
        return uLastip;
    }

    public void setuLastip(String uLastip) {
        this.uLastip = uLastip == null ? null : uLastip.trim();
    }

    public String getuExtendfield() {
        return uExtendfield;
    }

    public void setuExtendfield(String uExtendfield) {
        this.uExtendfield = uExtendfield == null ? null : uExtendfield.trim();
    }
}