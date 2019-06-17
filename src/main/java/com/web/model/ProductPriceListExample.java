package com.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPriceListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPriceListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPriceListIdIsNull() {
            addCriterion("price_list_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceListIdIsNotNull() {
            addCriterion("price_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceListIdEqualTo(Integer value) {
            addCriterion("price_list_id =", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdNotEqualTo(Integer value) {
            addCriterion("price_list_id <>", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdGreaterThan(Integer value) {
            addCriterion("price_list_id >", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_list_id >=", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdLessThan(Integer value) {
            addCriterion("price_list_id <", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdLessThanOrEqualTo(Integer value) {
            addCriterion("price_list_id <=", value, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdIn(List<Integer> values) {
            addCriterion("price_list_id in", values, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdNotIn(List<Integer> values) {
            addCriterion("price_list_id not in", values, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdBetween(Integer value1, Integer value2) {
            addCriterion("price_list_id between", value1, value2, "priceListId");
            return (Criteria) this;
        }

        public Criteria andPriceListIdNotBetween(Integer value1, Integer value2) {
            addCriterion("price_list_id not between", value1, value2, "priceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameIsNull() {
            addCriterion("product_price_name is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameIsNotNull() {
            addCriterion("product_price_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameEqualTo(String value) {
            addCriterion("product_price_name =", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameNotEqualTo(String value) {
            addCriterion("product_price_name <>", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameGreaterThan(String value) {
            addCriterion("product_price_name >", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_price_name >=", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameLessThan(String value) {
            addCriterion("product_price_name <", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameLessThanOrEqualTo(String value) {
            addCriterion("product_price_name <=", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameLike(String value) {
            addCriterion("product_price_name like", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameNotLike(String value) {
            addCriterion("product_price_name not like", value, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameIn(List<String> values) {
            addCriterion("product_price_name in", values, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameNotIn(List<String> values) {
            addCriterion("product_price_name not in", values, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameBetween(String value1, String value2) {
            addCriterion("product_price_name between", value1, value2, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductPriceNameNotBetween(String value1, String value2) {
            addCriterion("product_price_name not between", value1, value2, "productPriceName");
            return (Criteria) this;
        }

        public Criteria andProductListDescIsNull() {
            addCriterion("product_list_desc is null");
            return (Criteria) this;
        }

        public Criteria andProductListDescIsNotNull() {
            addCriterion("product_list_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProductListDescEqualTo(String value) {
            addCriterion("product_list_desc =", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescNotEqualTo(String value) {
            addCriterion("product_list_desc <>", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescGreaterThan(String value) {
            addCriterion("product_list_desc >", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescGreaterThanOrEqualTo(String value) {
            addCriterion("product_list_desc >=", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescLessThan(String value) {
            addCriterion("product_list_desc <", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescLessThanOrEqualTo(String value) {
            addCriterion("product_list_desc <=", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescLike(String value) {
            addCriterion("product_list_desc like", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescNotLike(String value) {
            addCriterion("product_list_desc not like", value, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescIn(List<String> values) {
            addCriterion("product_list_desc in", values, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescNotIn(List<String> values) {
            addCriterion("product_list_desc not in", values, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescBetween(String value1, String value2) {
            addCriterion("product_list_desc between", value1, value2, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductListDescNotBetween(String value1, String value2) {
            addCriterion("product_list_desc not between", value1, value2, "productListDesc");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIsNull() {
            addCriterion("product_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIsNotNull() {
            addCriterion("product_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceEqualTo(String value) {
            addCriterion("product_unit_price =", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotEqualTo(String value) {
            addCriterion("product_unit_price <>", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceGreaterThan(String value) {
            addCriterion("product_unit_price >", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceGreaterThanOrEqualTo(String value) {
            addCriterion("product_unit_price >=", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceLessThan(String value) {
            addCriterion("product_unit_price <", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceLessThanOrEqualTo(String value) {
            addCriterion("product_unit_price <=", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceLike(String value) {
            addCriterion("product_unit_price like", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotLike(String value) {
            addCriterion("product_unit_price not like", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIn(List<String> values) {
            addCriterion("product_unit_price in", values, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotIn(List<String> values) {
            addCriterion("product_unit_price not in", values, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceBetween(String value1, String value2) {
            addCriterion("product_unit_price between", value1, value2, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotBetween(String value1, String value2) {
            addCriterion("product_unit_price not between", value1, value2, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceIsNull() {
            addCriterion("product_selling_price is null");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceIsNotNull() {
            addCriterion("product_selling_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceEqualTo(String value) {
            addCriterion("product_selling_price =", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceNotEqualTo(String value) {
            addCriterion("product_selling_price <>", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceGreaterThan(String value) {
            addCriterion("product_selling_price >", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceGreaterThanOrEqualTo(String value) {
            addCriterion("product_selling_price >=", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceLessThan(String value) {
            addCriterion("product_selling_price <", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceLessThanOrEqualTo(String value) {
            addCriterion("product_selling_price <=", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceLike(String value) {
            addCriterion("product_selling_price like", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceNotLike(String value) {
            addCriterion("product_selling_price not like", value, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceIn(List<String> values) {
            addCriterion("product_selling_price in", values, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceNotIn(List<String> values) {
            addCriterion("product_selling_price not in", values, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceBetween(String value1, String value2) {
            addCriterion("product_selling_price between", value1, value2, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellingPriceNotBetween(String value1, String value2) {
            addCriterion("product_selling_price not between", value1, value2, "productSellingPrice");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyIsNull() {
            addCriterion("product_source_company is null");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyIsNotNull() {
            addCriterion("product_source_company is not null");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyEqualTo(String value) {
            addCriterion("product_source_company =", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyNotEqualTo(String value) {
            addCriterion("product_source_company <>", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyGreaterThan(String value) {
            addCriterion("product_source_company >", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("product_source_company >=", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyLessThan(String value) {
            addCriterion("product_source_company <", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyLessThanOrEqualTo(String value) {
            addCriterion("product_source_company <=", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyLike(String value) {
            addCriterion("product_source_company like", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyNotLike(String value) {
            addCriterion("product_source_company not like", value, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyIn(List<String> values) {
            addCriterion("product_source_company in", values, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyNotIn(List<String> values) {
            addCriterion("product_source_company not in", values, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyBetween(String value1, String value2) {
            addCriterion("product_source_company between", value1, value2, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductSourceCompanyNotBetween(String value1, String value2) {
            addCriterion("product_source_company not between", value1, value2, "productSourceCompany");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIsNull() {
            addCriterion("product_remark is null");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIsNotNull() {
            addCriterion("product_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProductRemarkEqualTo(String value) {
            addCriterion("product_remark =", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotEqualTo(String value) {
            addCriterion("product_remark <>", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkGreaterThan(String value) {
            addCriterion("product_remark >", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("product_remark >=", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLessThan(String value) {
            addCriterion("product_remark <", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLessThanOrEqualTo(String value) {
            addCriterion("product_remark <=", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkLike(String value) {
            addCriterion("product_remark like", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotLike(String value) {
            addCriterion("product_remark not like", value, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkIn(List<String> values) {
            addCriterion("product_remark in", values, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotIn(List<String> values) {
            addCriterion("product_remark not in", values, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkBetween(String value1, String value2) {
            addCriterion("product_remark between", value1, value2, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductRemarkNotBetween(String value1, String value2) {
            addCriterion("product_remark not between", value1, value2, "productRemark");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeIsNull() {
            addCriterion("product_list_createtime is null");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeIsNotNull() {
            addCriterion("product_list_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeEqualTo(Date value) {
            addCriterion("product_list_createtime =", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeNotEqualTo(Date value) {
            addCriterion("product_list_createtime <>", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeGreaterThan(Date value) {
            addCriterion("product_list_createtime >", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("product_list_createtime >=", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeLessThan(Date value) {
            addCriterion("product_list_createtime <", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("product_list_createtime <=", value, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeIn(List<Date> values) {
            addCriterion("product_list_createtime in", values, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeNotIn(List<Date> values) {
            addCriterion("product_list_createtime not in", values, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeBetween(Date value1, Date value2) {
            addCriterion("product_list_createtime between", value1, value2, "productListCreatetime");
            return (Criteria) this;
        }

        public Criteria andProductListCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("product_list_createtime not between", value1, value2, "productListCreatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}