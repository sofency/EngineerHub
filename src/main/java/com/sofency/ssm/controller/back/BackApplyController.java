package com.sofency.ssm.controller.back;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustomExample;
import com.sofency.ssm.service.interfaces.CandidateService;
import com.sofency.ssm.service.interfaces.SendMailUtilService;
import com.sofency.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/back")
public class BackApplyController {
	private final Logger LOG = LoggerFactory.getLogger(BackApplyController.class);

	private CandidateService candidateService;
	private SendMailUtilService sendMailUtilService;

	@Autowired
	public BackApplyController(CandidateService candidateService, SendMailUtilService sendMailUtilService) {
		this.candidateService = candidateService;
		this.sendMailUtilService = sendMailUtilService;
	}

	@GetMapping("/getCandidates")
	public ModelAndView selectCandidateList(@RequestParam(required=true,defaultValue="1") Integer page,Byte status) {
		ModelAndView model = new ModelAndView();
		
		PageHelper.startPage(page, 5);
	    List<Candidate> candidates = candidateService.getCandidates(page, status);
	    PageInfo<Candidate> p=new PageInfo<Candidate>(candidates);
	    model.addObject("page",p);
	    model.addObject("Candidate", candidates);
	    
	    LOG.info(DateUtil.getCurrentTime()+"查询申请人");
	    if(status==0) {
	    	model.setViewName("manager/applicationManage");
	    }else if(status==1){
	    	model.setViewName("manager/applicationDetail");
	    }else {
	    	model.setViewName("manager/applicationPass");
	    }
		return model;
	}
	
	//根据id查找申请者的数据
	@GetMapping("/candidate/{id}")
	@ResponseBody
	public  CandidateCustomExample searchApplicationDetail(@PathVariable("id")Integer candidateId) {
		CandidateCustomExample candidate= candidateService.selectCandidateInfo(candidateId);
		LOG.info("\n"+DateUtil.getCurrentTime()+"从数据库中查询id为"+candidateId+"人员的信息");
		return candidate;
	}
	
	@DeleteMapping(value="/candidate/{id}")
	public String deleteCandidate(@PathVariable("id") Integer candidateId) {
		candidateService.deleteCandidate(candidateId);
		LOG.info("\n"+DateUtil.getCurrentTime()+"删除id为"+candidateId+"人员的信息");		
		return "redirect:/back/getCandidates.action?status=-1";
	}
	
	//根据状态决定是否向用户发送邮件
	@PostMapping("/candidate/{id}/{status}")
	@ResponseBody
	public String postCandidate(@PathVariable("id")Integer candidateId,@PathVariable("status")Byte status) {
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
			LOG.info("\n"+DateUtil.getCurrentTime()+"向id为"+candidateId+"申请人发送邮件");
		}
		if(flag>=0) {
			return "true";
		}else {
			return "false";
		}
	}
	
}
