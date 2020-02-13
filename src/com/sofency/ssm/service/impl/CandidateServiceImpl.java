package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sofency.exception.CustomException;
import com.sofency.ssm.mapper.CandidateCustomMapper;
import com.sofency.ssm.mapper.CandidateMapper;
import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateCustomExample;
import com.sofency.ssm.pojo.CandidateExample;
import com.sofency.ssm.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{
	@Autowired
	private CandidateCustomMapper candidateCustomMapper;
	@Autowired
	private CandidateMapper candidateMapper;
	
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
	public List<Candidate> getCandidateList(int page) {
		return candidateCustomMapper.findInfoByPage(page*SIZE);
	}

	//根据主键查询申请人的信息
	@Override
	public CandidateCustomExample selectCandidateInfo(Integer candidateId) {
		return candidateCustomMapper.getInfoById(candidateId);
	}

	//查询简历的总页数
	@Override
	public Integer countRows() {
		int num =candidateMapper.countByExample(null);
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
		candidate.setCandidatestatus(status);//修改的值
		//条件
		CandidateExample  example = new CandidateExample();
		com.sofency.ssm.pojo.CandidateExample.Criteria criteria = example.createCriteria();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return candidate;
		}
	}
	
	@Override
	public List<Candidate> getCandidateList(int page, Byte status) {
		
		return null;
	}
}