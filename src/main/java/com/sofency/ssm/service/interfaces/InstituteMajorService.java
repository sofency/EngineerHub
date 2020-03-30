package com.sofency.ssm.service.interfaces;

import java.util.List;

import com.sofency.ssm.pojo.Institute;
import com.sofency.ssm.pojo.Major;

public interface InstituteMajorService {
	//获取院系
	public List<Institute> getInstitutes();
	
	//获取专业
    public List<Major> getMajors(Integer code);

}
