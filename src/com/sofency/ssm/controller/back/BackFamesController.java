package com.sofency.ssm.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.CandidateService;
import com.sofency.ssm.service.FameService;

@Controller
@RequestMapping("/back")
public class BackFamesController {
	
	
	@Autowired
	private FameService fameService;
	
	//向管理员端发送荣誉的信息
	@RequestMapping("/fames")
	public ModelAndView ShowfamesToManager() {
		ModelAndView modelAndView = new ModelAndView();
		List<FameCustom> fames = fameService.getFamesInfoList();
		System.out.println(fames);
		modelAndView.addObject("famesCustom", fames);
		modelAndView.setViewName("manager/fameManager");
		return modelAndView;
	}

}
