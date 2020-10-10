package com.jack.jkbase.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jack.jkbase.config.ShiroConfig;
import com.jack.jkbase.entity.SysUser;
import com.jack.jkbase.entity.ViewSysUser;
import com.jack.jkbase.service.impl.SysModuleServiceImpl;
import com.jack.jkbase.service.impl.SysUserServiceImpl;
import com.jack.jkbase.util.ConfigInfo;
import com.jack.jkbase.util.RandomUtil;
import com.jack.jkbase.util.Result;

@Controller
public class HomeController {
	//@Autowired HttpSession session;
	@Autowired SysUserServiceImpl sysUserServiceImpl;
	@Autowired SysModuleServiceImpl moduleService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping({"/"})
    public String home(Model model){
		ViewSysUser loginUser = SecurityUtils.getSubject().getPrincipals().oneByType(ViewSysUser.class);
		JSONArray ja = moduleService.getTreeMenuByUser(loginUser.getUserid());
		//JSONArray ja = moduleService.getTreeMenuByUser(1);
		model.addAttribute("treeMenu", ja);
		return "index";
    }
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String loginPage() {
		Subject s = SecurityUtils.getSubject();
		if(s.isAuthenticated()||s.isRemembered()) return "redirect:/";
		return "login";
	}
	@RequestMapping(value = "/mylogin.do")
	public String mylogin(HttpServletRequest request,String username,String password,Model model) {
		logger.info(username+","+password);
		model.addAttribute("CODE", username);
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()||subject.isRemembered()) return "redirect:/";
		String errinfo = "";
		try {
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/";
		} catch (UnknownAccountException uae) {
			errinfo= "账号不存在";
		} catch (IncorrectCredentialsException ice) {
			errinfo= "密码不正确";
		} catch (LockedAccountException lae) {
			errinfo= "账号被锁定";
		} catch (ExcessiveAttemptsException eae) {
			errinfo= "尝试密码错误次数过多";
        } catch (AuthenticationException e) {
        	errinfo= "认证失败！";
        }
		model.addAttribute("errorInfo",errinfo);
		return "login";
	}
	@RequestMapping(value = "/moduleClosed.page", method = RequestMethod.GET)
	public String page_moduleClosed() {
		return "moduleClosed";
	}

	@RequestMapping(value = "/docs.do", method = RequestMethod.GET)
	public String page_test3() {
		return "docs";
	}

	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String page_test4() {
		return "invoice-print";
	}

	@RequestMapping(value = "/profile.do", method = RequestMethod.GET)
	public String page_profile(Model model) {
		model.addAttribute("user",SecurityUtils.getSubject().getPrincipals().oneByType(ViewSysUser.class));
		return "profile";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String page_register() {
		return "register";
	}
	@RequestMapping(value = "/dashboard.do")
	public String page_sysDashboard(Model model) {
		return "dashboard";
	}
	/*
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String oper_login(HttpServletRequest request,String username,String password, Model model) {
		model.addAttribute("CODE", username);
		try {
			// 登录校验
			SysUser user = sysUserService.selectByUsername(username);
			if(user==null) {
				model.addAttribute("errorInfo","该用户名不存在！");
				return "login";
			}
			else if(!DigestUtils.md5Hex(password).toUpperCase().equalsIgnoreCase(user.getuPwd())){
				model.addAttribute("errorInfo","密码不正确！");
				return "login";
			}
			//用户存在
			if (user.getUserid() != Helper.adminId && user.getuStatus()!=Helper.user_status_normal) {
				model.addAttribute("errorInfo","该账号已被禁用！");
				return "login";
			}
			// 登录成功，移除验证码
			session.setAttribute(Helper.SESSION_USER, user);
			sysEventService.insertEventLog(Helper.logTypeSecurity, user.getuCname()+"("+username+")登录系统");
			return "redirect:/index.do";
			
		} catch (Exception e) {
			model.addAttribute("errorInfo", e.getMessage() );
			e.printStackTrace();
			return "error";
		}
	}
	*/
	@RequestMapping(value = "/profile_changePwd.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String profile_changePwd(String pwdOld, String pwdNew, String pwdRenew) {
		if (pwdOld == null || pwdOld.trim().isEmpty() || pwdNew == null || pwdNew.trim().isEmpty() || pwdRenew == null
				|| pwdRenew.trim().isEmpty()) {
			return JSON.toJSONString(new Result(false, "密码都不能为空！", ""));
		}
		if (!pwdNew.equals(pwdRenew))
			return JSON.toJSONString(new Result(false, "两次输入密码不一致！", ""));
		//SysUser loginUser = (SysUser)session.getAttribute(Helper.SESSION_USER);
		SysUser loginUser =SecurityUtils.getSubject().getPrincipals().oneByType(SysUser.class); 
		if (!ShiroConfig.hashUserPwd(pwdOld, loginUser.getuSalt())
				.equalsIgnoreCase(loginUser.getuPwd()))
			return JSON.toJSONString(new Result(false, "您输入的原始密码不正确，请重新输入！", ""));
		// 修改密码
		String key = RandomUtil.generateString(16);// 重新生成令牌
		try {
			if (sysUserServiceImpl.updatePassword(loginUser.getUserid(), pwdNew,loginUser.getuSalt())) {
				//session.setAttribute(Helper.SESSION_PROFILE_TOKEN, key);
				return JSON.toJSONString(new Result(true, "密码修改成功", key));
			} else
				return JSON.toJSONString(new Result(false, "密码修改失败！" , key));
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false, "操作失败出现异常，请联系管理员！", key));
		}
	}
	@RequestMapping(value = "/profile_updateInfo.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String profile_updateInfo(SysUser user) {
		ViewSysUser loginUser = (ViewSysUser)SecurityUtils.getSubject().getPrincipal();
		try {
			if(sysUserServiceImpl.updateUserInfo(loginUser.getUserid(), user.getuCompanyid(),
					user.getuMobileno(), user.getuCname()) ) {
				ViewSysUser su = sysUserServiceImpl.selecById(loginUser.getUserid());
				loginUser.setuCname(user.getuCname());
				loginUser.setuCompanyid(user.getuCompanyid());
				loginUser.setuMobileno(user.getuMobileno());
				loginUser.setuCompanyname(su.getuCompanyname());
				return JSON.toJSONString(new Result(true, "资料修改成功！", user.getuCname()));
			} else {
				return JSON.toJSONString(new Result(false, "资料修改失败！" ));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false, "资料修改失败，出现异常,请联系管理员或重新登录试试！!"));
		}
	}
	// 上传用户头衔
	@RequestMapping(value = "/profile_uploadUserImg.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String profile_uploadImg(MultipartFile file, HttpServletRequest request, Model model) {
		SysUser loginUser = SecurityUtils.getSubject().getPrincipals().oneByType(SysUser.class);
		String dir = ConfigInfo.resources_upload_user_image;
		String value = request.getSession().getServletContext().getRealPath(dir);
		String name = file.getOriginalFilename();
		String fileName = new Date().getTime() + "" + new Random().nextInt(10000)
				+ name.substring(name.lastIndexOf('.'));
		System.out.println("文件路径：" + value + ":" + fileName);
		String url = dir + fileName;
		try {
			
			if (!sysUserServiceImpl.updatePhoto(loginUser.getUserid(), url))
			  return JSON.toJSONString(new Result(false, "上传失败!"));
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false, "上传失败!出现异常！"));
		}
		// 开始上传
		File targetFile = new File(value, fileName);
		// 保存
		try {
			if (!targetFile.exists()) {
				targetFile.mkdirs();
				file.transferTo(targetFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false, "上传失败!"));
		}
		loginUser.setuPhotourl(url);
		//session.setAttribute(Helper.SESSION_USER, loginUser);
		return JSON.toJSONString(new Result(true, "上传成功", url));
	}
	/*
	// 图片裁剪功能
	@RequestMapping(value = "/profile_imgCut.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String profile_imgCut(MultipartFile avatar_file, String avatar_src, String avatar_data,
			HttpServletRequest request, Model model) {
		SysUser loginUser = (SysUser)session.getAttribute(Helper.SESSION_USER);
		String dir = ConfigInfo.resources_upload_user_image;
		String value = request.getSession().getServletContext().getRealPath(dir);

		String name = avatar_file.getOriginalFilename();
		// 判断文件的MIMEtype
		String type = avatar_file.getContentType();
		if (type == null || !type.toLowerCase().startsWith("image/"))
			return JSON.toJSONString(new Result(false, "不支持的文件类型，仅支持图片！"));
		System.out.println("file type:" + type);
		String fileName = new Date().getTime() + "" + new Random().nextInt(10000) + "_"
				+ name.substring(name.lastIndexOf('.'));
		System.out.println("文件路径：" + value + ":" + fileName);
		new File(value).exists();
		JSONObject joData = (JSONObject) JSONObject.parse(avatar_data);
		// 用户经过剪辑后的图片的大小
		float x = joData.getFloatValue("x");
		float y = joData.getFloatValue("y");
		float w = joData.getFloatValue("width");
		float h = joData.getFloatValue("height");
		File dirFile = new File(value);
		if(!dirFile.exists()) dirFile.mkdirs();
		// 开始上传
		File targetFile = new File(dirFile, fileName);
		// 保存
		try {
			
			if (!targetFile.exists()) {
				targetFile.mkdirs();
				InputStream is = avatar_file.getInputStream();
				ImageCut.cut(is, targetFile, (int) x, (int) y, (int) w, (int) h);
				is.close();
				int rs = sysUserService.updatePhoto(loginUser.getUserid(), dir + fileName);
				if (rs <= 0)
					return JSON.toJSONString(new Result(false, "上传失败!错误码：" + rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString(new Result(false, "上传失败，出现异常：" + e.getMessage()));
		}
		loginUser.setuPhotourl(dir + fileName);
		session.setAttribute(Helper.SESSION_USER, loginUser);
		return JSON.toJSONString(
				new Result(true, "上传成功!", request.getSession().getServletContext().getContextPath() + dir + fileName));
	}
	*/
	// 下载操作手册
	@RequestMapping(value = "/downloadDoc.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void oper_downloadDoc(String filename, HttpSession session, HttpServletResponse response) {
		// 获得请求文件名
		System.out.println(filename);
		// 设置文件MIME类型
		response.setContentType(session.getServletContext().getMimeType(filename));

		// 读取目标文件，通过response将目标文件写到客户端
		// 获取目标文件的绝对路径
		String fullFileName = session.getServletContext().getRealPath("/resources/documentation/" + filename);
		System.out.println(fullFileName);
		try {
			InputStream fis = new BufferedInputStream(new FileInputStream(fullFileName));
			// 设置Content-Disposition
			response.reset(); // 重置结果集
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.getBytes(), "iso-8859-1"));
			response.addHeader("Content-Length", "" + new File(fullFileName).length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[8192];
			int bytesRead;
			// 开始向网络传输文件流
			while ((bytesRead = fis.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.flush();
			fis.close();
			os.close();
		} catch (Exception e) {
		}
	}
	@RequestMapping(value = "/accessDenied.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String accessDenied() {
		return JSON.toJSONString(new Result(false, "您没有权限对此进行操作！"));
	}
}
