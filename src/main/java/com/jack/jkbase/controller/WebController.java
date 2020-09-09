package com.jack.jkbase.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//网页管理
@Controller
@RequestMapping("/web")
public class WebController {
	@RequestMapping(value = "/index.view")
	public String indexView() {
		return "index";
	}
	//管理界面
	@RequestMapping(value = "/manager.view")
	public String managerView() {
		return "manager";
	}
}
