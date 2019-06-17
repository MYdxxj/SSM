package com.web.model;

public class ActivityProduct {
    private Integer activityProductId;

    private Integer activityId;

    private Integer productId;

    public Integer getActivityProductId() {
        return activityProductId;
    }

    public void setActivityProductId(Integer activityProductId) {
        this.activityProductId = activityProductId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}