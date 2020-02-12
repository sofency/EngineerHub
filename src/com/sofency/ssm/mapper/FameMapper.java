package com.sofency.ssm.mapper;

import com.sofency.ssm.pojo.Fame;
import com.sofency.ssm.pojo.FameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FameMapper {
    int countByExample(FameExample example);

    int deleteByExample(FameExample example);

    int deleteByPrimaryKey(Integer fameId);

    int insert(Fame record);

    int insertSelective(Fame record);

    List<Fame> selectByExample(FameExample example);

    Fame selectByPrimaryKey(Integer fameId);

    int updateByExampleSelective(@Param("record") Fame record, @Param("example") FameExample example);

    int updateByExample(@Param("record") Fame record, @Param("example") FameExample example);

    int updateByPrimaryKeySelective(Fame record);

    int updateByPrimaryKey(Fame record);
}