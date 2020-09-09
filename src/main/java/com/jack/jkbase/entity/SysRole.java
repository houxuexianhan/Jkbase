package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_Role",uniqueConstraints = {@UniqueConstraint(columnNames = "R_RoleName",name = "sys_Role_ix")})
public class SysRole {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RoleID")
    private int roleid;

	@Column(name="R_RoleName",columnDefinition = "nvarchar(50)",nullable=false)
    private String rRolename;

	@Column(name="R_Description",columnDefinition = "nvarchar(100)")
    private String rDescription;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getrRolename() {
        return rRolename;
    }

    public void setrRolename(String rRolename) {
        this.rRolename = rRolename == null ? null : rRolename.trim();
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }
}