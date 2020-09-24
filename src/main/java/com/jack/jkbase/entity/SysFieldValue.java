package com.jack.jkbase.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Entity
//@Table(name="sys_FieldValue",uniqueConstraints = {@UniqueConstraint(columnNames = {"V_FieldID","V_Text"},name="sys_FieldValue_ix1")})
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_fieldvalue")
public class SysFieldValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ValueID", type = IdType.AUTO)
    private int valueid;

    @TableField("V_FieldID")
    private int vFieldid;

    @TableField("V_ShowOrder")
    private int vShoworder;

    @TableField("V_Text")
    private String vText;
	
    public int getValueid() {
        return valueid;
    }

    public void setValueid(int valueid) {
        this.valueid = valueid;
    }


    public String getvText() {
        return vText;
    }

    public void setvText(String vText) {
        this.vText = vText == null ? null : vText.trim();
    }
    
	public int getvFieldid() {
		return vFieldid;
	}

	public void setvFieldid(int vFieldid) {
		this.vFieldid = vFieldid;
	}

	public int getvShoworder() {
        return vShoworder;
    }

    public void setvShoworder(int vShoworder) {
        this.vShoworder = vShoworder;
    }
}