package com.vostrik.db.dao.impl;

import com.vostrik.db.beans.entity.User;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.db.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * User: User
 * Date: 07.01.17
 * Time: 14:14
 */
@Repository
public class UserDaoImpl implements UserDao {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private BaseDao baseDao;


    @Override
    public User createUser(User user) {

        return baseDao.save(user);
    }

    @Override
    public User readUser(long userId) {
        return baseDao.loadById(User.class, userId);
    }

    @Override
    public User updateUser(long userId, User user) {
        return  baseDao.save(user);
    }

    @Override
    public Long deleteUser(Long userId) {

        String hql = "delete from User where userId= :userId";
        em.unwrap(Session.class).createQuery(hql).setBigDecimal("userId", new BigDecimal(userId)).executeUpdate();

        baseDao.delete(User.class, userId);
        return userId;
    }

    @Override
    public List<User> getClientList() {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(User.class);
        detchCriteria.add(Restrictions.eq("userIsClient", 1));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<User> getGuideList() {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(User.class);
        detchCriteria.add(Restrictions.eq("userIsGuide", 1));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<User> getUserList() {
        return baseDao.getList(User.class);
    }

}
