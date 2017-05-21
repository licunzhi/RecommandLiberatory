package com.caoguimei.model;

import java.util.Date;

public class Bugs extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String detial;
	private Date date;
	private String studentid;
	
	public Bugs() {
		// TODO Auto-generated constructor stub
	}
	public Bugs(String title, String detial, Date date, String studentid) {
		super();
		this.title = title;
		this.detial = detial;
		this.date = date;
		this.studentid = studentid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	

	@Override
	public String toString() {
		return "Bugs [id=" + id + ", title=" + title + ", detial=" + detial + ", date=" + date + ", studentid="
				+ studentid + "]";
	}
	

}
