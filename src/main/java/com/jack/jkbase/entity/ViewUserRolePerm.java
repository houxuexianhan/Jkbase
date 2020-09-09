package com.jack.jkbase.entity;

public class ViewUserRolePerm extends SysRolePermission {
	private int R_UserID;
	private int R_RoleID;
	private int P_ModuleId;

	public int getR_UserID() {
		return R_UserID;
	}

	public void setR_UserID(int r_UserID) {
		R_UserID = r_UserID;
	}

	public int getR_RoleID() {
		return R_RoleID;
	}

	public void setR_RoleID(int r_RoleID) {
		R_RoleID = r_RoleID;
	}

	public int getP_ModuleId() {
		return P_ModuleId;
	}

	public void setP_ModuleId(int p_ModuleId) {
		P_ModuleId = p_ModuleId;
	}

}