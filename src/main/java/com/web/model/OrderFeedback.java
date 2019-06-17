package com.web.model;

import java.util.Date;

public class OrderFeedback {
    private Integer feedbackId;

    private String userName;

    private String userSex;

    private String handleStatus;

    private String userContact;

    private String productName;

    private String productBuydate;

    private String productProblem;

    private Date feedbackCreatetime;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus == null ? null : handleStatus.trim();
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact == null ? null : userContact.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBuydate() {
        return productBuydate;
    }

    public void setProductBuydate(String productBuydate) {
        this.productBuydate = productBuydate == null ? null : productBuydate.trim();
    }

    public String getProductProblem() {
        return productProblem;
    }

    public void setProductProblem(String productProblem) {
        this.productProblem = productProblem == null ? null : productProblem.trim();
    }

    public Date getFeedbackCreatetime() {
        return feedbackCreatetime;
    }

    public void setFeedbackCreatetime(Date feedbackCreatetime) {
        this.feedbackCreatetime = feedbackCreatetime;
    }
}