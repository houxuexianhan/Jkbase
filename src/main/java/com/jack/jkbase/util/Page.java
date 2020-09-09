package com.jack.jkbase.util;

import java.util.List;

//分页bean，用于封装返回的结果集
public class Page<T> {
	//接口datatables分页显示的返回字段，详情请查看  https://datatables.net/manual/server-side
	public static String draw = "draw";
	public static String recordsTotal = "recordsTotal";
	public static String recordsFiltered = "recordsFiltered";
	public static String error = "error";//如果有错误信息，请返回
	
	private int pageSize;//分页数
	private int pageIndex;//当前查询的页码
	private int total;//总记录数
	private List<T> data;//一页的数据
	@SuppressWarnings("unused")
	private int pages;//总页数
	
	public Page(){}
	public Page(int pageSize,int pageIndex,int total,List<T> data){
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
		this.total = total;
		this.data = data;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	//计算总页数
	public int calcPages(){
		return total==0? 0 : (total-1)/pageSize+1;
	}
	public int getPages() {
		return total==0? 0 : (total-1)/pageSize+1;
	}
	
	
	
}
