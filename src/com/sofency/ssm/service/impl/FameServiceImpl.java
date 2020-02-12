package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.FameCustomMapper;
import com.sofency.ssm.mapper.FameMapper;
import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.FameService;

public class FameServiceImpl implements FameService{
	
	@Autowired
	private FameMapper fameMapper;
	
	@Autowired
	private FameCustomMapper fameCustomMapper;
	
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
