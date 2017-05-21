package com.caoguimei.service;

import com.caoguimei.model.Books;

public interface BooksService extends BaseService<Books>{
	/**
	 * 判断输入的书刊号是不是全部都是数字
	 */
	boolean isNumber(String bookid);
	/**
	 * 判断书籍的信息是否已经录入
	 */
	boolean isExit(String bookid); 
	/**
	 * 得到满足条件的书籍的个数
	 */
	public int getBooksNumber(String bookkind);
	/**
	 * 得到书籍的页数
	 */
	public int getBooksPageNumber(String bookkind , int maxResults);
	
}
