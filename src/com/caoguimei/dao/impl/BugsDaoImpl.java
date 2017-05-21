package com.caoguimei.dao.impl;

import org.springframework.stereotype.Repository;

import com.caoguimei.model.Bugs;

@Repository("bugsDao")//标注的是数据访问的组件 就是数据库操作中的dao文件
public class BugsDaoImpl extends BaseDaoImpl<Bugs>{
	
}
