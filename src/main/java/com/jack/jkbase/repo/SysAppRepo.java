package com.jack.jkbase.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jack.jkbase.entity.SysApp;
@RepositoryRestResource(path = "apps")
public interface SysAppRepo extends JpaRepository<SysApp, Integer>{
	//localhost:8080/rest/apps/search/nsw?name=系统
	
	@RestResource(path="nsw")
	@Query("select u from SysApp u where u.aAppdesc like %?1%")
	List<SysApp> findByaAppdescLike(String name);
	
	/*<!-- 查询某个角色其他可添加的应用，用于添加角色应用的下拉框选择  -->
	<select id="selectByRole" resultMap="BaseResultMap" parameterType="java.lang.Integer">
		select * from frm_Apps where A_IsSys =0 and AppID not in 
		( select A_AppId from sys_RoleApp where A_RoleID = #{roleId})*/
	@RestResource(path="findByRole")
	@Query(value="select * from sys_App where A_IsSys =0 and AppID not in "+
			"( select A_AppId from sys_RoleApp where A_RoleID = ?1 )",nativeQuery = true)
	List<SysApp> findByRole(int roleid);
	//select * from frm_Apps where A_IsSys =0 
	List<SysApp> findByaIssys(int isSys);
	
}
