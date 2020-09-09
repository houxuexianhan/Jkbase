package com.jack.jkbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysField;
import com.jack.jkbase.entity.SysUser;
//@RepositoryRestResource(path = "users")
public interface SysUserRepo extends JpaRepository<SysUser, Integer>{
	//localhost:8080/rest/apps/search/nsw?name=系统
	
}
