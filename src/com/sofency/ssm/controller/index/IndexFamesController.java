package com.sofency.ssm.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.service.FameService;

@Controller
@RequestMapping("/index")
public class IndexFamesController {
	
	@Autowired
	private FameService fameService;
	
	@RequestMapping("/showfames")
	public ModelAndView showFames() {
		ModelAndView modelAndView = new ModelAndView();
		List<Fame> fames = fameService.getFamesList();
		modelAndView.addObject("fames", fames);
		modelAndView.setViewName("indexPage/fame");
		return modelAndView;
	}

}
