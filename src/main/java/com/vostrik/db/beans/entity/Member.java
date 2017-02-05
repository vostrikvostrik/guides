package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * Created by EVostrikova on 10.07.15.
 */
@Entity
@Table(name="VOSTRIK_MEMBER")
public class Member {

        @Id
        @Column(name = "MEMBER_ID")
        @GeneratedValue
        private Long memberId;

        @Column(name = "MEMBER_NAME")
        private String memberName;

        @Column(name = "MEMBER_LOGIN")
        private String memberLogin;

        @Column(name = "MEMBER_PASSWORD")
        private String memberPassword;

        @Column(name = "MEMBER_EMAIL")
        private String memberEmail;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLogin() {
        return memberLogin;
    }

    public void setMemberLogin(String memberLogin) {
        this.memberLogin = memberLogin;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
}
