package com.joizhang.mylibrary.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T extends Serializable, PK extends Serializable> {

	/**
	 * 根据主键获取实体。如果没有相应的实体，返回 null
	 * @param id 主键
	 * */
	public T get(PK id);

	/**
	 * 根据主键获取实体。如果没有相应的实体，抛出异常
	 * @param id 主键
	 * */
	public T load(PK id);

	public T get(Class<T> c, Serializable id);

	public T get(String hql, Object[] param);

	public T get(String hql, List<Object> param);

	public Serializable save(T o);

	public void delete(T o);

	/**
	 * 根据主键删除指定实体
	 * @param id 主键
	 * */
	public void deleteByKey(PK id);

	public void update(T o);

	public void saveOrUpdate(T o);

	public List<T> find(String hql);
	
	public List<T> findSQL(String hql, Class<T> T);
	
	public List<T> findSQL(String hql);

	public List<T> find(String hql, Object[] param);

	public List<T> find(String hql, List<Object> param);

	/**
	 * Hibernate分页
	 * @param hql hql语句
	 * @param param 查询条件
	 * @param page 当前页
	 * @param rows 当前页显示多少条数据
	 * */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	/**
	 * 算出总的页数（不带条件）
	 * @param hql hql语句
	 * @param pageSize 每页的记录数
	 * */
	public int countPage(String hql, int pageSize);
	
	/**
	 * 算出总的页数
	 * @author joizhang
	 * @param hql hql语句
	 * @param param 查询条件
	 * @param pageSize 每页的记录数
	 * */
	public int countPage(String hql, Object[] param, int pageSize);
	
	public Long count(String hql);

	public Long count(String hql, Object[] param);

	public Long count(String hql, List<Object> param);

	/**
	 * @return number of results
	 */
	public Integer executeHql(String hql);

	public Integer executeHql(String hql, Object[] param);

	public Integer executeHql(String hql, List<Object> param);

}
