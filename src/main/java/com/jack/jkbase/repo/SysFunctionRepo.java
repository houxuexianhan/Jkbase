package com.jack.jkbase.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.ViewSysModule;
@RepositoryRestResource(path = "funcs")
public interface SysFunctionRepo extends JpaRepository<SysFunction, Integer>{
	//localhost:8080/rest/funcs/search/findChildren
	
}
