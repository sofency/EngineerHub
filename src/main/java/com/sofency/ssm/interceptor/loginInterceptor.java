package com.sofency.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

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
		//判断session过期
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");//解决中文乱码
		System.out.println("[AccessInterceptor]:preHandle执行");

		String username = (String) session.getAttribute("username");
		ServletContext application = request.getSession().getServletContext();
		System.out.println("拦截的用户名字"+username);
		if(username==null){
			username="" ;
		}
		String session1Id = (String) application.getAttribute(username);//application.getAttribute(如果传入的值为null的话报错)
		if(!session.getId().equals(session1Id)){//如果当前的session1和session 不相等的话
			//根据对象的session里面判断是否存储由username属性 如果有说明已经登录过
			PrintWriter out = response.getWriter();
			StringBuffer sb = new StringBuffer("<script type=\"text/javascript\" charset=\"UTF-8\">");
			sb.append("alert(\"你的账号被挤掉,或者没有登录,或者页面已经过期,请重新登录\");");
			sb.append("window.location.href=\"/EngineerHub/logoutmethod\";");
			sb.append("</script>");
			out.print(sb.toString());
			out.close();
			return false;
		}else{    //已经登录
			return true;
		}
	}
}
