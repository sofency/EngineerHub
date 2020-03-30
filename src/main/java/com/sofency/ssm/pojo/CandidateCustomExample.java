package com.sofency.ssm.pojo;

import java.io.Serializable;

public class CandidateCustomExample extends Candidate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//院系
	private String instName;
	//专业
	private String majorName;

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
