package com.sofency.ssm.service.interfaces;

import java.util.List;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameCustom;

public interface FameService {
	//获取荣誉的信息
	public List<Fame> getFameList();
	//荣誉管理页面获取的荣誉信息
	List<FameCustom> getFameInfoList();

	Fame getFameByName(String FameName);

	int insert(Fame fame1);

	FameCustom getFameInfo(FameCustom fameCustom);
}
