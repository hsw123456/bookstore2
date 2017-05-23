package com.hsw.bookstore.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseDao<T> {
	
	//���
	void save(T t);
	//ɾ��
	void delete(T t);
	//�޸�
	void update(T t);
	//��ѯ����
	List<T> getAll();
	//ͨ��id ��ѯ
	T getById(Long id);
	

}
