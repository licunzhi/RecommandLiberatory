package com.caoguimei.service.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Books;
import com.caoguimei.service.BaseService;

/**
 * 抽象的baseService,专门用于继承
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> dao ;
	
	private Class<T> clazz ;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	//注入dao
	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		dao.batchEntityByHQL(hql, objects);
	}

	public T loadEntity(Integer id) {
		return dao.loadEntity(id);
	}

	public T getEntity(Integer id) {
		return dao.getEntity(id);
	}


	public List<T> findEntityByHQL(String hql, Object... objects) {
		return dao.findEntityByHQL(hql, objects);
	}
	
	//查询所有实体
	public List<T> findAllEntities(){
		String hql = "from " + clazz.getSimpleName() ;
		return this.findEntityByHQL(hql);
	}
	
	//单值检索,确保查询结果有且只有一条记录
	public Object uniqueResult(String hql,Object...objects){
		return dao.uniqueResult(hql, objects);
	}
	//实现查询指定页数指定显示数量的代码段
	public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults){
		return dao.findPagesEntityByHql(clazz, lable,lablevalue, firstResult, maxResults);
	}
}
