package com.sofency.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.EngineerCustomMapper;
import com.sofency.ssm.mapper.EngineerMapper;
import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineersSomeInfo;
import com.sofency.ssm.service.EngineerService;

public class EngineerServiceImpl implements EngineerService{
	
	//每页查询的数据数
	private static final int SIZE=4;
	
	@Autowired
	private EngineerCustomMapper engineerCustomMapper;
	
	@Autowired
	private EngineerMapper engineerMapper;
	
	//插入工作室人员的信息
	@Override
	public int insertEngineer(Engineer engineer) {		
		return engineerMapper.insert(engineer);
	}
		
	@Override
	public List<Engineer> selectEngineerInfo() {
		return engineerCustomMapper.getAllEngineerInfo();
	}
	
	@Override
	public List<Engineer> selectPartEngineerInfo(int page) {
		// TODO Auto-generated method stub
		return engineerCustomMapper.findEngineerInfoByPage(page*SIZE);
	}
	
	@Override
	public Integer getEngineerNum() {
		// TODO Auto-generated method stub
		int num = engineerMapper.countByExample(null);
		return num/SIZE+1;
	}

	
	@Override
	public List<Engineer> findEngineerInfoByName(String username) {
		return engineerCustomMapper.findEngineerByName(username);
	}
	
	
//  测试出现异常
	@Override
	public List<EngineersSomeInfo> getEngineersSomeInfo() {
		/*if(0==0) {
			try {
				throw new CustomException("未知错误");
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else {*/
			return engineerCustomMapper.getEngineersSomeInfo();
		//}
	}
	
}
