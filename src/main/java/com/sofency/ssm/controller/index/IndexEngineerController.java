package com.sofency.ssm.controller.index;

import java.util.List;

import com.sofency.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.interfaces.EngineerService;

@Controller
@RequestMapping("/index")
public class IndexEngineerController {
	private final Logger LOG = LoggerFactory.getLogger(IndexEngineerController.class);
	private EngineerService engineerService;

	@Autowired
	public IndexEngineerController(EngineerService engineerService) {
		this.engineerService = engineerService;

	}
	/**
	 * 查询工作室人员的信息返回到官网的前端
	 */
	@RequestMapping("/selectEngineerInfo")
	public ModelAndView selectEngineerInfo() {
		ModelAndView model = new ModelAndView();
		List<EngineersSomeInfo> list=null;//存储返回的列表数据
		//首先从缓存中查询数据
		//从数据库中查询信息
		list=engineerService.getEngineersSomeInfo();
		LOG.info("\n"+ DateUtil.getCurrentTime()+"从数据库中拿取工作室人员数据到官网");
		model.addObject("EngineerSomeInfo", list);
		model.setViewName("indexPage/person");
		return model;
	}
}
