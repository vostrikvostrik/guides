package com.vostrik.db.dao.impl;

import com.vostrik.db.beans.entity.Member;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.db.dao.SecurityDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 9:40
 */
@Repository
public class SecurityDaoImpl implements SecurityDao {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BaseDao baseDao;

    @Override
    public User getUserByLogin(String userName) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(User.class);
        detchCriteria.add(Restrictions.eq("userName", userName));
        List<User> resultList =  baseDao.findByCriteria(detchCriteria);
        return resultList.size() > 0 ? (User) resultList.get(0) : null;
    }


    @Override
    public Member getMemberByLogin(String memberLogin) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Member.class);
        detchCriteria.add(Restrictions.eq("memberLogin", memberLogin));
        List<Member> resultList =  baseDao.findByCriteria(detchCriteria);
        return resultList.size() > 0 ? (Member) resultList.get(0) : null;

    }
}
