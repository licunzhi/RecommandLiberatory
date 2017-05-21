package com.caoguimei.service;

import com.caoguimei.model.Books;

public interface BooksService extends BaseService<Books>{
	/**
	 * �ж�������鿯���ǲ���ȫ����������
	 */
	boolean isNumber(String bookid);
	/**
	 * �ж��鼮����Ϣ�Ƿ��Ѿ�¼��
	 */
	boolean isExit(String bookid); 
	/**
	 * �õ������������鼮�ĸ���
	 */
	public int getBooksNumber(String bookkind);
	/**
	 * �õ��鼮��ҳ��
	 */
	public int getBooksPageNumber(String bookkind , int maxResults);
	
}
