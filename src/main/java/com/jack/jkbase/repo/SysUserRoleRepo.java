package com.jack.jkbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysUserRole;
//@RepositoryRestResource(path = "userRoles")
public interface SysUserRoleRepo extends JpaRepository<SysUserRole, SysUserRole>{
	//localhost:8080/rest/apps/search/nsw?name=系统
	
}
