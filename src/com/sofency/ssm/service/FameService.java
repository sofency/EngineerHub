package com.sofency.ssm.service;

import java.util.List;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameCustom;

public interface FameService {
	//获取荣誉的信息
	public List<Fame> getFamesList();
	
	//荣誉管理页面获取的荣誉信息
	public List<FameCustom> getFamesInfoList();

}
