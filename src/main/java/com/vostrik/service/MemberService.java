package com.vostrik.service;

import com.vostrik.db.beans.entity.Member;

/**
 * Created by EVostrikova on 10.07.15.
 */

public interface MemberService {
    Member getMemberByLogin(String memberLogin);
}
