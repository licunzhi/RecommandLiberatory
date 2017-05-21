package com.caoguimei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Bugs;
import com.caoguimei.service.BugsService;

@Service("bugsService")
public class BugsServiceImpl extends BaseServiceImpl<Bugs> implements BugsService{
	
	/**
	 * ��д�÷���,Ŀ����Ϊ�˸��ǳ����и÷�����ע��,ָ��ע��ָ����Dao����,����spring
	 * �޷�ȷ��ע���ĸ�Dao---���ĸ�����������Dao.
	 */
	@Resource(name="bugsDao")
	public void setDao(BaseDao<Bugs> dao) {
		super.setDao(dao);
	}

	

}
