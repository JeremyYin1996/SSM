package com.sqc.utils;

import java.util.List;

public class PageUtil<T> {
	private int thisPage;
	private int allPage;
	private int thisRow;
	private int allRow;
	private int beginRow;
	private List<T> list;
	
	public PageUtil() {
	}
	
	public PageUtil(int thisPage,int thisRow){
		this.thisPage = thisPage;
		this.thisRow = thisRow;
		if(this.thisPage!=0){
			this.beginRow = thisPage*thisRow-thisRow;
		}
	}

	public PageUtil(int thisPage, int thisRow, int allRow) {
		this.thisPage = thisPage;
		this.thisRow = thisRow;
		this.allRow = allRow;
		if(this.thisPage!=0){
			this.beginRow = thisPage*thisRow-thisRow;
		}
		if(this.thisRow!=0){
			this.allPage = allRow/this.thisRow+1;
		}
	}

	public int getThisPage() {
		return thisPage;
	}

	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}

	public int getThisRow() {
		return thisRow;
	}

	public void setThisRow(int thisRow) {
		this.thisRow = thisRow;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
		if(this.thisRow!=0){
			this.allPage = allRow/this.thisRow+1;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	@Override
	public String toString() {
		return "PageUtil [thisPage=" + thisPage + ", allPage=" + allPage + ", thisRow=" + thisRow + ", allRow=" + allRow
				+ ", list=" + list + "]";
	}



	
}
