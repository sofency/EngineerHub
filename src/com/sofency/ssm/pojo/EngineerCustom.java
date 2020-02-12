package com.sofency.ssm.pojo;

import java.util.Date;

public class EngineerCustom extends  Engineer{
	 private Date getTime;//获取的时间
	 private String fameName;//荣誉的名字
	 private Integer fameLevel;//荣誉的级别
	 private String instname;//学院
	 private String majorname;//专业
	 
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
