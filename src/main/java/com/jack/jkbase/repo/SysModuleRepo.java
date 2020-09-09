package com.jack.jkbase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysModule;
@RepositoryRestResource(path = "modules")
public interface SysModuleRepo extends JpaRepository<SysModule, Integer>{
	
}
