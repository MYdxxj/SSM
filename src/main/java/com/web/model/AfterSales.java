package com.web.model;

import java.util.Date;

public class AfterSales {
    private Integer afterSalesId;

    private String orderInformation;

    private String afterSalesDsc;

    private Date afterSalesCreateTime;

    private String waiterId;

    public Integer getAfterSalesId() {
        return afterSalesId;
    }

    public void setAfterSalesId(Integer afterSalesId) {
        this.afterSalesId = afterSalesId;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation == null ? null : orderInformation.trim();
    }

    public String getAfterSalesDsc() {
        return afterSalesDsc;
    }

    public void setAfterSalesDsc(String afterSalesDsc) {
        this.afterSalesDsc = afterSalesDsc == null ? null : afterSalesDsc.trim();
    }

    public Date getAfterSalesCreateTime() {
        return afterSalesCreateTime;
    }

    public void setAfterSalesCreateTime(Date afterSalesCreateTime) {
        this.afterSalesCreateTime = afterSalesCreateTime;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId == null ? null : waiterId.trim();
    }
}