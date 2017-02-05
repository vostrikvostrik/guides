package com.vostrik.config.authority;

import com.vostrik.db.beans.entity.User;
import com.vostrik.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  Created by EVostrikova on 20.10.15.
 */
@Component
public class TrackingAuthenticationManager implements AuthenticationManager {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user;
        try {
            user = userService.getUserByUserName(authentication.getName());
            logger.info("user name = "+authentication.getName());
        } catch (Exception e) {
            logger.error("Exception user doesn't exists");
            throw new BadCredentialsException("User doesn't exists");
        }

        if (  passwordEncoder.isPasswordValid(user.getUserPassword(), (String) authentication.getCredentials(), null) == false ) {
            logger.error("Wrong password!");
            throw new BadCredentialsException("Wrong password!");
        }

        if (authentication.getName().equals(authentication.getCredentials())) {
            logger.error("Login and password r equals");
            throw new BadCredentialsException("Login equals password");
        } else {
            return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), getAuthorities(user.getUserId()));
        }
    }

    public Collection<GrantedAuthority> getAuthorities(Long userId) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(5);

        authList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";  //To change body of implemented methods use File | Settings | File Templates.
            }
        })  ;
        return authList;
    }
}
