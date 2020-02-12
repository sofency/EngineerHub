package com.sofency.ssm.mapper;

import com.sofency.ssm.pojo.Candidate;
import com.sofency.ssm.pojo.CandidateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CandidateMapper {
    int countByExample(CandidateExample example);

    int deleteByExample(CandidateExample example);

    int deleteByPrimaryKey(Integer candidateId);

    int insert(Candidate record);

    int insertSelective(Candidate record);

    List<Candidate> selectByExample(CandidateExample example);

    Candidate selectByPrimaryKey(Integer candidateId);

    int updateByExampleSelective(@Param("record") Candidate record, @Param("example") CandidateExample example);

    int updateByExample(@Param("record") Candidate record, @Param("example") CandidateExample example);

    int updateByPrimaryKeySelective(Candidate record);

    int updateByPrimaryKey(Candidate record);
}