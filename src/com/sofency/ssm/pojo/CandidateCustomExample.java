package com.sofency.ssm.pojo;

import java.io.Serializable;

public class CandidateCustomExample extends Candidate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//院系
	private String instname;
	//专业
	private String majorname;
	public String getInstname() {
		return instname;
	}
	public void setInstname(String instname) {
		this.instname = instname;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	
	

}
