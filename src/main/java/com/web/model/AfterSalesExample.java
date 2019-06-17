package com.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AfterSalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AfterSalesExample() {
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

        public Criteria andAfterSalesIdIsNull() {
            addCriterion("after_sales_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdIsNotNull() {
            addCriterion("after_sales_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdEqualTo(Integer value) {
            addCriterion("after_sales_id =", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdNotEqualTo(Integer value) {
            addCriterion("after_sales_id <>", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdGreaterThan(Integer value) {
            addCriterion("after_sales_id >", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("after_sales_id >=", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdLessThan(Integer value) {
            addCriterion("after_sales_id <", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdLessThanOrEqualTo(Integer value) {
            addCriterion("after_sales_id <=", value, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdIn(List<Integer> values) {
            addCriterion("after_sales_id in", values, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdNotIn(List<Integer> values) {
            addCriterion("after_sales_id not in", values, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdBetween(Integer value1, Integer value2) {
            addCriterion("after_sales_id between", value1, value2, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andAfterSalesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("after_sales_id not between", value1, value2, "afterSalesId");
            return (Criteria) this;
        }

        public Criteria andOrderInformationIsNull() {
            addCriterion("order_information is null");
            return (Criteria) this;
        }

        public Criteria andOrderInformationIsNotNull() {
            addCriterion("order_information is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInformationEqualTo(String value) {
            addCriterion("order_information =", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationNotEqualTo(String value) {
            addCriterion("order_information <>", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationGreaterThan(String value) {
            addCriterion("order_information >", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationGreaterThanOrEqualTo(String value) {
            addCriterion("order_information >=", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationLessThan(String value) {
            addCriterion("order_information <", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationLessThanOrEqualTo(String value) {
            addCriterion("order_information <=", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationLike(String value) {
            addCriterion("order_information like", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationNotLike(String value) {
            addCriterion("order_information not like", value, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationIn(List<String> values) {
            addCriterion("order_information in", values, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationNotIn(List<String> values) {
            addCriterion("order_information not in", values, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationBetween(String value1, String value2) {
            addCriterion("order_information between", value1, value2, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andOrderInformationNotBetween(String value1, String value2) {
            addCriterion("order_information not between", value1, value2, "orderInformation");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscIsNull() {
            addCriterion("after_sales_dsc is null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscIsNotNull() {
            addCriterion("after_sales_dsc is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscEqualTo(String value) {
            addCriterion("after_sales_dsc =", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscNotEqualTo(String value) {
            addCriterion("after_sales_dsc <>", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscGreaterThan(String value) {
            addCriterion("after_sales_dsc >", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscGreaterThanOrEqualTo(String value) {
            addCriterion("after_sales_dsc >=", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscLessThan(String value) {
            addCriterion("after_sales_dsc <", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscLessThanOrEqualTo(String value) {
            addCriterion("after_sales_dsc <=", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscLike(String value) {
            addCriterion("after_sales_dsc like", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscNotLike(String value) {
            addCriterion("after_sales_dsc not like", value, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscIn(List<String> values) {
            addCriterion("after_sales_dsc in", values, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscNotIn(List<String> values) {
            addCriterion("after_sales_dsc not in", values, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscBetween(String value1, String value2) {
            addCriterion("after_sales_dsc between", value1, value2, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesDscNotBetween(String value1, String value2) {
            addCriterion("after_sales_dsc not between", value1, value2, "afterSalesDsc");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeIsNull() {
            addCriterion("after_sales_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeIsNotNull() {
            addCriterion("after_sales_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeEqualTo(Date value) {
            addCriterion("after_sales_create_time =", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeNotEqualTo(Date value) {
            addCriterion("after_sales_create_time <>", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeGreaterThan(Date value) {
            addCriterion("after_sales_create_time >", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("after_sales_create_time >=", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeLessThan(Date value) {
            addCriterion("after_sales_create_time <", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("after_sales_create_time <=", value, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeIn(List<Date> values) {
            addCriterion("after_sales_create_time in", values, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeNotIn(List<Date> values) {
            addCriterion("after_sales_create_time not in", values, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeBetween(Date value1, Date value2) {
            addCriterion("after_sales_create_time between", value1, value2, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterSalesCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("after_sales_create_time not between", value1, value2, "afterSalesCreateTime");
            return (Criteria) this;
        }

        public Criteria andWaiterIdIsNull() {
            addCriterion("waiter_id is null");
            return (Criteria) this;
        }

        public Criteria andWaiterIdIsNotNull() {
            addCriterion("waiter_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaiterIdEqualTo(String value) {
            addCriterion("waiter_id =", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotEqualTo(String value) {
            addCriterion("waiter_id <>", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdGreaterThan(String value) {
            addCriterion("waiter_id >", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdGreaterThanOrEqualTo(String value) {
            addCriterion("waiter_id >=", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdLessThan(String value) {
            addCriterion("waiter_id <", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdLessThanOrEqualTo(String value) {
            addCriterion("waiter_id <=", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdLike(String value) {
            addCriterion("waiter_id like", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotLike(String value) {
            addCriterion("waiter_id not like", value, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdIn(List<String> values) {
            addCriterion("waiter_id in", values, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotIn(List<String> values) {
            addCriterion("waiter_id not in", values, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdBetween(String value1, String value2) {
            addCriterion("waiter_id between", value1, value2, "waiterId");
            return (Criteria) this;
        }

        public Criteria andWaiterIdNotBetween(String value1, String value2) {
            addCriterion("waiter_id not between", value1, value2, "waiterId");
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