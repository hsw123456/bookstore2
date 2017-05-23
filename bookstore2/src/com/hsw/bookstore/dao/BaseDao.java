package com.hsw.bookstore.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseDao<T> {
	
	//添加
	void save(T t);
	//删除
	void delete(T t);
	//修改
	void update(T t);
	//查询所有
	List<T> getAll();
	//通过id 查询
	T getById(Long id);
	

}
