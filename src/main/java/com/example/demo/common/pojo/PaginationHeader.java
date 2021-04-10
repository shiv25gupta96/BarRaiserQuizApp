package com.example.demo.common.pojo;

public class PaginationHeader {

	private int pageNumber;
	private int limit;
	
	public PaginationHeader(int page, int limit) {
		this.pageNumber = page;
		this.limit = limit;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
	
}
