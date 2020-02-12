package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.pojo.Major;

public interface InstitudeMajorService {
	//获取院系
	public List<Institude> getInstitudes();
	
	//获取专业
    public List<Major> getMajors(Integer code);

}
