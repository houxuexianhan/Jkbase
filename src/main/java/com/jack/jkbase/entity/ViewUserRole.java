package com.jack.jkbase.entity;

public class ViewUserRole extends SysUserRole{
    private SysUser user;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}
    
}