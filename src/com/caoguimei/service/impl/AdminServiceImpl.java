package com.caoguimei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Admin;
import com.caoguimei.service.AdminService;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{
	/**
	 * 问题出现在注入操作dao的时候  使用的自动注入
	 * 如果在不做说明的情况之下 不知道注入的是哪一个dao
	 * 因此需要重写其中的方法  说明注入的操作方法的类	
	 */
	@Resource(name="adminDao")
	public void setDao(BaseDao<Admin> dao) {
		super.setDao(dao);
	}
}
