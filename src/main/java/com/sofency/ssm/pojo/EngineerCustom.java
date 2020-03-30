package com.sofency.ssm.pojo;

import java.util.Date;

public class EngineerCustom extends  Engineer{
	 private Date getTime;//获取的时间
	 private String fameName;//荣誉的名字
	 private Integer fameLevel;//荣誉的级别
	 private String instName;//学院
	 private String majorName;//专业

	public Date getGetTime() {
		return getTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}

	public String getFameName() {
		return fameName;
	}

	public void setFameName(String fameName) {
		this.fameName = fameName;
	}

	public Integer getFameLevel() {
		return fameLevel;
	}

	public void setFameLevel(Integer fameLevel) {
		this.fameLevel = fameLevel;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
}
