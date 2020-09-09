package com.jack.jkbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysCompany;
//@RepositoryRestResource(path = "companys")
public interface SysCompanyRepo extends JpaRepository<SysCompany, Integer>{
	//localhost:8080/rest/apps/search/nsw?name=系统
	
}
