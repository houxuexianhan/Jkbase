package com.jack.jkbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysRoleApp;
@RepositoryRestResource(path = "roleApps")
public interface SysRoleAppRepo extends JpaRepository<SysRoleApp, SysRoleApp>{
	
}
