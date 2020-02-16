package com.sofency.ssm.controller.index;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.EngineerService;

@Controller
@RequestMapping("/index")
public class IndexEngineerController {
	@Autowired
	private EngineerService engineerService;
	
	/**
	 * 查询工作室人员的信息返回到官网的前端
	 */
	@RequestMapping("/selectEngineerInfo")
	public ModelAndView selectEngineerInfo() {
		ModelAndView model = new ModelAndView();
		List<EngineersSomeInfo> list=engineerService.getEngineersSomeInfo();
		model.addObject("EngineerSomeInfo", list);
		System.out.println(list.get(0).getEngineerGit());
		model.setViewName("indexPage/person");
		return model;
	}

}
