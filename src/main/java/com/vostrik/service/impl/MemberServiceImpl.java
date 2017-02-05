package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.Member;
import com.vostrik.db.dao.SecurityDao;
import com.vostrik.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by EVostrikova on 10.07.15.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SecurityDao securityDao;

    @Override
    @Transactional
    public Member getMemberByLogin(String memberLogin) {
        return securityDao.getMemberByLogin(memberLogin);
    }
}
