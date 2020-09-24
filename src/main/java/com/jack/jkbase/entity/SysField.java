package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_Field",uniqueConstraints = {@UniqueConstraint(columnNames = "F_CName",name = "sys_Field_ix1")})
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_field")
public class SysField implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FieldID", type = IdType.AUTO)
    private int fieldid;

    @TableField("F_CName")
    private String fCname;

    @TableField("F_Remark")
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