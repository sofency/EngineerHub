package com.sofency.ssm.mapper;

import java.util.List;

import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineerCustom;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.pojo.Institute;

public interface EngineerCustomMapper {
	
	/**
	 *  查找所有用户的信息
	 * @return List<Engineer>
	 */
	public List<Engineer> getAllEngineerInfo();

	
	/**
	 * 
	 * @param username
	 * @return Engineer
	 */
	public  List<Engineer> findEngineerByName(String username);
	
	
	public List<EngineersSomeInfo> getEngineersSomeInfo();//查询所有工作人员的信息到前端

	List<EngineerCustom> selectEngineersCustom(List<Integer> engineersId);
}
