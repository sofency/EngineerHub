package com.sofency.ssm.controller.index;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.service.FameService;
import com.sofency.utils.DateUtil;

@Controller
@RequestMapping("/index")
public class IndexFamesController {
	private final Logger LOG = LoggerFactory.getLogger(IndexFamesController.class);
	@Autowired
	private FameService fameService;
	
	@Autowired
	private  RedisTemplate<Object, Fame> redisTemplate;
	
	@RequestMapping("/showfames")
	public ModelAndView showFames() {
		ModelAndView modelAndView = new ModelAndView();
		//首先从缓存中拿取数据
		List<Fame> famesList =null;
		if(redisTemplate.hasKey("fames:list")) {
			famesList = redisTemplate.opsForList().range("fames", 0, -1);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从缓存中拿取荣誉信息");
		}else {
			famesList = fameService.getFamesList();
			redisTemplate.opsForList().leftPushAll("fames:list", famesList);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从数据库中拿取荣誉信息");
		}
		modelAndView.addObject("fames", famesList);
		modelAndView.setViewName("indexPage/fame");
		return modelAndView;
	}

}
