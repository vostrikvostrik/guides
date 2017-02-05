package com.vostrik.db.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;
/**
 * User: User
 * Date: 03.12.16
 * Time: 20:14
 */
public interface BaseDao {

    public <T>List<T> getList(Class<T> clazz);

    <T> T loadById(Class<T> clazz, Serializable id);

    public List findByCriteria(DetachedCriteria criteria);

    <T> T save(T obj);

    void delete(Object obj);

    void delete(Class<?> clazz, Long id);

    boolean exists(Class clazz, Object key);
}
