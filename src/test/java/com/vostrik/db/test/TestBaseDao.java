package com.vostrik.db.test;

import com.vostrik.AbstractTestCase;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.dao.BaseDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: User
 * Date: 10.01.17
 * Time: 19:22
 */
public class TestBaseDao extends AbstractTestCase {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BaseDao baseDao;

    @Test
    @Transactional
    public void testDelete() {

       User user = baseDao.loadById(User.class, 2L);
        baseDao.delete(user);
        baseDao.delete(User.class, 21L);
        User result1 = baseDao.loadById(User.class, 2L);
        User result2 = baseDao.loadById(User.class, 21L);

        assertNull(result1);
        assertNull(result2);

    }


}
