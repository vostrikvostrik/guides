package com.vostrik.db.dao;

import com.vostrik.db.beans.entity.User;

import java.util.List;

/**
 * User: User
 * Date: 07.01.17
 * Time: 14:12
 */
public interface UserDao {

    //-------------CRUD for User
    User createUser(User user);//create
    User readUser(long userId);//read
    User updateUser(long userId, User user); //update
    Long deleteUser(Long userId); //delete
    List<User> getClientList(); //get list
    List<User> getGuideList(); //get list
    List<User> getUserList(); //get list
}
