package com.caoguimei.dao.impl;

import org.springframework.stereotype.Repository;

import com.caoguimei.model.User;

@Repository("userDao")//标注的是数据访问的组件 就是数据库操作中的dao文件
public class UserDaoImpl extends BaseDaoImpl<User>{
	
}
