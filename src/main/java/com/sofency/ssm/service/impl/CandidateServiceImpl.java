package com.sofency.ssm.service.impl;

import java.util.List;

import com.sofency.ssm.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sofency.ssm.exception.CustomException;
import com.sofency.ssm.mapper.CandidateCustomMapper;
import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustomExample;
import com.sofency.ssm.pojo.CandidateExample;
import com.sofency.ssm.pojo.CandidateExample.Criteria;
import com.sofency.ssm.service.interfaces.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{
	private CandidateCustomMapper candidateCustomMapper;
	private CandidateMapper candidateMapper;

	@Autowired
	public CandidateServiceImpl(CandidateCustomMapper candidateCustomMapper, CandidateMapper candidateMapper) {
		this.candidateCustomMapper = candidateCustomMapper;
		this.candidateMapper = candidateMapper;
	}
	//每页查询的数据数
	private static final int SIZE=4;
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	//插入申请人的api
	public boolean insertCandidate(Candidate candidate) {
		int flag =0;
		try {
			 flag = this.candidateMapper.insert(candidate);
		}catch (Exception e){
			e.printStackTrace();
		}
		return flag>0?true:false;
	}
	
	//获取申请人列表的api
	@Override
	public List<Candidate> getCandidateList(Byte status) {//
		CandidateExample example = new CandidateExample();
		Criteria criteria = example.createCriteria();
		criteria.andCandidateStatusEqualTo(status);
		List<Candidate> list = candidateMapper.selectByExample(example);
		
		return list;
	}

	//根据主键查询申请人的信息
	@Override
	public CandidateCustomExample selectCandidateInfo(Integer candidateId) {
		return candidateCustomMapper.getInfoById(candidateId);
	}

	//查询简历的总页数
	@Override
	public Integer countRows() {
		int num = (int) candidateMapper.countByExample(null);
		return num/SIZE+1;
	}

	//根据id修改候选者简历状态
	@Override
	public Integer updateCandidate(Integer candidateId,Byte status) {
		/**
		 * updateByExampleSelective(@Param("record") Xxx record, @Param("example") XxxExample example);
		 *	第一个参数 是要修改的部分值组成的对象，其中有些属性为null则表示该项不修改。
		 *	第二个参数 是一个对应的查询条件的类， 通过这个类可以实现 order by 和一部分的where 条件。
		 */
		Candidate candidate = new Candidate();
		candidate.setCandidateStatus(status);//修改的值
		//条件
		CandidateExample  example = new CandidateExample();
		Criteria criteria = example.createCriteria();
		criteria.andCandidateIdEqualTo(candidateId);
		
		return candidateMapper.updateByExampleSelective(candidate, example);
	}

	@Override
	public Candidate getNameAndMail(Integer candidateId) {
		Candidate candidate = candidateMapper.selectByPrimaryKey(candidateId);
		if(candidate==null) {
			try {
				throw new CustomException("查询的用户不存在");
			} catch (CustomException e) {
				e.printStackTrace();
			}
			return null;
		}else{
			return candidate;
		}
	}
	
	@Override
	public List<Candidate> getCandidates(int page, Byte status) {
		CandidateExample  example = new CandidateExample();
		Criteria criteria = example.createCriteria();
		criteria.andCandidateStatusEqualTo(status);
		List<Candidate> list = candidateMapper.selectByExample(example);//查询状态为status的所有数据
		return list;
	}
	//根据id删除申请者
	@Override
	public void deleteCandidate(Integer candidateId) {
		candidateMapper.deleteByPrimaryKey(candidateId);//删除
	}
}