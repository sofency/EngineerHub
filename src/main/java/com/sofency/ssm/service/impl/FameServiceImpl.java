package com.sofency.ssm.service.impl;

import java.util.List;

import com.sofency.ssm.mapper.FameMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.FameCustomMapper;
import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.interfaces.FameService;
import org.springframework.stereotype.Service;

@Service
public class FameServiceImpl implements FameService{

	private FameMapper fameMapper;
	private FameCustomMapper fameCustomMapper;

	@Autowired
	public FameServiceImpl(FameMapper fameMapper, FameCustomMapper fameCustomMapper) {
		this.fameMapper = fameMapper;
		this.fameCustomMapper = fameCustomMapper;
	}

	//获取所取荣誉列表的api
	@Override
	public List<Fame> getFamesList() {
		List<Fame> list = fameMapper.selectByExample(null);
		return list;
	}
	

	//获得详细荣誉列表的api
	@Override
	public List<FameCustom> getFamesInfoList() {
		
		return fameCustomMapper.getFamesInfoList();
	}	

}
