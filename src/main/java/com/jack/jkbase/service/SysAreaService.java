package com.jack.jkbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.annotation.Operation;
import com.jack.jkbase.entity.SysArea;
import com.jack.jkbase.mapper.SysAreaMapper;
import com.jack.jkbase.mapper.SysFieldValueMapper;
import com.jack.jkbase.util.Helper;

@Service
public class SysAreaService {
	@Autowired
	SysAreaMapper mapper;
	@Autowired
	SysFieldValueMapper valueMapper;
	public List<SysArea> selectAll(){
		return mapper.selectAll();
	}
	//生成 树形的 easyui-treegrid 接受的数据格式  需要指定 _parentId  ,可选字段 iconCls   
	public JSONObject getTreeArea(){
		JSONObject jo = new JSONObject();
		List<SysArea> list = mapper.selectAll();
		JSONArray ja = new JSONArray();
		for(SysArea area: list){
			JSONObject joArea = (JSONObject) JSON.toJSON(area);
			if(area.getaParentid()!=0) joArea.put("_parentId",area.getaParentid());
			//第一层(顶层
			if(area.getaLevel()==1){
				joArea.put("iconCls","fa fa-circle-o");
			}else{
				joArea.put("iconCls","fa fa-circle");
			}
			ja.add(joArea);
		}
		jo.put("rows", ja);
		return jo;
	}

	/*
	 * @Operation(type=Helper.logTypeOperation,desc="更新行政区表",arguDesc={"行政区","操作类型"}
	 * ) public int access(SysArea model,String action) throws Exception{
	 * if(DBAction.Delete.name.equals(action)) return
	 * deleteAllByParent(model.getAreaid()); int rs = mapper.access(model,action);
	 * if(rs == -2) throw new Exception("操作失败，标准代码或自定义编码或行政区名称不能重复！"); return rs; }
	 */
	//连同子节点一起删除
	@Operation(type=Helper.logTypeOperation,desc="删除行政区（连同其子级行政区）",arguDesc={"行政区ID"})
	public int deleteAllByParent(int parentId){
		return mapper.deleteAllByParent(parentId);
	}
	// 返回json格式的树形选择菜单
	public JSONArray getTreeSelect(){
		return tree(selectAll(), 0);
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
}

