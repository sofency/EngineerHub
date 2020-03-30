package com.sofency.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class FameCustom extends Fame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String engineerName;//工作人员姓名
	private Date gettime;//获取时间
	
	public Date getGettime() {
	    return gettime;
	}
	
	public void setGettime(Date gettime) {
        this.gettime = gettime;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	
	

}
