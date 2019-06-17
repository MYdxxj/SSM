package com.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductCollectExample() {
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

        public Criteria andProductMsgIdIsNull() {
            addCriterion("product_msg_id is null");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdIsNotNull() {
            addCriterion("product_msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdEqualTo(Integer value) {
            addCriterion("product_msg_id =", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdNotEqualTo(Integer value) {
            addCriterion("product_msg_id <>", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdGreaterThan(Integer value) {
            addCriterion("product_msg_id >", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_msg_id >=", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdLessThan(Integer value) {
            addCriterion("product_msg_id <", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_msg_id <=", value, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdIn(List<Integer> values) {
            addCriterion("product_msg_id in", values, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdNotIn(List<Integer> values) {
            addCriterion("product_msg_id not in", values, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdBetween(Integer value1, Integer value2) {
            addCriterion("product_msg_id between", value1, value2, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductMsgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_msg_id not between", value1, value2, "productMsgId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdIsNull() {
            addCriterion("product_price_list_id is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdIsNotNull() {
            addCriterion("product_price_list_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdEqualTo(Integer value) {
            addCriterion("product_price_list_id =", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdNotEqualTo(Integer value) {
            addCriterion("product_price_list_id <>", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdGreaterThan(Integer value) {
            addCriterion("product_price_list_id >", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_price_list_id >=", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdLessThan(Integer value) {
            addCriterion("product_price_list_id <", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_price_list_id <=", value, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdIn(List<Integer> values) {
            addCriterion("product_price_list_id in", values, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdNotIn(List<Integer> values) {
            addCriterion("product_price_list_id not in", values, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdBetween(Integer value1, Integer value2) {
            addCriterion("product_price_list_id between", value1, value2, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductPriceListIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_price_list_id not between", value1, value2, "productPriceListId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIsNull() {
            addCriterion("market_time is null");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIsNotNull() {
            addCriterion("market_time is not null");
            return (Criteria) this;
        }

        public Criteria andMarketTimeEqualTo(Date value) {
            addCriterion("market_time =", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotEqualTo(Date value) {
            addCriterion("market_time <>", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeGreaterThan(Date value) {
            addCriterion("market_time >", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("market_time >=", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeLessThan(Date value) {
            addCriterion("market_time <", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeLessThanOrEqualTo(Date value) {
            addCriterion("market_time <=", value, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeIn(List<Date> values) {
            addCriterion("market_time in", values, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotIn(List<Date> values) {
            addCriterion("market_time not in", values, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeBetween(Date value1, Date value2) {
            addCriterion("market_time between", value1, value2, "marketTime");
            return (Criteria) this;
        }

        public Criteria andMarketTimeNotBetween(Date value1, Date value2) {
            addCriterion("market_time not between", value1, value2, "marketTime");
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