package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.InstitudeMapper;
import com.sofency.ssm.mapper.MajorMapper;
import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.pojo.Major;
import com.sofency.ssm.pojo.MajorExample;
import com.sofency.ssm.pojo.MajorExample.Criteria;
import com.sofency.ssm.service.InstitudeMajorService;

public class InstitudeMajorServiceImpl implements InstitudeMajorService{
	
	@Autowired
	private InstitudeMapper institudeMapper;
	
	@Autowired
	private MajorMapper majorMapper;
	
	@Override
	public List<Institude> getInstitudes() {
		List<Institude> list = institudeMapper.selectByExample(null);//查询所有
		return list;
	}

	@Override
	public List<Major> getMajors(Integer code) {
		MajorExample major = new MajorExample();
		Criteria c = major.createCriteria();
		c.andInstidEqualTo(code);
		List<Major> list = majorMapper.selectByExample(major);
		return list;
	}

}
