package com.sofency.ssm.mapper;

import com.sofency.ssm.pojo.Institude;
import com.sofency.ssm.pojo.InstitudeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstitudeMapper {
    int countByExample(InstitudeExample example);

    int deleteByExample(InstitudeExample example);

    int deleteByPrimaryKey(Integer instid);

    int insert(Institude record);

    int insertSelective(Institude record);

    List<Institude> selectByExample(InstitudeExample example);

    Institude selectByPrimaryKey(Integer instid);

    int updateByExampleSelective(@Param("record") Institude record, @Param("example") InstitudeExample example);

    int updateByExample(@Param("record") Institude record, @Param("example") InstitudeExample example);

    int updateByPrimaryKeySelective(Institude record);

    int updateByPrimaryKey(Institude record);
}