package com.caoguimei.entity;

import java.util.List;

import com.caoguimei.model.Books;

public class BooksLimit {
	private String lable;
	private String lablevalue;
	private List<Books> books;
	
	public BooksLimit() {
		// TODO Auto-generated constructor stub
	}
	public BooksLimit(String lable, String lablevalue, List<Books> books) {
		super();
		this.lable = lable;
		this.lablevalue = lablevalue;
		this.books = books;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getLablevalue() {
		return lablevalue;
	}
	public void setLablevalue(String lablevalue) {
		this.lablevalue = lablevalue;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "BooksLimit [lable=" + lable + ", lablevalue=" + lablevalue + ", books=" + books + "]";
	}
	
	
}
