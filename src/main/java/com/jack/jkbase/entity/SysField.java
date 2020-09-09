package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_Field",uniqueConstraints = {@UniqueConstraint(columnNames = "F_CName",name = "sys_Field_ix1")})
public class SysField {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FieldID")
    private int fieldid;

	@Column(name="F_CName",nullable=false,columnDefinition = "nvarchar(50)")//应用字段名
    private String fCname;

	@Column(name="F_Remark",columnDefinition = "nvarchar(200)")//应用字段描述
    private String fRemark;

    public int getFieldid() {
        return fieldid;
    }

    public void setFieldid(int fieldid) {
        this.fieldid = fieldid;
    }

    public String getfCname() {
        return fCname;
    }

    public void setfCname(String fCname) {
        this.fCname = fCname == null ? null : fCname.trim();
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
    }
}