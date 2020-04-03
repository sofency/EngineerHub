package com.sofency.ssm.controller.index;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sofency.ssm.pojo.Institute;
import com.sofency.ssm.service.interfaces.InstituteMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.service.interfaces.CandidateService;

@Controller
@RequestMapping("/index")
public class IndexApplyController {

	private CandidateService candidateService;
	private InstituteMajorService instituteMajorService;
	@Autowired
	public IndexApplyController(CandidateService candidateService, InstituteMajorService instituteMajorService) {
		this.candidateService = candidateService;
		this.instituteMajorService = instituteMajorService;
	}
	//申请表单
	@RequestMapping("/insertApply")
	public ModelAndView insertApply(Candidate candidate) {
		candidate.setCandidateStatus((byte) 0);
		boolean flag = this.candidateService.insertCandidate(candidate);
		System.out.println("插入的结果"+flag);
		ModelAndView model = new ModelAndView();
		if(flag) {
			model.addObject("flag", "插入成功");
		}else {
			model.addObject("flag", "插入失败");
		}
		model.setViewName("indexPage/join");
		return model;
	}
	//获取院系
	@RequestMapping("/toJoin")
	public String getInstitute(Model model) {
		List<Institute> list = null;
		list = instituteMajorService.getInstitutes();
		model.addAttribute("institutes", list);//学院是一个
		Map<String,String> map = new HashMap<>();
		for(Institute institute:list) {//存储到缓存中
			map.put(institute.getInstId().toString(), institute.getInstName());
		}
		return "indexPage/join";
	}
}
