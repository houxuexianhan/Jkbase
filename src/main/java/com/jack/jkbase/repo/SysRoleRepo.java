package com.jack.jkbase.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jack.jkbase.entity.SysApp;
import com.jack.jkbase.entity.SysRole;
//@RepositoryRestResource(path = "roles")
public interface SysRoleRepo //extends JpaRepository<SysRole, Integer>
{
	//localhost:8080/rest/apps/search/nsw?name=系统
	
}
