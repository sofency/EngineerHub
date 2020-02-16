package com.sofency.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Engineer;

//登陆的拦截器
public class loginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println(request.getParameter("engineerSex"));
		System.out.println("处理完毕之后");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView model)
			throws Exception {
		System.out.println("处理中");
	}

	//拦截访问后台的请求 确保此时必须处于登录状态
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		//主要是判断会话中有木有用户名  防止用户粘贴网址看到相同的内容
		HttpSession session= request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username==null) {//验证不通过跳转到登陆界面
			response.sendRedirect("http://localhost:9999/EngineerHub/login.jsp");//重定向到登陆界面
			return false;
		}else {
			return true;
		}	
	}
}
