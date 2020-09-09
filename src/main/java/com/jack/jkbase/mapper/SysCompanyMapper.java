package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysCompany;
import com.jack.jkbase.entity.ViewSysCompany;

public interface SysCompanyMapper {
	List<ViewSysCompany> selectAll();

	int deleteAllByParent(int parentId);
	//
    int deleteByPrimaryKey(Integer companyid);

    int insert(SysCompany record);

    int insertSelective(SysCompany record);

    SysCompany selectByPrimaryKey(Integer companyid);

    int updateByPrimaryKeySelective(SysCompany record);

    int updateByPrimaryKey(SysCompany record);
}