package com.caoguimei.service;

import com.caoguimei.model.User;

public interface UserService extends BaseService<User>{

	/**
	 * �ж�ѧ�� ���� �Ƿ��Ѿ���ע��
	 */
	boolean isRegisted(String studentid,String email);
	
	/**
	 * �ж������ѧ���ǲ���ȫ��������
	 */
	boolean isNumber(String studentid);

}
