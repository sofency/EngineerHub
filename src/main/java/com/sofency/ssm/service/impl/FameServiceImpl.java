package com.sofency.ssm.service.impl;

import java.util.List;

import com.sofency.ssm.mapper.FameMapper;
import com.sofency.ssm.pojo.FameExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.FameCustomMapper;
import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameCustom;
import com.sofency.ssm.service.interfaces.FameService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


public class FameServiceImpl implements FameService{
	private FameMapper fameMapper;
	private FameCustomMapper fameCustomMapper;
	@Autowired
	public FameServiceImpl(FameMapper fameMapper, FameCustomMapper fameCustomMapper) {
		this.fameMapper = fameMapper;
		this.fameCustomMapper = fameCustomMapper;
	}

	//获取所取荣誉列表的api  暂时未使用
	@Override
	public List<Fame> getFameList() {
		List<Fame> list = fameMapper.selectByExample(null);
		return list;
	}

	//获得详细荣誉列表的api
	@Override
	@Cacheable(value = "fame",key = "'fame:'+#page")
	public List<FameCustom> getFameInfoList(int page) {
		return fameCustomMapper.getFameInfoList();
	}

	@Override
	@Cacheable(value = "fame",key = "'fame:'+#fameName")
	public Fame getFameByName(String fameName) {
		FameExample example = new FameExample();
		example.createCriteria().andFameNameEqualTo(fameName);
		List<Fame> fame = fameMapper.selectByExample(example);
		if(fame.size()==0){
			return null;
		}else{
			return fame.get(0);
		}
	}

	@Override
	@CacheEvict(value = {"fame"},allEntries = true)
	public int insert(Fame fame1) {
		fameMapper.insert(fame1);
		return fame1.getFameId();
	}

	@Override
	@Cacheable(value = "fame",key = "'fame:'+#fameCustom.engineerId+':'+#fameCustom.fameId")
	public FameCustom getFameInfo(FameCustom fameCustom) {
		List<FameCustom> list = fameCustomMapper.getFameInfo(fameCustom);
		if(list==null || list.size()==0){
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	@Cacheable(value = "threeIds",key = "'threeIds'")
	public List<Integer> getThreeId() {
		System.out.println("我到了");
		return fameCustomMapper.getThreeId();
	}
}
