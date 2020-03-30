package com.sofency.ssm.pojo;

import java.io.Serializable;

public class EngineersSomeInfo implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String engineerName;

   private String engineerImgPath;
   
   private String majorName;
   
   private String engineerMotto;
   
   private String engineerEmail;
   
   private String engineerGit;

	public String getEngineerName() {
		return engineerName;
	}
	
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	
	public String getEngineerImgPath() {
		return engineerImgPath;
	}
	
	public void setEngineerImgPath(String engineerImgpath) {
		this.engineerImgPath = engineerImgpath;
	}
	
	public String getMajorName() {
		return majorName;
	}
	
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	public String getEngineerMotto() {
		return engineerMotto;
	}
	
	public void setEngineerMotto(String engineerMotto) {
		this.engineerMotto = engineerMotto;
	}
	
	public String getEngineerEmail() {
		return engineerEmail;
	}
	
	public void setEngineerEmail(String engineerEmail) {
		this.engineerEmail = engineerEmail;
	}
	
	public String getEngineerGit() {
		return engineerGit;
	}
	
	public void setEngineerGit(String engineerGit) {
		this.engineerGit = engineerGit;
	}

}
