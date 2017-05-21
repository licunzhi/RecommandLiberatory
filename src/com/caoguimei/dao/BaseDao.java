package com.caoguimei.dao;

import java.util.List;

import org.hibernate.Query;

import com.caoguimei.model.Books;

/**
 *  ʹ�÷��͵ķ�ʽʵ�ִ����ֵĸ����ԣ���Ҫ��Ϊ����ѭ������д�е������
 *  Ҳ�Ƿǳ���Ҫ�������ƵĹ���
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDao<T> {
//д����
	//����
	public void saveEntity(T t);
	//������߸���
	public void saveOrUpdateEntity(T t); 
	//���²���
	public void updateEntity(T t);
	//ɾ������
	public void deleteEntity(T t);
	//����������ʵ��
	public void batchEntityByHQL(String hql,Object ... objects);
//	������
	//load����
	public T loadEntity(Integer id);
	//get����
	public T getEntity(Integer id);
	//�õ����������� 
	public List<T> findEntityByHQL(String hql,Object ... objects);
//	����Ĳ���
	    //��ֵ����,ȷ����ѯ�������ֻ��һ����¼
		public Object uniqueResult(String hql,Object...objects);
		//ʵ�ֲ�ѯָ��ҳ��ָ����ʾ�����Ĵ����
		public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults);

}
