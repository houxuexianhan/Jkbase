package com.jack.jkbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.annotation.Operation;
import com.jack.jkbase.entity.SysCompany;
import com.jack.jkbase.entity.ViewSysCompany;
import com.jack.jkbase.mapper.SysCompanyMapper;
import com.jack.jkbase.util.Helper;

@Service
public class SysCompanyService {
	@Autowired
	SysCompanyMapper mapper;
	
	//返回List
	public List<ViewSysCompany> getCompanys(){
		return mapper.selectAll();
	}
	public JSONArray getTreeSelect(){
		return tree(getCompanys(), 0);
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
		List<ViewSysCompany> list = mapper.selectAll();
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

	/*
	 * @Operation(type=Helper.logTypeOperation,desc="更新单位部门表",arguDesc={"单位部门",
	 * "操作类型"}) public int access(SysCompany model,String action) throws Exception{
	 * if(DBAction.Delete.name.equals(action)) return
	 * deleteAllByParent(model.getCompanyid()); int rs =
	 * mapper.access(model,action); if(rs == -2) throw new
	 * Exception("操作失败，单位部门名称不能重复！"); return rs; }
	 */
	//连同子节点一起删除
	@Operation(type=Helper.logTypeOperation,desc="删除单位部门表（连同其子部门）",arguDesc={"单位部门ID"})
	public int deleteAllByParent(int parentId){
		return mapper.deleteAllByParent(parentId);
	}
}
