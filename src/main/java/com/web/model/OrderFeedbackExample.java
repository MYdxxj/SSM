package com.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFeedbackExample() {
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

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(Integer value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(Integer value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(Integer value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(Integer value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<Integer> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<Integer> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(String value) {
            addCriterion("handle_status =", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(String value) {
            addCriterion("handle_status <>", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(String value) {
            addCriterion("handle_status >", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("handle_status >=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(String value) {
            addCriterion("handle_status <", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(String value) {
            addCriterion("handle_status <=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLike(String value) {
            addCriterion("handle_status like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotLike(String value) {
            addCriterion("handle_status not like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(List<String> values) {
            addCriterion("handle_status in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(List<String> values) {
            addCriterion("handle_status not in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(String value1, String value2) {
            addCriterion("handle_status between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(String value1, String value2) {
            addCriterion("handle_status not between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andUserContactIsNull() {
            addCriterion("user_contact is null");
            return (Criteria) this;
        }

        public Criteria andUserContactIsNotNull() {
            addCriterion("user_contact is not null");
            return (Criteria) this;
        }

        public Criteria andUserContactEqualTo(String value) {
            addCriterion("user_contact =", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactNotEqualTo(String value) {
            addCriterion("user_contact <>", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactGreaterThan(String value) {
            addCriterion("user_contact >", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactGreaterThanOrEqualTo(String value) {
            addCriterion("user_contact >=", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactLessThan(String value) {
            addCriterion("user_contact <", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactLessThanOrEqualTo(String value) {
            addCriterion("user_contact <=", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactLike(String value) {
            addCriterion("user_contact like", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactNotLike(String value) {
            addCriterion("user_contact not like", value, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactIn(List<String> values) {
            addCriterion("user_contact in", values, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactNotIn(List<String> values) {
            addCriterion("user_contact not in", values, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactBetween(String value1, String value2) {
            addCriterion("user_contact between", value1, value2, "userContact");
            return (Criteria) this;
        }

        public Criteria andUserContactNotBetween(String value1, String value2) {
            addCriterion("user_contact not between", value1, value2, "userContact");
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

        public Criteria andProductBuydateIsNull() {
            addCriterion("product_buydate is null");
            return (Criteria) this;
        }

        public Criteria andProductBuydateIsNotNull() {
            addCriterion("product_buydate is not null");
            return (Criteria) this;
        }

        public Criteria andProductBuydateEqualTo(String value) {
            addCriterion("product_buydate =", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateNotEqualTo(String value) {
            addCriterion("product_buydate <>", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateGreaterThan(String value) {
            addCriterion("product_buydate >", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateGreaterThanOrEqualTo(String value) {
            addCriterion("product_buydate >=", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateLessThan(String value) {
            addCriterion("product_buydate <", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateLessThanOrEqualTo(String value) {
            addCriterion("product_buydate <=", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateLike(String value) {
            addCriterion("product_buydate like", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateNotLike(String value) {
            addCriterion("product_buydate not like", value, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateIn(List<String> values) {
            addCriterion("product_buydate in", values, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateNotIn(List<String> values) {
            addCriterion("product_buydate not in", values, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateBetween(String value1, String value2) {
            addCriterion("product_buydate between", value1, value2, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductBuydateNotBetween(String value1, String value2) {
            addCriterion("product_buydate not between", value1, value2, "productBuydate");
            return (Criteria) this;
        }

        public Criteria andProductProblemIsNull() {
            addCriterion("product_problem is null");
            return (Criteria) this;
        }

        public Criteria andProductProblemIsNotNull() {
            addCriterion("product_problem is not null");
            return (Criteria) this;
        }

        public Criteria andProductProblemEqualTo(String value) {
            addCriterion("product_problem =", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemNotEqualTo(String value) {
            addCriterion("product_problem <>", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemGreaterThan(String value) {
            addCriterion("product_problem >", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemGreaterThanOrEqualTo(String value) {
            addCriterion("product_problem >=", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemLessThan(String value) {
            addCriterion("product_problem <", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemLessThanOrEqualTo(String value) {
            addCriterion("product_problem <=", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemLike(String value) {
            addCriterion("product_problem like", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemNotLike(String value) {
            addCriterion("product_problem not like", value, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemIn(List<String> values) {
            addCriterion("product_problem in", values, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemNotIn(List<String> values) {
            addCriterion("product_problem not in", values, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemBetween(String value1, String value2) {
            addCriterion("product_problem between", value1, value2, "productProblem");
            return (Criteria) this;
        }

        public Criteria andProductProblemNotBetween(String value1, String value2) {
            addCriterion("product_problem not between", value1, value2, "productProblem");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeIsNull() {
            addCriterion("feedback_createtime is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeIsNotNull() {
            addCriterion("feedback_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeEqualTo(Date value) {
            addCriterion("feedback_createtime =", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeNotEqualTo(Date value) {
            addCriterion("feedback_createtime <>", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeGreaterThan(Date value) {
            addCriterion("feedback_createtime >", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feedback_createtime >=", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeLessThan(Date value) {
            addCriterion("feedback_createtime <", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("feedback_createtime <=", value, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeIn(List<Date> values) {
            addCriterion("feedback_createtime in", values, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeNotIn(List<Date> values) {
            addCriterion("feedback_createtime not in", values, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeBetween(Date value1, Date value2) {
            addCriterion("feedback_createtime between", value1, value2, "feedbackCreatetime");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("feedback_createtime not between", value1, value2, "feedbackCreatetime");
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