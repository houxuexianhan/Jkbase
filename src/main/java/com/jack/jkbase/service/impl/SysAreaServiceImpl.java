package com.jack.jkbase.service.impl;

import com.jack.jkbase.annotation.Operation;
import com.jack.jkbase.entity.SysArea;
import com.jack.jkbase.mapper.SysAreaMapper;
import com.jack.jkbase.service.ISysAreaService;
import com.jack.jkbase.util.Helper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {
	@Override
	public List<SysArea> list() {
		return list(Wrappers.lambdaQuery(SysArea.class).orderByAsc(SysArea::getaLevel,SysArea::getaShoworder));
	}
	// 生成 树形的 easyui-treegrid 接受的数据格式 需要指定 _parentId ,可选字段 iconCls
	public JSONObject getTreeArea() {
		JSONObject jo = new JSONObject();
		List<SysArea> list = list();
		JSONArray ja = new JSONArray();
		for (SysArea area : list) {
			JSONObject joArea = (JSONObject) JSON.toJSON(area);
			if (area.getaParentid() != 0)
				joArea.put("_parentId", area.getaParentid());
			// 第一层(顶层
			if (area.getaLevel() == 1) {
				joArea.put("iconCls", "fa fa-circle-o");
			} else {
				joArea.put("iconCls", "fa fa-circle");
			}
			ja.add(joArea);
		}
		jo.put("rows", ja);
		return jo;
	}
	// 返回json格式的树形选择菜单
	public JSONArray getTreeSelect(){
		return tree(list(), 0);
	}
	// 菜单树形结构
	private JSONArray tree(List<SysArea> menuList, int parentId) {
		JSONArray childMenu = new JSONArray();
		for (SysArea menu : menuList) {
			if (parentId == menu.getaParentid()) {
				JSONObject jo = new JSONObject();
				jo.put("text",menu.getaAreaname());
				jo.put("tags",new String[]{String.valueOf(menu.getAreaid())});
				JSONArray c_node = tree(menuList, menu.getAreaid());
				if(c_node.size()>0)jo.put("nodes", c_node);
				childMenu.add(jo);
			}
		}
		return childMenu;
	}
	//delete from sys_Area where AreaId = #{param1} or A_ParentId = #{param1}
	/**
	 * 删除行政区连同子级
	 */
	@Operation(type=Helper.logTypeOperation,desc="删除行政区（连同其子级行政区）",arguDesc={"行政区ID"})
	public boolean deleteAllByParent(int parentId){
		return remove(Wrappers.lambdaQuery(SysArea.class).eq(SysArea::getAreaid, parentId).
				or().eq(SysArea::getaParentid, parentId));
	}
	
	
}
