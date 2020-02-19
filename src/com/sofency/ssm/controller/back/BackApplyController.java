package com.sofency.ssm.controller.back;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
import com.sofency.utils.DateUtil;

@Controller
@RequestMapping("/back")
public class BackApplyController {
	private final Logger LOG = LoggerFactory.getLogger(BackApplyController.class);
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private SendMailUtilService sendMailUtilService;
	
	@Autowired
	private  RedisTemplate<Object, Object> redisTemplate;
	
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
	    	model.setViewName("manager/applicationDealed");
	    }else {
	    	model.setViewName("manager/applicationPass");
	    }
		return model;
	}
	
	//根据id查找申请者的数据
	@GetMapping("/candidate/{id}")
	@ResponseBody
	public  CandidateCustomExample searchApplicationdetail(@PathVariable("id")Integer candidateId) {
		CandidateCustomExample candidate=null;
		//先从缓存中查找信息
		if(redisTemplate.hasKey("candidateCustomExample"+candidateId)) {
			candidate=(CandidateCustomExample) redisTemplate.opsForValue().get("candidateCustomExample"+candidateId);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从缓存中查询id为"+candidateId+"人员的信息");
		}else {
			candidate= candidateService.selectCandidateInfo(candidateId);
			LOG.info("\n"+DateUtil.getCurrentTime()+"从数据库中查询id为"+candidateId+"人员的信息");
			redisTemplate.opsForValue().set("candidateCustomExample"+candidateId, candidate);//添加到缓存中
		}
		return candidate;
	}
	
	@DeleteMapping(value="/candidate/{id}")
	public String deleteCandidate(@PathVariable("id") Integer candidateId) {
		candidateService.deleteCandidate(candidateId);
		if(redisTemplate.hasKey("candidate"+candidateId)) {//删除缓存中的数据
			redisTemplate.delete("candidate"+candidateId);
		}
		
		LOG.info("\n"+DateUtil.getCurrentTime()+"删除id为"+candidateId+"人员的信息");		
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
			LOG.info("\n"+DateUtil.getCurrentTime()+"向id为"+candidateId+"申请人发送邮件");
		}
		if(flag>=0) {
			return "true";
		}else {
			return "false";
		}
	}
	
}
