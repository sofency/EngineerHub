package com.sofency.ssm.controller.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.exception.CustomException;
import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineerCustomJson;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.CandidateService;
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
	
	
	
	//以json 形式返回前端
	@RequestMapping("/showEngineerInfoToManagerByJson")
	public @ResponseBody  EngineerCustomJson showEngineerInfoToManagerByJson(int page) {
		
		ArrayList<Engineer> list=(ArrayList<Engineer>) engineerService.selectPartEngineerInfo(page);
		//获取总页数
		Integer pages = engineerService.getEngineerNum();
	
		int currentPage = page;
		EngineerCustomJson engineer = new EngineerCustomJson();
		engineer.setCurrentPage(currentPage);
		engineer.setPages(pages);
		engineer.setList(list);
		return engineer ;
	}

}
