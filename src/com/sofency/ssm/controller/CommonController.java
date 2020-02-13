package com.sofency.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sofency.ssm.pojo.Major;
import com.sofency.ssm.service.InstitudeMajorService;

@Controller
public class CommonController {
	
	@Autowired
	private InstitudeMajorService institudeMajorService;
	
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private  RedisTemplate redisTemplate;
	//获取院系对应的专业
	@SuppressWarnings("unchecked")
	@RequestMapping("/getMajor")
	public @ResponseBody List<Major> getMajor(Model model,HttpServletRequest request) {
		List<Major> list = null;//存储返回的专业信息
		
		System.out.println(request.getParameter("code"));
		int code = Integer.valueOf(request.getParameter("code"));
		//假设缓存中专业major1 
		//根据code的值向缓存中查询数据
		//major2 
		List<String> valuelist = redisTemplate.opsForHash().values("major:"+code);
		if(valuelist.size()!=0) {//缓存中存在数据
			list = new ArrayList<Major>();
			Map<Integer,String> map = redisTemplate.opsForHash().entries("major:"+code);
			System.out.println(map.size());
			for(Map.Entry<Integer, String> a : map.entrySet()){
				Major major = new Major();
				major.setMajorid(a.getKey());
				major.setMajorname(a.getValue());
				list.add(major);
			}
		}else {//向数据库中查询数据
			list = institudeMajorService.getMajors(code);
			Map<Integer,String> map = new HashMap<Integer,String>();
			for(Major major:list) {
				map.put(major.getMajorid(),major.getMajorname());
			}
			redisTemplate.opsForHash().putAll("major:"+code, map);
		}
		
		return list;
	}
	
}
