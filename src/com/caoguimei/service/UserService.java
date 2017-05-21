package com.caoguimei.service;

import com.caoguimei.model.User;

public interface UserService extends BaseService<User>{

	/**
	 * 判断学号 邮箱 是否已经被注册
	 */
	boolean isRegisted(String studentid,String email);
	
	/**
	 * 判断输入的学号是不是全部是数字
	 */
	boolean isNumber(String studentid);

}
