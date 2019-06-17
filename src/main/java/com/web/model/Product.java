package com.web.model;

public class Product {
    private Integer productId;

    private String productName;

    private String productMoney;

    private String productType;

    private String productDsc;

    private String pruductKucun;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(String productMoney) {
        this.productMoney = productMoney == null ? null : productMoney.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductDsc() {
        return productDsc;
    }

    public void setProductDsc(String productDsc) {
        this.productDsc = productDsc == null ? null : productDsc.trim();
    }

    public String getPruductKucun() {
        return pruductKucun;
    }

    public void setPruductKucun(String pruductKucun) {
        this.pruductKucun = pruductKucun == null ? null : pruductKucun.trim();
    }
}