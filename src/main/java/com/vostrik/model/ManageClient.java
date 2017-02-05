package com.vostrik.model;

/**
 * User: User
 * Date: 20.03.16
 * Time: 10:15
 */
public class ManageClient {

    private String clientName;
    private String clientDescribe;
    private String clientCity;
    private String clientCountry;
    private String emailNotify;
    private String emailValidate;
    private String password;
    private String repeatPassword;
    private Integer isClient;
    private Integer isGuide;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDescribe() {
        return clientDescribe;
    }

    public void setClientDescribe(String clientDescribe) {
        this.clientDescribe = clientDescribe;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getEmailNotify() {
        return emailNotify;
    }

    public void setEmailNotify(String emailNotify) {
        this.emailNotify = emailNotify;
    }

    public String getEmailValidate() {
        return emailValidate;
    }

    public void setEmailValidate(String emailValidate) {
        this.emailValidate = emailValidate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Integer getIsClient() {
        return isClient;
    }

    public void setIsClient(Integer client) {
        isClient = client;
    }

    public Integer getIsGuide() {
        return isGuide;
    }

    public void setIsGuide(Integer guide) {
        isGuide = guide;
    }
}
