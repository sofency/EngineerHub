package com.sofency.ssm.mapper;

import java.util.List;

import com.sofency.ssm.pojo.FameCustom;

public interface FameCustomMapper {
	List<FameCustom> getFameInfoList();

	List<FameCustom> getFameInfo(FameCustom fameCustom);

	List<Integer> getThreeId();
}
