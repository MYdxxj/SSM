package com.web.model;


import java.util.Date;

/**
 * @program:product
 * @description:
 * @author:YangXiaoJiao
 * @create:2019-01-15 11:11
 **/
public class User {
    private static final long serialVersionUID = 1L;

    /**用户ID*/
    private Long userId;
    /**用户名*/
    private String userAge;
    /**密码*/
    private String userSex;
    /**姓名*/
    private String userPhone;
    private String loginName;
    private String password;
    private Date userBirthday;
    private Date createTime;
    private String userName;
    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAge='" + userAge + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userBirthday=" + userBirthday +
                ", createTime=" + createTime +
                ", userName='" + userName + '\'' +
                '}';
    }

    public User(Long userId, String userAge, String userSex, String userPhone, String loginName, String password, Date userBirthday, Date createTime, String userName) {
        this.userId = userId;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.loginName = loginName;
        this.password = password;
        this.userBirthday = userBirthday;
        this.createTime = createTime;
        this.userName = userName;
    }
}
