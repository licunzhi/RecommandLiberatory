package com.caoguimei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Bugs;
import com.caoguimei.service.BugsService;

@Service("bugsService")
public class BugsServiceImpl extends BaseServiceImpl<Bugs> implements BugsService{
	
	/**
	 * 重写该方法,目的是为了覆盖超类中该方法的注解,指明注入指定的Dao对象,否则spring
	 * 无法确定注入哪个Dao---有四个满足条件的Dao.
	 */
	@Resource(name="bugsDao")
	public void setDao(BaseDao<Bugs> dao) {
		super.setDao(dao);
	}

	

}
