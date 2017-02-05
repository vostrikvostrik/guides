package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.entity.UserType;
import com.vostrik.db.dao.BaseOpersDao;
import com.vostrik.db.dao.SecurityDao;
import com.vostrik.db.dao.UserDao;
import com.vostrik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by EVostrikova on 10.07.15.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    @Autowired
    private BaseOpersDao baseOpersDao;

    @Autowired
    private SecurityDao securityDao;

    @Autowired
    private UserDao userDao;

    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return securityDao.getUserByLogin(userName);
    }

    @SuppressWarnings("deprecation")
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDao = securityDao.getUserByLogin(username);
        GrantedAuthority role_user = new GrantedAuthorityImpl("ROLE_USER");
        Collection<GrantedAuthority> reachable = new LinkedList<GrantedAuthority>(Arrays.asList(role_user));
        if (userDao == null) throw new UsernameNotFoundException("Пользователь и/или пароль неверен!");
        UserDetails user = new
                org.springframework.security.core.userdetails.User(userDao.getUserName(),
                userDao.getUserPassword(), true, true, true, true,
                reachable);

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserType> getUserTypeList() {
        return baseOpersDao.getUserTypeList();
    }

    @Override
    @Transactional(readOnly = false)
    public User createUser(User user) {
        passwordEncoder.encodePassword(user.getUserPassword(), null);
        return userDao.createUser(user);
    }


    @Override
    @Transactional(readOnly = true)
    public User readUser(long userId) {
        return userDao.readUser(userId);
    }

    @Override
    @Transactional(readOnly = false)
    public User updateUser(long userId, User user) {
        User oldUser = userDao.readUser(userId);
        oldUser.setUserName(user.getUserName());
        oldUser.setUserCountry(user.getUserCountry());
        oldUser.setUserCity(user.getUserCity());
        oldUser.setUserDescribe(user.getUserDescribe());
        oldUser.setUserPublicName(user.getUserPublicName());
        oldUser.setUserPassword(user.getUserPassword());
        return userDao.updateUser(userId, oldUser);
    }

    @Override
    @Transactional
    public Long deleteUser(long userId) {

        return userDao.deleteUser(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getClientList() {
        return userDao.getClientList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getGuideList() {
        return userDao.getGuideList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDao.getUserList();
    }

}
