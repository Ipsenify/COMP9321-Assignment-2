package edu.unsw.comp9321.assign2.logic;

import java.util.ArrayList;
import java.util.List;

public class SearchResult <T> {

	private List<T> resultSet;
	private String query;
	private String category;
	private int page;

	private static final int size = 5;

	public SearchResult(String query, String category, Integer page) {
		this.query = query;
		this.page = page;
		this.category = category;
		this.resultSet = new ArrayList<T>();
	}

	public List<T> getResultSet() {
		int start = page * size;
		int end = Math.min(this.resultSet.size(), start + size);
		return this.resultSet.subList(start, end);
	}
	
	public void setResultSet(List<T> resultSet){
		this.resultSet = resultSet;
	}

	public Integer getPage() {
		return this.page;
	}

	public String getQuery() {
		return this.query;
	}

	public String getCategory(){
		return this.category;
	}
	
	public boolean hasNext() {
		return this.resultSet != null && this.resultSet.size() > size
				&& this.resultSet.size() > (page + 1) * size;
	}

	public boolean hasPrevious() {
		return this.resultSet != null && this.resultSet.size() > size && page > 0;
	}
	
	public boolean isEmpty(){
		return this.resultSet == null || this.resultSet.isEmpty();
	}

}
