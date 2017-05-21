package com.caoguimei.dao;

import java.util.List;

import org.hibernate.Query;

import com.caoguimei.model.Books;

/**
 *  使用泛型的方式实现代码充分的复用性，主要是为了遵循代码书写中的耦合性
 *  也是非常重要的软件设计的规则
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDao<T> {
//写操作
	//保存
	public void saveEntity(T t);
	//保存或者更新
	public void saveOrUpdateEntity(T t); 
	//更新操作
	public void updateEntity(T t);
	//删除操作
	public void deleteEntity(T t);
	//批量操作的实现
	public void batchEntityByHQL(String hql,Object ... objects);
//	读操作
	//load操作
	public T loadEntity(Integer id);
	//get操作
	public T getEntity(Integer id);
	//得到批量的数据 
	public List<T> findEntityByHQL(String hql,Object ... objects);
//	特殊的操作
	    //单值检索,确保查询结果有且只有一条记录
		public Object uniqueResult(String hql,Object...objects);
		//实现查询指定页数指定显示数量的代码段
		public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults);

}
