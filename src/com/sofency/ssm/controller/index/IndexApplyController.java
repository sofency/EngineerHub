package com.sofency.ssm.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.service.CandidateService;
import com.sofency.ssm.service.InstitudeMajorService;
import com.sofency.utils.JedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/index")
public class IndexApplyController {
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private InstitudeMajorService institudeMajorService;
	
	//申请表单
	@RequestMapping("/insertApply")
	public ModelAndView insertApply(Candidate candidate) throws EmailException {
		boolean flag = this.candidateService.insertCandidate(candidate);
		System.out.println("插入的结果"+flag);
		ModelAndView model = new ModelAndView();
		if(flag) {
			model.addObject("flag", "插入成功");
		}else {
			model.addObject("flag", "插入失败");
		}
		model.setViewName("indexPage/join");
		return model;
	}
	
	//获取院系
	@RequestMapping("/toJoin")
	public String getInstitude(Model model) {
		List<Institude> list = null;
		Jedis jedis = JedisUtil.getResource();
		Integer cache = jedis.hgetAll("institudes").size();
		if(cache!=0) {//从缓存中取值
			Long size = jedis.hlen("institudes");
			list= new ArrayList<Institude>();
			for(int i=1;i<=size;i++) {
				String name = jedis.hget("institudes", ""+i+"");
				Institude institude = new Institude();
				institude.setInstid(i);
				institude.setInstname(name);
				list.add(institude);
			}
			model.addAttribute("institudes", list);//学院是一个
			
		}else {//查询数据库
			list = institudeMajorService.getInstitudes();
			model.addAttribute("institudes", list);//学院是一个
			Map<String,String> map = new HashMap<>();
			for(Institude institude:list) {//存储到缓存中
				map.put(institude.getInstid().toString(), institude.getInstname());
			}
			jedis.hmset("institudes", map);
			jedis.close();
		}
		return "indexPage/join";
	}

}
