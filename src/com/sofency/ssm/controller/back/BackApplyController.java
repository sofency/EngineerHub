package com.sofency.ssm.controller.back;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustom;
import com.sofency.ssm.pojo.CandidateCustomExample;
import com.sofency.ssm.service.CandidateService;
import com.sofency.ssm.service.SendMailUtilService;

@Controller
@RequestMapping("/back")
public class BackApplyController {
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private SendMailUtilService sendMailUtilService;
	
	@GetMapping("/candidates/{page}")
	public ModelAndView selectCandidateList(@PathVariable("page") int page) {
		ModelAndView model = new ModelAndView();
		List<Candidate> list=candidateService.getCandidateList(page);
		//总页数
		int pages = candidateService.countRows();
		model.addObject("Candidate", list);
		model.addObject("pages", pages);
		//还要返回当前的页
		model.addObject("currentPage", page);
		model.setViewName("manager/applicationManage");
		return model;
	}
	
	//返回json数据
	@RequestMapping("/candidatesByJson/{page}")
	public @ResponseBody CandidateCustom selectCandidateListByJson(@PathVariable("page")int page) {
		ArrayList<Candidate> list=(ArrayList<Candidate>) candidateService.getCandidateList(page);//页面里面的内容
		//当前的页
		int currentPage = page;//当前页
		//总页数
		int pages = candidateService.countRows();
		CandidateCustom candidate = new CandidateCustom();
		candidate.setCurrentPage(currentPage);
		candidate.setList(list);
		candidate.setPageSize(4);
		//总页数
		return candidate;
	}
	
	//根据id查找申请者的数据
	@GetMapping("/candidate/{id}")
	@ResponseBody
	public  Candidate searchApplicationdetail(@PathVariable("id")Integer candidateId) {
		CandidateCustomExample candidate= candidateService.selectCandidateInfo(candidateId);
		System.out.println(candidate.toString());
		return candidate;
	}
	
	@PostMapping("/candidate/{id}/{status}")
	@ResponseBody
	public String postCanndidate(@PathVariable("id")Integer candidateId,@PathVariable("status")Byte status) {
		int flag =-1;
		flag = candidateService.updateCandidate(candidateId,status);//获取修改的状态
		if(status==1){
			//发送邮件给申请者
			//首先获取申请者的email
			Candidate candidate = candidateService.getNameAndMail(candidateId);
			String email = candidate.getCandidateEmail();
			String username = candidate.getCandidateName();
			//然后发送邮件
			sendMailUtilService.sendMail(email, username);
		}
		if(flag>=0) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
	//查询已经处理过的候选者信息
	
	
	
	//查询没有处理过的候选者信息
	
	
}
