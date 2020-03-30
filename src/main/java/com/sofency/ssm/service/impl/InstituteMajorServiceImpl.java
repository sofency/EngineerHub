package com.sofency.ssm.service.impl;

import java.util.List;

import com.sofency.ssm.mapper.InstituteMapper;
import com.sofency.ssm.mapper.MajorMapper;
import com.sofency.ssm.pojo.Institute;
import com.sofency.ssm.service.interfaces.InstituteMajorService;
import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.pojo.Major;
import com.sofency.ssm.pojo.MajorExample;
import com.sofency.ssm.pojo.MajorExample.Criteria;
import org.springframework.stereotype.Service;

@Service
public class InstituteMajorServiceImpl implements InstituteMajorService {

	private InstituteMapper instituteMapper;
	private MajorMapper majorMapper;

	@Autowired
	public InstituteMajorServiceImpl(InstituteMapper instituteMapper, MajorMapper majorMapper) {
		this.instituteMapper = instituteMapper;
		this.majorMapper = majorMapper;
	}

	@Override
	public List<Institute> getInstitutes() {
		List<Institute> list = instituteMapper.selectByExample(null);//查询所有
		return list;
	}

	@Override
	public List<Major> getMajors(Integer code) {
		MajorExample major = new MajorExample();
		Criteria c = major.createCriteria();
		c.andInstIdEqualTo(code);
		List<Major> list = majorMapper.selectByExample(major);
		return list;
	}

}
