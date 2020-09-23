package com.jack.jkbase.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.jkbase.entity.SysModule;
import com.jack.jkbase.entity.ViewSysModule;

public interface SysModuleMapper extends BaseMapper<SysModule>{
    
    List<ViewSysModule> selectComboExcludeParent();
    List<ViewSysModule> selectAll();
    List<ViewSysModule> selectByUserId(int userId);
}