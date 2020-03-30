package com.sofency.ssm.mapper;

import java.util.List;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustomExample;

public interface CandidateCustomMapper {
	public List<Candidate> findInfoByPage(int page);
	
	public CandidateCustomExample getInfoById(Integer candidateid);
}
