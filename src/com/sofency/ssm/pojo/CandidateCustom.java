package com.sofency.ssm.pojo;

import java.util.ArrayList;

//一个页面里面的内容
public class CandidateCustom {
	private int currentPage;//当前页
	private int pageSize;
	private int totalCount;
	private ArrayList<Candidate> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public ArrayList<Candidate> getList() {
		return list;
	}
	public void setList(ArrayList<Candidate> list) {
		this.list = list;
	}
	
	public CandidateCustom() {
		super();
	}
	public CandidateCustom(int currentPage, int pageSize, int totalCount, ArrayList<Candidate> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}
	@Override
	public String toString() {
		return "CandidateCustom [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", list=" + list + "]";
	}

}
