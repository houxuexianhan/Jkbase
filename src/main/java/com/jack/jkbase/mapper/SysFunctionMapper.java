package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysFunction;
import com.jack.jkbase.entity.ViewSysFunction;

public interface SysFunctionMapper {
    List<ViewSysFunction> selectByApp(int appId);
    List<ViewSysFunction> selectByModule(int moduleId);
    List<ViewSysFunction> selectByModuleCode(String code);
    List<ViewSysFunction> selectAll();
    int selectMaxValue(int moduleid);//返回某个模块的下一个功能值
    //
    int deleteByPrimaryKey(Integer functionid);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    ViewSysFunction selectByPrimaryKey(int functionid);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}