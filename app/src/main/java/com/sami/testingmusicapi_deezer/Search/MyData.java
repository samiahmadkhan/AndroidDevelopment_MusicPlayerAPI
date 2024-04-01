package com.sami.testingmusicapi_deezer.Search;

import java.util.List;

public class MyData{
	private String next;
	private int total;
	private List<DataItem> data;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}
}