package com.web.model;

import java.util.Date;

public class ProductPriceList {
    private Integer priceListId;

    private String productPriceName;

    private String productListDesc;

    private String productUnitPrice;

    private String productSellingPrice;

    private String productSourceCompany;

    private String productRemark;

    private Date productListCreatetime;

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public String getProductPriceName() {
        return productPriceName;
    }

    public void setProductPriceName(String productPriceName) {
        this.productPriceName = productPriceName == null ? null : productPriceName.trim();
    }

    public String getProductListDesc() {
        return productListDesc;
    }

    public void setProductListDesc(String productListDesc) {
        this.productListDesc = productListDesc == null ? null : productListDesc.trim();
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice == null ? null : productUnitPrice.trim();
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice == null ? null : productSellingPrice.trim();
    }

    public String getProductSourceCompany() {
        return productSourceCompany;
    }

    public void setProductSourceCompany(String productSourceCompany) {
        this.productSourceCompany = productSourceCompany == null ? null : productSourceCompany.trim();
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
    }

    public Date getProductListCreatetime() {
        return productListCreatetime;
    }

    public void setProductListCreatetime(Date productListCreatetime) {
        this.productListCreatetime = productListCreatetime;
    }
}