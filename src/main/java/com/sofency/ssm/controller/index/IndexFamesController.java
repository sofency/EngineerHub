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
import com.sofency.ssm.service.interfaces.FameService;
import com.sofency.ssm.utils.DateUtil;

@Controller
@RequestMapping("/index")
public class IndexFamesController {
	private final Logger LOG = LoggerFactory.getLogger(IndexFamesController.class);

	private FameService fameService;
	private  RedisTemplate<Object, Fame> redisTemplate;

	@Autowired
	public IndexFamesController(FameService fameService, RedisTemplate<Object, Fame> redisTemplate) {
		this.fameService = fameService;
		this.redisTemplate = redisTemplate;
	}

	@RequestMapping("/showfames")
	public ModelAndView showFames() {
		ModelAndView modelAndView = new ModelAndView();
		//首先从缓存中拿取数据
		List<Fame> fameList = fameService.getFamesList();
		LOG.info("\n"+DateUtil.getCurrentTime()+"从数据库中拿取荣誉信息");
		modelAndView.addObject("fames", fameList);
		modelAndView.setViewName("indexPage/fame");
		return modelAndView;
	}

}
