package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineersSomeInfo;

public interface EngineerService {
	
	//添加工作室人员
	public int insertEngineer(Engineer engineer);

	//获取工作室所有人员的信息
	public List<Engineer> selectEngineerInfo();
	
	//获取工作室所有人员的信息
	public List<Engineer> selectPartEngineerInfo(int page);
	
	//获取工作人员的总人数
	public Integer getEngineerNum();
	
	//根据名字获取信息
	public List<Engineer> findEngineerInfoByName(String username);
	
	//获取工作室人员部分信息到前端
	public List<EngineersSomeInfo> getEngineersSomeInfo();
}
