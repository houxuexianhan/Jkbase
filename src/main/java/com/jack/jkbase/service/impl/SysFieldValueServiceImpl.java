package com.jack.jkbase.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysFieldValue;
import com.jack.jkbase.mapper.SysFieldValueMapper;
import com.jack.jkbase.service.ISysFieldValueService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysFieldValueServiceImpl extends ServiceImpl<SysFieldValueMapper, SysFieldValue> implements ISysFieldValueService {
	public List<SysFieldValue> selectByFieldid(int fieldid){
		return list(Wrappers.lambdaQuery(SysFieldValue.class)
				.eq(SysFieldValue::getvFieldid, fieldid));
	}
	//order by V_FieldID,V_ShowOrder
}
