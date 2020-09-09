package com.jack.jkbase.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jack.jkbase.entity.SysFieldValue;
@RepositoryRestResource(path = "fieldValues")
public interface SysFieldValueRepo extends JpaRepository<SysFieldValue, Integer>{
	//localhost:8080/rest/funcs/search/findChildren
	List<SysFieldValue> findByvFieldid(int fid);
}
