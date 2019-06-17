package com.web.model;

public class UserMsg {
    private Integer userMsgId;

    private String userId;

    private String userAge;

    private String userSex;

    private String userEmail;

    private String userPhone;

    private String userAddr;

    private String userProHobby;

    public Integer getUserMsgId() {
        return userMsgId;
    }

    public void setUserMsgId(Integer userMsgId) {
        this.userMsgId = userMsgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr == null ? null : userAddr.trim();
    }

    public String getUserProHobby() {
        return userProHobby;
    }

    public void setUserProHobby(String userProHobby) {
        this.userProHobby = userProHobby == null ? null : userProHobby.trim();
    }
}