package com.vostrik.db.dao;

import com.vostrik.db.beans.entity.Member;
import com.vostrik.db.beans.entity.User;

/**
 * User: User
 * Date: 25.10.15
 * Time: 9:41
 */
public interface SecurityDao {

    User getUserByLogin(String userName);

    Member getMemberByLogin(String memberLogin);
}
