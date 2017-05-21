package com.caoguimei.service;

import java.util.List;

import org.hibernate.Query;

import com.caoguimei.model.Books;

/**
 * ������dao�ӿ� ��װdao�еķ���
 * @author LiCunzhi
 *
 * @param <T>
 */
public interface BaseService<T> {
//	д����
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object ... objects);
	
//	д����
	public T loadEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntityByHQL(String hql,Object ... objects);
//	��ֵ������ѯ
	public Object uniqueResult(String hql,Object ... objects);
// ��ѯ����ʵ��
	public List<T> findAllEntities();
	//ʵ�ֲ�ѯָ��ҳ��ָ����ʾ�����Ĵ����
	public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults);
}
