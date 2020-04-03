package com.sofency.ssm.controller.back;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sofency.utils.DateUtil;
import com.sofency.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sofency.ssm.pojo.Manager;
import com.sofency.ssm.service.interfaces.LoginService;

import java.util.Map;

@Controller
public class LoginController {
	private final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	private String username;
	//登录成功
	@RequestMapping("/login")
	public String login(Model model,Manager manager,HttpServletRequest request,HttpServletResponse response) {
		username= manager.getUsername();
		String userPwd = manager.getUserpwd();
		String md5pwd= MD5Utils.md5(userPwd);//加密后的密码
		HttpSession session = request.getSession();//获取session
		String remember = request.getParameter("remember");//是否记住
		//根据账户查找密码
		String realPassword = loginService.getPassword(username);
		System.out.println("加密后的密码是"+realPassword);

		if(md5pwd.equals(realPassword)) {
			session.setAttribute("username", username);
			ServletContext application = request.getSession().getServletContext();
			application.setAttribute(username,session.getId());///将session添加到application里面管理

			if(remember!=null) {//说明用户要记住密码 默认记住时间为10天
				Cookie cookie = new Cookie("autoLogin",username+"|"+md5pwd);
				cookie.setMaxAge(60*60*24*10);//存储一个月
				cookie.setPath("/");
				response.addCookie(cookie);//添加cookie
			}
			LOG.info("\n"+ DateUtil.getCurrentTime()+"--"+username+"登录后台");
			return "redirect:/back/getCandidates?page=0&&status=0";//未处理
		}else {
			model.addAttribute("flag", "密码或者账户错误");
			return "login";
		}
	}

	@RequestMapping("/logoutmethod")
	public String logout(HttpSession session) {
		//将session注销 并且返回到登录界面
		session.invalidate();
		LOG.info("\n"+DateUtil.getCurrentTime()+"--"+username+"退出后台");
		return "redirect:login.jsp";
	}
}
