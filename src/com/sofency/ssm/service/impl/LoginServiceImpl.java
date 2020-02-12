package com.sofency.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sofency.ssm.mapper.ManagerCustomMapper;
import com.sofency.ssm.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private ManagerCustomMapper managerCustomMapper;
	//获得密码
	@Override
	public String getPassword(String username) {
		String password = managerCustomMapper.getPassword(username);
		return password;
	}

}
