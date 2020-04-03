package com.sofency.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class FameCustom extends Fame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String engineerName;//工作人员姓名
	private Integer engineerId;//荣誉人的id
	@DateTimeFormat(pattern = "yyyy-MM-dd")  //解决对于前端传送date类型数据报400的解决方案
	private Date getTime;//获取时间
	public FameCustom() {
	}

	public Integer getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(Integer engineerId) {
		this.engineerId = engineerId;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}


	public Date getGetTime() {
		return getTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
}
