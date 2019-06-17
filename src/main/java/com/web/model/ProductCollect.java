package com.web.model;

import java.util.Date;

public class ProductCollect {
    private Integer productMsgId;

    private Integer productPriceListId;

    private String productName;

    private String productType;

    private Date marketTime;

    public Integer getProductMsgId() {
        return productMsgId;
    }

    public void setProductMsgId(Integer productMsgId) {
        this.productMsgId = productMsgId;
    }

    public Integer getProductPriceListId() {
        return productPriceListId;
    }

    public void setProductPriceListId(Integer productPriceListId) {
        this.productPriceListId = productPriceListId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public Date getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(Date marketTime) {
        this.marketTime = marketTime;
    }
}