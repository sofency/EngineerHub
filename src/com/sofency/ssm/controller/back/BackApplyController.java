package com.sofency.ssm.controller.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sofency.ssm.pojo.Candidate;
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
	
	@GetMapping("/getCandidates")
	public ModelAndView selectCandidateList(@RequestParam(required=true,defaultValue="1") Integer page,Byte status) {
		ModelAndView model = new ModelAndView();
		List<Candidate> list=candidateService.getCandidateList(status);//获取状态的信息
		PageHelper.startPage(page, 5);
	    List<Candidate> candidates = candidateService.getCandidates(page, status);
	    PageInfo<Candidate> p=new PageInfo<Candidate>(candidates);
	    model.addObject("page",p);
	    model.addObject("Candidate", candidates);
	    if(status==0) {
	    	model.setViewName("manager/applicationManage");
	    }else if(status==1){
	    	model.setViewName("manager/applicationDealed");
	    }else {
	    	model.setViewName("manager/applicationPass");
	    }
		return model;
	}
	
	//根据id查找申请者的数据
	@GetMapping("/candidate/{id}")
	@ResponseBody
	public  Candidate searchApplicationdetail(@PathVariable("id")Integer candidateId) {
		CandidateCustomExample candidate= candidateService.selectCandidateInfo(candidateId);
		System.out.println(candidate.toString());
		return candidate;
	}
	
	@DeleteMapping(value="/candidate/{id}")
	public String deleteCandidate(@PathVariable("id") Integer candidateId) {
		candidateService.deleteCandidate(candidateId);
		return "redirect:/back/getCandidates.action?status=-1";
	}
	
	//根据状态决定是否向用户发送邮件
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
	
}
