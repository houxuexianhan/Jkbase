package com.jack.jkbase.mapper;

import java.util.List;

import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.ViewSysModule;

public interface SysModuleMapper {
    
    List<ViewSysModule> selectComboExcludeParent();
    List<ViewSysModule> selectAll();
    List<ViewSysModule> selectByUserId(int userId);
    //
    int deleteByPrimaryKey(Integer moduleid);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    ViewSysModule selectByPrimaryKey(Integer moduleid);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);
}