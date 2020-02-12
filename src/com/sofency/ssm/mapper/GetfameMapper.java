package com.sofency.ssm.mapper;

import com.sofency.ssm.pojo.Getfame;
import com.sofency.ssm.pojo.GetfameExample;
import com.sofency.ssm.pojo.GetfameKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GetfameMapper {
    int countByExample(GetfameExample example);

    int deleteByExample(GetfameExample example);

    int deleteByPrimaryKey(GetfameKey key);

    int insert(Getfame record);

    int insertSelective(Getfame record);

    List<Getfame> selectByExample(GetfameExample example);

    Getfame selectByPrimaryKey(GetfameKey key);

    int updateByExampleSelective(@Param("record") Getfame record, @Param("example") GetfameExample example);

    int updateByExample(@Param("record") Getfame record, @Param("example") GetfameExample example);

    int updateByPrimaryKeySelective(Getfame record);

    int updateByPrimaryKey(Getfame record);
}