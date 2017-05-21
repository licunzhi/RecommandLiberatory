package com.caoguimei.service;

import java.util.List;

import org.hibernate.Query;

import com.caoguimei.model.Books;

/**
 * 基本的dao接口 封装dao中的方法
 * @author LiCunzhi
 *
 * @param <T>
 */
public interface BaseService<T> {
//	写操作
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object ... objects);
	
//	写操作
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntityByHQL(String hql,Object ... objects);
//	单值检索查询
	public Object uniqueResult(String hql,Object ... objects);
// 查询所有实体
	public List<T> findAllEntities();
	//实现查询指定页数指定显示数量的代码段
	public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults);
}
