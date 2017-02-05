package com.vostrik.db.beans.entity;


import com.vostrik.db.dao.FieldMatch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by EVostrikova on 10.07.15.
 */
@Entity
@Table(name="VOSTRIK_USER")
@FieldMatch.List({
        @FieldMatch(first = "userPassword", second = "confirmPassword", message = "The password fields must match")/*,
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")*/
})
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue
    private Long userId;

    @Column(name = "USER_NAME")
    @NotNull
    @Size(min = 6, message="Login length must be great than 6")
    private String userName;

    @Column(name = "user_country")
    private String userCountry;

    @Column(name = "user_city")
    private String userCity;

    @Column(name = "USER_EMAIL")
    @NotNull
    @Email
    @NotBlank(message="E-mail must be completed")
    private String userEmail;

    @Column(name = "USER_GROUP_ID")
    private Integer userGroupId;

    @Column(name = "USER_PASSWORD")
    @NotNull(message="Password must be completed")
    @Size(min = 6, message="Password length must be great than 6")
    @NotBlank(message="Password must be completed")
    private String userPassword;

    @Transient
    @NotBlank(message="Password must be completed")
    private String confirmPassword;

    @Column(name = "USER_DESCRIBE")
    private String userDescribe;

    @Column(name = "user_vk_id")
    private String userVkId;

    @Column(name = "user_fb_id")
    private String userFbId;

    @Column(name = "user_client_state")
    private String userClientState;

    @Column(name = "user_guide_state")
    private String userGuideState;


    @Column(name = "user_is_guide")
    private Integer userIsGuide;

    @Column(name = "user_is_client")
    private Integer userIsClient;

    @Column(name = "user_public_name")
    private String userPublicName;

    @Transient
    Map<String, String> errors;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public Integer getUserIsGuide() {
        return userIsGuide;
    }

    public void setUserIsGuide(Integer userIsGuide) {
        this.userIsGuide = userIsGuide;
    }

    public Integer getUserIsClient() {
        return userIsClient;
    }

    public void setUserIsClient(Integer userIsClient) {
        this.userIsClient = userIsClient;
    }

    public String getUserPublicName() {
        return userPublicName;
    }

    public void setUserPublicName(String userPublicName) {
        this.userPublicName = userPublicName;
    }

    public User()
    {
        super();
    }

    public User(Long userId, String userName,String userDescribe)
    {
        this.userId = userId;
        this.userName = userName;
        this.userDescribe = userDescribe;
    }

    public User(int userId, String userName, String userCountry, String userCity, String userEmail, Integer userGroupId, String userPassword, String userDescribe, String userVkId, String userFbId, String userClientState, String userGuideState) {
        this.userId = new Long(userId);
        this.userName = userName;
        this.userCountry = userCountry;
        this.userCity = userCity;
        this.userEmail = userEmail;
        this.userGroupId = userGroupId;
        this.userPassword = userPassword;
        this.userDescribe = userDescribe;
        this.userVkId = userVkId;
        this.userFbId = userFbId;
        this.userClientState = userClientState;
        this.userGuideState = userGuideState;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }

    public String getUserVkId() {
        return userVkId;
    }

    public void setUserVkId(String userVkId) {
        this.userVkId = userVkId;
    }

    public String getUserFbId() {
        return userFbId;
    }

    public void setUserFbId(String userFbId) {
        this.userFbId = userFbId;
    }

    public String getUserClientState() {
        return userClientState;
    }

    public void setUserClientState(String userClientState) {
        this.userClientState = userClientState;
    }

    public String getUserGuideState() {
        return userGuideState;
    }

    public void setUserGuideState(String userGuideState) {
        this.userGuideState = userGuideState;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCountry='" + userCountry + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGroupId=" + userGroupId +
                ", userPassword='" + userPassword + '\'' +
                ", userDescribe='" + userDescribe + '\'' +
                ", userVkId='" + userVkId + '\'' +
                ", userFbId='" + userFbId + '\'' +
                ", userClientState='" + userClientState + '\'' +
                ", userGuideState='" + userGuideState + '\'' +
                ", userIsGuide=" + userIsGuide +
                ", userIsClient=" + userIsClient +
                ", userPublicName='" + userPublicName + '\'' +
                '}';
    }
}
