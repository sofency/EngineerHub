package com.sofency.ssm.controller.index;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.EngineerService;
import com.sofency.utils.DateUtil;

@Controller
@RequestMapping("/index")
public class IndexEngineerController {
	private final Logger LOG = LoggerFactory.getLogger(IndexEngineerController.class);
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private  RedisTemplate<Object, EngineersSomeInfo> redisTemplate;
	/**
	 * 查询工作室人员的信息返回到官网的前端
	 */
	@RequestMapping("/selectEngineerInfo")
	public ModelAndView selectEngineerInfo() {
		ModelAndView model = new ModelAndView();
		List<EngineersSomeInfo> list=null;//存储返回的列表数据
		//首先从缓存中查询数据
		if(redisTemplate.hasKey("EngineersSomeInfo")) {
			//获取缓存中的所有数据
			list = redisTemplate.opsForList().range("EngineersSomeInfo",0,-1);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从缓存中拿取工作室人员数据到官网");
		}else {
			//从数据库中查询信息
			list=engineerService.getEngineersSomeInfo();
			redisTemplate.opsForList().leftPushAll("EngineersSomeInfo", list);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从数据库中拿取工作室人员数据到官网");
		}
		model.addObject("EngineerSomeInfo", list);
		model.setViewName("indexPage/person");
		return model;
	}
}
