package com.caoguimei.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.Books;
/**
 * ����һ��������� ר�����ڼ̳и��ֲ�������
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T>{

	//��Ҫע��sessionfactory   Ȼ��������ȵõ�session ʹ��hibernate���Դ��ķ���
	@Resource
	private SessionFactory factory;
	
	//���ͳ�ʼ���ľ��廯   ���������ڹ������г�ʼ��
	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>)type.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void saveEntity(T t) {
		factory.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		factory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void updateEntity(T t) {
		factory.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t) {
		factory.getCurrentSession().delete(t);
	}
	

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		Query q= factory.getCurrentSession().createQuery(hql);
		for(int i = 0; i < objects.length; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
		
	}

	@Override
	public T loadEntity(Integer id) {
		
		return (T) factory.getCurrentSession().load(clazz, id);
	}

	@Override
	public T getEntity(Integer id) {
		return (T) factory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		Query q = factory.getCurrentSession().createQuery(hql);
		for(int i = 0; i < objects.length;i++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	
	
	public Object uniqueResult(String hql,Object...objects){
		Query q= factory.getCurrentSession().createQuery(hql);
		for(int i = 0;i < objects.length;i++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}

	//ʵ�ֲ�ѯָ��ҳ��ָ����ʾ�����Ĵ����
	public List<T> findPagesEntityByHql(String clazz,String lable,String lablevalue,int firstResult,int maxResults){
		String hql = "From " + clazz + " cl where cl." + lable + " = " + "'" + lablevalue + "'";
		List<T> t = factory.getCurrentSession().createQuery(hql)
										.setFirstResult(firstResult)
										.setMaxResults(maxResults).list();
		
		return t;
	}
}
