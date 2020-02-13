package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustomExample;

public interface CandidateService {
	
	//插入申请者的信息
	public boolean insertCandidate(Candidate candidate);

	//获取申请者简历的信息
	public List<Candidate> getCandidateList(int page);
	
	//根据id查找申请者数据
	public CandidateCustomExample selectCandidateInfo(Integer candidateId);
	
	//获取记录申请人的页数
	public Integer countRows();
	
	//根据id更换申请人的简历状态
	public Integer updateCandidate(Integer candidateId,Byte status);
	
	//根据id查询申请人的姓名和邮箱
	public Candidate getNameAndMail(Integer candidateId);
	
	
	//明天任务
	//查询已经处理过的候选者信息 分页
	public List<Candidate> getCandidateList(int page,Byte status);
	
	
}
