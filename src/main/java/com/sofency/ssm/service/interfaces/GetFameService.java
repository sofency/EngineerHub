package com.sofency.ssm.service.interfaces;

import com.sofency.ssm.pojo.GetFame;

import java.util.List;

/**
 * @author sofency
 * @date 2020/3/31 11:13
 * @package IntelliJ IDEA
 * @description
 */
public interface GetFameService {
    int insert(GetFame getFame);

    List<GetFame> getFame(GetFame getFame);
}
