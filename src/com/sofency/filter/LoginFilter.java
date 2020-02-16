package com.sofency.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		//从cookie里面拿数据
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		for(Cookie c :cookies) {
			if(c.getName().equals("autologin")) {
				HttpSession session = request.getSession();
				String usernameCookie = c.getValue().split("|")[0];
				String userpwdCookie = c.getValue().split("|")[1];
				
				if(username.equals(usernameCookie)&&userpwd.equals(userpwdCookie)) {
					flag = true;
					session.setAttribute("username", usernameCookie);
				}
				break;
			}
		}
		if(flag) {
			response.sendRedirect("/EngineerHub/back/candidates/0");
		}else {
			chain.doFilter(arg0, arg1);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
