package com.sofency.ssm.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sofency.ssm.service.interfaces.InstituteMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sofency.ssm.pojo.Major;

@Controller
public class CommonController {

	private InstituteMajorService instituteMajorService;


	@Autowired
	public CommonController(InstituteMajorService instituteMajorService) {
		this.instituteMajorService = instituteMajorService;
	}
	//获取院系对应的专业
	@SuppressWarnings("unchecked")
	@RequestMapping("/getMajor")
	public @ResponseBody List<Major> getMajor(Model model,HttpServletRequest request) {
		List<Major> list = null;//存储返回的专业信息
		
		System.out.println(request.getParameter("code"));
		int code = Integer.valueOf(request.getParameter("code"));
		//假设缓存中专业major1 
		//根据code的值向缓存中查询数据
		list = instituteMajorService.getMajors(code);
		return list;
	}
	
}
