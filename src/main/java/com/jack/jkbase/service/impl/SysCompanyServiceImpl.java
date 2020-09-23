package com.jack.jkbase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.jkbase.entity.SysCompany;
import com.jack.jkbase.entity.ViewSysCompany;
import com.jack.jkbase.mapper.SysCompanyMapper;
import com.jack.jkbase.mapper.ViewSysCompanyMapper;
import com.jack.jkbase.service.ISysCompanyService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LIBO
 * @since 2020-09-23
 */
@Service
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements ISysCompanyService {
	@Autowired ViewSysCompanyMapper viewMapper;
	
	public ViewSysCompanyMapper getViewMapper() {
		return viewMapper;
	}
	
	public ViewSysCompany selectById(int id) {
		return viewMapper.selectById(id);
	}
	//返回List order by C_Level,C_ShowOrder
	public List<ViewSysCompany> selectAll(){
		return viewMapper.selectList(Wrappers.lambdaQuery(ViewSysCompany.class).
				orderByAsc(ViewSysCompany::getcLevel,ViewSysCompany::getcShoworder));
	}
	public JSONArray getTreeSelect(){
		return tree(selectAll(), 0);
	}
	// 菜单树形结构
	private JSONArray tree(List<ViewSysCompany> menuList, int parentId) {
		JSONArray childMenu = new JSONArray();
		for (SysCompany menu : menuList) {
			if (parentId == menu.getcParentid()) {
				JSONObject jo = new JSONObject();
				jo.put("text",menu.getcCname());
				jo.put("tags",new String[]{String.valueOf(menu.getCompanyid())});
				JSONArray c_node = tree(menuList, menu.getCompanyid());
				if(c_node.size()>0)jo.put("nodes", c_node);
				childMenu.add(jo);
			}
		}
		return childMenu;
	}
	//生成 树形的 easyui-treegrid 接受的数据格式  需要指定 _parentId  ,可选字段 iconCls   
	public JSONObject getTreeCompany(){
		JSONObject jo = new JSONObject();
		List<ViewSysCompany> list = selectAll();
		JSONArray ja = new JSONArray();
		for(SysCompany item: list){
			JSONObject joItem = (JSONObject) JSON.toJSON(item);
			if(item.getcParentid()!=0) joItem.put("_parentId",item.getcParentid());
			//第一层(顶层
			if(item.getcLevel()==1){
				//joItem.put("iconCls","fa fa-circle-o");
				joItem.put("iconCls","");
			}else{
				//joItem.put("iconCls","fa fa-circle");
				joItem.put("iconCls","");
			}
			ja.add(joItem);
		}
		jo.put("rows", ja);
		return jo;
	}
}
