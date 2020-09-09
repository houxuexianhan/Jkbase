package com.jack.jkbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sys_FieldValue",uniqueConstraints = {@UniqueConstraint(columnNames = {"V_FieldID","V_Text"},name="sys_FieldValue_ix1")})
public class SysFieldValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ValueID")
    private int valueid;

	@Column(name="V_Text",nullable=false,columnDefinition = "nvarchar(100)")//字段值
    private String vText;	

	@Column(name="V_ShowOrder",nullable = false)	//同级显示顺序
    private int vShoworder;

	@Column(name="V_FieldID",nullable=false)	//分类id
	private int vFieldid;
	
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