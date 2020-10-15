package com.jack.jkbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.jkbase.service.impl.SysCompanyServiceImpl;
/**
 * 开放接口
 * @author LIBO
 *
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired SysCompanyServiceImpl sysCompanyService;
	@RequestMapping("/companyTree")
	public String companyTree() {
		return sysCompanyService.getApiTree().toJSONString();
	}
}
