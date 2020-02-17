package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.EngineerCustomMapper;
import com.sofency.ssm.mapper.EngineerMapper;
import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.EngineerService;

public class EngineerServiceImpl implements EngineerService{
	
	@Autowired
	private EngineerCustomMapper engineerCustomMapper;
	
	@Autowired
	private EngineerMapper engineerMapper;
	
	//插入工作室人员的信息
	@Override
	public int insertEngineer(Engineer engineer) {	
		int flag = engineerMapper.insert(engineer);
		System.out.println("插入数据为flag="+flag+"engineer="+engineer);
		return flag;
	}
		
	@Override
	public List<Engineer> getAll() {
		return engineerCustomMapper.getAllEngineerInfo();
	}
	
	
	@Override
	public List<Engineer> findEngineerInfoByName(String username) {
		return engineerCustomMapper.findEngineerByName(username);
	}
	
	
	@Override
	public List<EngineersSomeInfo> getEngineersSomeInfo() {
		return engineerCustomMapper.getEngineersSomeInfo();
	}

	@Override
	public Engineer GetInfo(Integer id) {
		return engineerMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(Engineer engineer) {
		engineerMapper.updateByPrimaryKeySelective(engineer);
	}

	@Override
	public int delete(Integer id) {
		int flag = engineerMapper.deleteByPrimaryKey(id);
		return flag;
	}
	
	
	
}
