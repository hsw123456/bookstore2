package com.hsw.bookstore.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.hsw.bookstore.dao.BaseDao;

/**
 * 注意这里baseDao不能由容器管理否则出错？？？？？？
 * @author Administrator
 *
 * @param <T>
 */
public  class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	private Class<T> clazz ;
	
	public BaseDaoImpl(){
		Type genType = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) genType;
		Type[] parameters = pt.getActualTypeArguments();
		clazz =  (Class<T>) parameters[0];
	}
	
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public List<T> getAll() {
		String hql = "FROM "+ clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public T getById(Long id) {
		String hql = "FROM " +clazz.getSimpleName()+ " m WHERE m.id=?";
		Query query = getSession().createQuery(hql)//
								  .setParameter(0, id);
		return (T) query.uniqueResult();
	}

}
