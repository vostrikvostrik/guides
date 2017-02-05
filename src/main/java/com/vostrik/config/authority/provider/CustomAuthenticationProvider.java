package com.vostrik.config.authority.provider;

import com.vostrik.db.beans.entity.User;
import com.vostrik.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
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
 * User: User
 * Date: 27.10.15
 * Time: 9:38
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user;
        user = userService.getUserByUserName(authentication.getName());
        logger.info("custom auth user name = " + authentication.getName());

        if (passwordEncoder.isPasswordValid(user.getUserPassword(), (String) authentication.getCredentials(), null) == false) {
            logger.error("Wrong password!");
            throw new BadCredentialsException("Wrong password!");
        }

        if (authentication.getName().equals(authentication.getCredentials())) {
            logger.error("Login and password r equals");
            throw new BadCredentialsException("Login equals password");
        } else {
            return new UsernamePasswordAuthenticationToken(/*authentication.getName()*/user, authentication.getCredentials(), getAuthorities(user.getUserId()));
        }
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

    public Collection<GrantedAuthority> getAuthorities(Long userId) {
        List<GrantedAuthority> authList = new ArrayList<>(5);
        // authList.add(() -> "ROLE_USER");
        authList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        authList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        return authList;
    }
}