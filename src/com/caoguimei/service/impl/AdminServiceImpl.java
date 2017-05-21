package com.caoguimei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Admin;
import com.caoguimei.service.AdminService;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{
	/**
	 * ���������ע�����dao��ʱ��  ʹ�õ��Զ�ע��
	 * ����ڲ���˵�������֮�� ��֪��ע�������һ��dao
	 * �����Ҫ��д���еķ���  ˵��ע��Ĳ�����������	
	 */
	@Resource(name="adminDao")
	public void setDao(BaseDao<Admin> dao) {
		super.setDao(dao);
	}
}
