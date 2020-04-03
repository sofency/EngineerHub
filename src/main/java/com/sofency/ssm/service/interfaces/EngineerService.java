package com.sofency.ssm.service.interfaces;

import java.util.List;

import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineerCustom;
import com.sofency.ssm.pojo.EngineersSomeInfo;

public interface EngineerService {
	//添加工作室人员
	public int insertEngineer(Engineer engineer);

	//获取工作室所有人员的信息
	public List<Engineer> getAll();

	//根据名字获取信息
	public List<Engineer> findEngineerInfoByName(String username);
	
	//获取工作室人员部分信息到前端
	public List<EngineersSomeInfo> getEngineersSomeInfo();
	
	//根据员工id查询数据
	public Engineer GetInfo(Integer id);

	//修改信息
	public void save(Engineer engineer);

	//删除信息
	public int delete(Integer id);

    List<EngineerCustom> selectCodeGod(List<Integer> engineerIds);
}
