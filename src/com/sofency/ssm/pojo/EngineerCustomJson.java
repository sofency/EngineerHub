package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

//以页返回到前端
public class EngineerCustomJson {
	private int pages;//记录的总页数
	private int currentPage;//当前的页数
	private ArrayList<Engineer> list;//工作人员
	private List<Institude> Institude;//院系数
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<Engineer> getList() {
		return list;
	}
	public void setList(ArrayList<Engineer> list) {
		this.list = list;
	}
	
	public List<Institude> getInstitude() {
		return Institude;
	}
	public void setInstitude(List<Institude> institude) {
		Institude = institude;
	}
	public EngineerCustomJson() {
		super();
	}
	
	public EngineerCustomJson(int pages, int currentPage, ArrayList<Engineer> list,
			List<com.sofency.ssm.pojo.Institude> institude) {
		super();
		this.pages = pages;
		this.currentPage = currentPage;
		this.list = list;
		Institude = institude;
	}
}
