package com.sofency.ssm.controller.back;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.interfaces.FameService;
import com.sofency.ssm.utils.DateUtil;

@Controller
@RequestMapping("/back")
public class BackFamesController {
	private final Logger LOG = LoggerFactory.getLogger(BackFamesController.class);
	private FameService fameService;

	@Autowired
	public BackFamesController(FameService fameService) {
		this.fameService = fameService;
	}

	//向管理员端发送荣誉的信息
	@RequestMapping("/fames")
	public ModelAndView ShowfamesToManager() {
		ModelAndView modelAndView = new ModelAndView();
		List<FameCustom> fames = fameService.getFamesInfoList();
		System.out.println(fames);
		modelAndView.addObject("famesCustom", fames);
		modelAndView.setViewName("manager/fameManager");
		LOG.info("\n"+DateUtil.getCurrentTime()+"--查询荣誉信息");
		return modelAndView;
	}

}
