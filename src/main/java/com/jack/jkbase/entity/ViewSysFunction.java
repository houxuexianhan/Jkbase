package com.jack.jkbase.entity;

public class ViewSysFunction extends SysFunction{

	private ViewSysModule module;
	 //某个角色下对本功能是否有权限，默认无权限
    private boolean access = false;
    
    public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public ViewSysModule getModule() {
		return module;
	}

	public void setModule(ViewSysModule module) {
		this.module = module;
	}
	
	
}
