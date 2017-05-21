package com.caoguimei.model;

import java.util.Date;

public class ViewHistory extends BaseEntity{
	private Integer id;
	private String bookid;
	private Date date;
	private String studentid;
	private String bookname;
	
	public ViewHistory() {
		// TODO Auto-generated constructor stub
	}
	
	public ViewHistory(Integer id, String bookid, Date date) {
		super();
		this.id = id;
		this.bookid = bookid;
		this.date = date;
	}

	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
