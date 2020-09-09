package com.jack.jkbase.entity;

public class ViewRoleApp extends SysRoleApp{
    private String roleName;

    private SysApp app;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public SysApp getApp() {
		return app;
	}

	public void setApp(SysApp app) {
		this.app = app;
	}
    

}