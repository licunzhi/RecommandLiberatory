package com.caoguimei.model;

/**
 * �鼮�����Ϣ����
 * @author Administrator
 *
 */
public class Books  extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bookid;
	private String bookname;
	private String bookauthor;
	private String bookkind;
	//ͼ�������id
	private String majorid;
	//�������
	private Long viewtimes;
	//�洢�鼮��Ϣ�ļ򵥽���
	private String booksinformation;
	
	
	
	
	
	public String getBooksinformation() {
		return booksinformation;
	}
	public void setBooksinformation(String booksinformation) {
		this.booksinformation = booksinformation;
	}
	public Long getViewtimes() {
		return viewtimes;
	}
	public void setViewtimes(Long viewtimes) {
		this.viewtimes = viewtimes;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}
	public String getMajorid() {
		return majorid;
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
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookkind() {
		return bookkind;
	}
	public void setBookkind(String bookkind) {
		this.bookkind = bookkind;
	}

	
	
	

}
