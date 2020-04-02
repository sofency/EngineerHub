package com.sofency.ssm.controller.index;

import java.util.List;

import com.sofency.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.service.interfaces.FameService;
@Controller
@RequestMapping("/index")
public class IndexFameController {
	private final Logger LOG = LoggerFactory.getLogger(IndexFameController.class);

	private FameService fameService;

	@Autowired
	public IndexFameController(FameService fameService) {
		this.fameService = fameService;
	}

	@RequestMapping("/showFameList")
	public ModelAndView showFame() {
		ModelAndView modelAndView = new ModelAndView();
		//首先从缓存中拿取数据
		List<Fame> fameList = fameService.getFameList();
		LOG.info("\n"+ DateUtil.getCurrentTime()+"从数据库中拿取荣誉信息");
		modelAndView.addObject("fameList", fameList);
		modelAndView.setViewName("indexPage/fame");
		return modelAndView;
	}

}
