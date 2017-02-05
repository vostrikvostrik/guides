package com.vostrik.db.dao.impl;

import com.vostrik.db.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

/**
 * User: User
 * Date: 03.12.16
 * Time: 20:14
 */
@Repository("BaseDao")
public class BaseDaoImpl implements BaseDao {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected DataSource dataSource;

    @PersistenceContext
    private EntityManager em;

    @Override
    public <T> List<T> getList(Class<T> clazz) {
        if (clazz.isAnnotationPresent(Entity.class)) {
            return em.createQuery("Select a from " + clazz.getSimpleName() + " a", clazz).getResultList();
        }
        return null;
    }

    @Override
    public <T> T loadById(Class<T> clazz, Serializable id) {
        if (clazz.isAnnotationPresent(Entity.class)) {
            return em.find(clazz, id);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List findByCriteria(DetachedCriteria criteria) {
        Session session = em.unwrap(Session.class);
        return criteria.getExecutableCriteria(session).list();
    }

    @Override
    @Transactional
    public <T> T save(T obj) {
        if (obj.getClass().isAnnotationPresent(Entity.class)) {
            em.unwrap(Session.class).saveOrUpdate(obj);
        }
        return obj;
    }

    @Override
    @Transactional
    public void delete(Object obj) {
        if (obj!=null && obj.getClass().isAnnotationPresent(Entity.class)) {
            //  em.remove(obj);
            if (em.contains(obj))
                em.unwrap(Session.class).delete(obj);
        }
    }

    @Override
    @Transactional
    public void delete(Class<?> clazz, Long id) {
        if (clazz.isAnnotationPresent(Entity.class)) {
            Object obj = loadById(clazz, id);
            logger.warn("BaseDao Delete obj = " + obj);
            if (em.contains(obj))
                em.unwrap(Session.class).delete(obj);
        }
    }

    @Override
    @Transactional
    public boolean exists(Class clazz, Object key) {
        try {
            return em.getReference(Entity.class, key) != null;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }

}
