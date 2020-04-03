package com.sofency.ssm.service.impl;

import com.sofency.ssm.mapper.GetFameMapper;
import com.sofency.ssm.pojo.GetFame;
import com.sofency.ssm.pojo.GetFameExample;
import com.sofency.ssm.service.interfaces.GetFameService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * @author sofency
 * @date 2020/3/31 11:14
 * @package IntelliJ IDEA
 * @description
 */
public class GetFameServiceImpl implements GetFameService {
    private GetFameMapper getFameMapper;
    @Autowired
    public GetFameServiceImpl(GetFameMapper getFameMapper) {
        this.getFameMapper = getFameMapper;
    }
    @Override
    public int insert(GetFame getFame) {
        try {
            getFameMapper.insert(getFame);
            return 1;//成功
        }catch (Exception e){
            e.printStackTrace();
            return 0;//失败
        }
    }

    @Override
    public List<GetFame> getFame(GetFame getFame) {
        GetFameExample example = new GetFameExample();
        example.createCriteria().andEngineerIdEqualTo(getFame.getEngineerId())
        .andFameIdEqualTo(getFame.getFameId());
        return getFameMapper.selectByExample(example);
    }
}
