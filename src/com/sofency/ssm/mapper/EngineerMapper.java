package com.sofency.ssm.mapper;

import com.sofency.ssm.pojo.Engineer;
import com.sofency.ssm.pojo.EngineerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EngineerMapper {
    int countByExample(EngineerExample example);

    int deleteByExample(EngineerExample example);

    int deleteByPrimaryKey(Integer engineerId);

    int insert(Engineer record);

    int insertSelective(Engineer record);

    List<Engineer> selectByExample(EngineerExample example);

    Engineer selectByPrimaryKey(Integer engineerId);

    int updateByExampleSelective(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByExample(@Param("record") Engineer record, @Param("example") EngineerExample example);

    int updateByPrimaryKeySelective(Engineer record);

    int updateByPrimaryKey(Engineer record);
}