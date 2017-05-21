package com.caoguimei.entity;

import java.util.List;

import com.caoguimei.model.Books;

/**
 * 为了查询分页  专门设计了这么一个类
 * @author LiCunzhi
 *
 */
public class BooksPages {
	private int pageNo;
	private int currentPage;
	private List<Books> books;
	
	
	public BooksPages() {
		// TODO Auto-generated constructor stub
	}


	public BooksPages(int pageNo, int currentPage, List<Books> books) {
		super();
		this.pageNo = pageNo;
		this.currentPage = currentPage;
		this.books = books;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "BooksPages [pageNo=" + pageNo + ", currentPage=" + currentPage + ", books=" + books + "]";
	}
	
	

}
