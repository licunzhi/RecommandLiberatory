package com.caoguimei.model;

import java.util.HashSet;
import java.util.Set;

public class User  extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String studentid;
	private String username;
	private String sex;
	private String password;
	//רҵ
	private String major;
	private String email;
	//���ڴ洢���Ա�ǩ
	private String interest;
	
	
	

	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getInterest() {
		return interest;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	

}
