package com.sofency.ssm.service.impl;

import java.util.List;

import com.sofency.ssm.mapper.EngineerMapper;
import com.sofency.ssm.pojo.EngineerCustom;
import com.sofency.ssm.pojo.EngineerExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.sofency.ssm.mapper.EngineerCustomMapper;
import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.interfaces.EngineerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class EngineerServiceImpl implements EngineerService{
	private EngineerCustomMapper engineerCustomMapper;
	private EngineerMapper engineerMapper;

	@Autowired
	public EngineerServiceImpl(EngineerCustomMapper engineerCustomMapper, EngineerMapper engineerMapper) {
		this.engineerCustomMapper = engineerCustomMapper;
		this.engineerMapper = engineerMapper;
	}

	//插入工作室人员的信息
	@Override
	@CachePut(value = "engineers",key = "engineer.engineerId")
	public int insertEngineer(Engineer engineer) {	
		int flag = engineerMapper.insert(engineer);
		System.out.println("插入数据为flag="+flag+"engineer="+engineer);
		return flag;
	}
		
	@Override
	@Cacheable(value = "engineers",key = "'page:'+#page")
	public List<Engineer> getAll(int page) {
		return engineerCustomMapper.getAllEngineerInfo();
	}

	@Override
	@Cacheable(value = "engineers",key = "#username")
	public List<Engineer> findEngineerInfoByName(String username) {
		return engineerCustomMapper.findEngineerByName(username);
	}

	//查询一些消息
	@Override
	@Cacheable(value = "engineers",key ="'engineersIndex'" )
	public List<EngineersSomeInfo> getEngineersSomeInfo() {
		return engineerCustomMapper.getEngineersSomeInfo();
	}

	@Override
	@Cacheable(value = "engineers",key = "#id")
	public Engineer getInfo(Integer id) {
		return engineerMapper.selectByPrimaryKey(id);
	}

	@Override
	@CacheEvict(value ="engineers",key = "#engineer.engineerId")
	public void save(Engineer engineer) {
		engineerMapper.updateByPrimaryKeySelective(engineer);
	}

	@Override
	@CacheEvict(value = "engineers",key = "#id")
	public int delete(Integer id) {
		int flag = engineerMapper.deleteByPrimaryKey(id);
		return flag;
	}

	@Override
    @Cacheable(value = "engineers",key = "'codeGods'")
	public List<EngineerCustom> selectCodeGod(List<Integer> engineerIds) {
		System.out.println(engineerIds.toArray());
		List<EngineerCustom> engineers = engineerCustomMapper.selectEngineersCustom(engineerIds);
		System.out.println(engineers);
		return engineers;
	}
}
