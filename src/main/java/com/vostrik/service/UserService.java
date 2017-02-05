package com.vostrik.service;

import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.entity.UserType;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by EVostrikova on 10.07.15.
 */
public interface UserService {

    User getUserByUserName(String userName);

    UserDetails loadUserByUsername(String username);

    List<UserType> getUserTypeList();




    //-------------CRUD for User
    User createUser(User user);//create
    User readUser(long userId);//read
    User updateUser(long userId, User user); //update
    Long deleteUser(long userId); //delete
    List<User> getClientList(); //get list
    List<User> getGuideList(); //get list
    List<User> getUserList();
}
