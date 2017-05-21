package com.caoguimei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.ViewHistory;
import com.caoguimei.service.ViewHistoryService;

@Service("viewHistoryService")
public class ViewHistoryServiceImpl extends BaseServiceImpl<ViewHistory> implements ViewHistoryService{
	
	/**
	 * ��д�÷���,Ŀ����Ϊ�˸��ǳ����и÷�����ע��,ָ��ע��ָ����Dao����,����spring
	 * �޷�ȷ��ע���ĸ�Dao---���ĸ�����������Dao.
	 */
	@Resource(name="viewHistoryDao")
	public void setDao(BaseDao<ViewHistory> dao) {
		super.setDao(dao);
	}

	

}
