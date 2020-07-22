package com.honey.coder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogOperationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountIsNull() {
            addCriterion("op_user_account is null");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountIsNotNull() {
            addCriterion("op_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountEqualTo(String value) {
            addCriterion("op_user_account =", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountNotEqualTo(String value) {
            addCriterion("op_user_account <>", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountGreaterThan(String value) {
            addCriterion("op_user_account >", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("op_user_account >=", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountLessThan(String value) {
            addCriterion("op_user_account <", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountLessThanOrEqualTo(String value) {
            addCriterion("op_user_account <=", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountLike(String value) {
            addCriterion("op_user_account like", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountNotLike(String value) {
            addCriterion("op_user_account not like", value, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountIn(List<String> values) {
            addCriterion("op_user_account in", values, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountNotIn(List<String> values) {
            addCriterion("op_user_account not in", values, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountBetween(String value1, String value2) {
            addCriterion("op_user_account between", value1, value2, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserAccountNotBetween(String value1, String value2) {
            addCriterion("op_user_account not between", value1, value2, "opUserAccount");
            return (Criteria) this;
        }

        public Criteria andOpUserNameIsNull() {
            addCriterion("op_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOpUserNameIsNotNull() {
            addCriterion("op_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpUserNameEqualTo(String value) {
            addCriterion("op_user_name =", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameNotEqualTo(String value) {
            addCriterion("op_user_name <>", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameGreaterThan(String value) {
            addCriterion("op_user_name >", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("op_user_name >=", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameLessThan(String value) {
            addCriterion("op_user_name <", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameLessThanOrEqualTo(String value) {
            addCriterion("op_user_name <=", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameLike(String value) {
            addCriterion("op_user_name like", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameNotLike(String value) {
            addCriterion("op_user_name not like", value, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameIn(List<String> values) {
            addCriterion("op_user_name in", values, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameNotIn(List<String> values) {
            addCriterion("op_user_name not in", values, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameBetween(String value1, String value2) {
            addCriterion("op_user_name between", value1, value2, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpUserNameNotBetween(String value1, String value2) {
            addCriterion("op_user_name not between", value1, value2, "opUserName");
            return (Criteria) this;
        }

        public Criteria andOpCategoryIsNull() {
            addCriterion("op_category is null");
            return (Criteria) this;
        }

        public Criteria andOpCategoryIsNotNull() {
            addCriterion("op_category is not null");
            return (Criteria) this;
        }

        public Criteria andOpCategoryEqualTo(String value) {
            addCriterion("op_category =", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryNotEqualTo(String value) {
            addCriterion("op_category <>", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryGreaterThan(String value) {
            addCriterion("op_category >", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("op_category >=", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryLessThan(String value) {
            addCriterion("op_category <", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryLessThanOrEqualTo(String value) {
            addCriterion("op_category <=", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryLike(String value) {
            addCriterion("op_category like", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryNotLike(String value) {
            addCriterion("op_category not like", value, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryIn(List<String> values) {
            addCriterion("op_category in", values, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryNotIn(List<String> values) {
            addCriterion("op_category not in", values, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryBetween(String value1, String value2) {
            addCriterion("op_category between", value1, value2, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpCategoryNotBetween(String value1, String value2) {
            addCriterion("op_category not between", value1, value2, "opCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryIsNull() {
            addCriterion("op_sub_category is null");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryIsNotNull() {
            addCriterion("op_sub_category is not null");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryEqualTo(String value) {
            addCriterion("op_sub_category =", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryNotEqualTo(String value) {
            addCriterion("op_sub_category <>", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryGreaterThan(String value) {
            addCriterion("op_sub_category >", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("op_sub_category >=", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryLessThan(String value) {
            addCriterion("op_sub_category <", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryLessThanOrEqualTo(String value) {
            addCriterion("op_sub_category <=", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryLike(String value) {
            addCriterion("op_sub_category like", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryNotLike(String value) {
            addCriterion("op_sub_category not like", value, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryIn(List<String> values) {
            addCriterion("op_sub_category in", values, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryNotIn(List<String> values) {
            addCriterion("op_sub_category not in", values, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryBetween(String value1, String value2) {
            addCriterion("op_sub_category between", value1, value2, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpSubCategoryNotBetween(String value1, String value2) {
            addCriterion("op_sub_category not between", value1, value2, "opSubCategory");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("op_type is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("op_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("op_type =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("op_type <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("op_type >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_type >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("op_type <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("op_type <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("op_type in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("op_type not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("op_type between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("op_type not between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpDescIsNull() {
            addCriterion("op_desc is null");
            return (Criteria) this;
        }

        public Criteria andOpDescIsNotNull() {
            addCriterion("op_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOpDescEqualTo(String value) {
            addCriterion("op_desc =", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotEqualTo(String value) {
            addCriterion("op_desc <>", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescGreaterThan(String value) {
            addCriterion("op_desc >", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescGreaterThanOrEqualTo(String value) {
            addCriterion("op_desc >=", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLessThan(String value) {
            addCriterion("op_desc <", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLessThanOrEqualTo(String value) {
            addCriterion("op_desc <=", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescLike(String value) {
            addCriterion("op_desc like", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotLike(String value) {
            addCriterion("op_desc not like", value, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescIn(List<String> values) {
            addCriterion("op_desc in", values, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotIn(List<String> values) {
            addCriterion("op_desc not in", values, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescBetween(String value1, String value2) {
            addCriterion("op_desc between", value1, value2, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpDescNotBetween(String value1, String value2) {
            addCriterion("op_desc not between", value1, value2, "opDesc");
            return (Criteria) this;
        }

        public Criteria andOpResultIsNull() {
            addCriterion("op_result is null");
            return (Criteria) this;
        }

        public Criteria andOpResultIsNotNull() {
            addCriterion("op_result is not null");
            return (Criteria) this;
        }

        public Criteria andOpResultEqualTo(String value) {
            addCriterion("op_result =", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultNotEqualTo(String value) {
            addCriterion("op_result <>", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultGreaterThan(String value) {
            addCriterion("op_result >", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultGreaterThanOrEqualTo(String value) {
            addCriterion("op_result >=", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultLessThan(String value) {
            addCriterion("op_result <", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultLessThanOrEqualTo(String value) {
            addCriterion("op_result <=", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultLike(String value) {
            addCriterion("op_result like", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultNotLike(String value) {
            addCriterion("op_result not like", value, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultIn(List<String> values) {
            addCriterion("op_result in", values, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultNotIn(List<String> values) {
            addCriterion("op_result not in", values, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultBetween(String value1, String value2) {
            addCriterion("op_result between", value1, value2, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpResultNotBetween(String value1, String value2) {
            addCriterion("op_result not between", value1, value2, "opResult");
            return (Criteria) this;
        }

        public Criteria andOpMethodIsNull() {
            addCriterion("op_method is null");
            return (Criteria) this;
        }

        public Criteria andOpMethodIsNotNull() {
            addCriterion("op_method is not null");
            return (Criteria) this;
        }

        public Criteria andOpMethodEqualTo(String value) {
            addCriterion("op_method =", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodNotEqualTo(String value) {
            addCriterion("op_method <>", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodGreaterThan(String value) {
            addCriterion("op_method >", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodGreaterThanOrEqualTo(String value) {
            addCriterion("op_method >=", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodLessThan(String value) {
            addCriterion("op_method <", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodLessThanOrEqualTo(String value) {
            addCriterion("op_method <=", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodLike(String value) {
            addCriterion("op_method like", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodNotLike(String value) {
            addCriterion("op_method not like", value, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodIn(List<String> values) {
            addCriterion("op_method in", values, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodNotIn(List<String> values) {
            addCriterion("op_method not in", values, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodBetween(String value1, String value2) {
            addCriterion("op_method between", value1, value2, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpMethodNotBetween(String value1, String value2) {
            addCriterion("op_method not between", value1, value2, "opMethod");
            return (Criteria) this;
        }

        public Criteria andOpCostIsNull() {
            addCriterion("op_cost is null");
            return (Criteria) this;
        }

        public Criteria andOpCostIsNotNull() {
            addCriterion("op_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOpCostEqualTo(Long value) {
            addCriterion("op_cost =", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostNotEqualTo(Long value) {
            addCriterion("op_cost <>", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostGreaterThan(Long value) {
            addCriterion("op_cost >", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostGreaterThanOrEqualTo(Long value) {
            addCriterion("op_cost >=", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostLessThan(Long value) {
            addCriterion("op_cost <", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostLessThanOrEqualTo(Long value) {
            addCriterion("op_cost <=", value, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostIn(List<Long> values) {
            addCriterion("op_cost in", values, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostNotIn(List<Long> values) {
            addCriterion("op_cost not in", values, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostBetween(Long value1, Long value2) {
            addCriterion("op_cost between", value1, value2, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpCostNotBetween(Long value1, Long value2) {
            addCriterion("op_cost not between", value1, value2, "opCost");
            return (Criteria) this;
        }

        public Criteria andOpUriIsNull() {
            addCriterion("op_uri is null");
            return (Criteria) this;
        }

        public Criteria andOpUriIsNotNull() {
            addCriterion("op_uri is not null");
            return (Criteria) this;
        }

        public Criteria andOpUriEqualTo(String value) {
            addCriterion("op_uri =", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriNotEqualTo(String value) {
            addCriterion("op_uri <>", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriGreaterThan(String value) {
            addCriterion("op_uri >", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriGreaterThanOrEqualTo(String value) {
            addCriterion("op_uri >=", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriLessThan(String value) {
            addCriterion("op_uri <", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriLessThanOrEqualTo(String value) {
            addCriterion("op_uri <=", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriLike(String value) {
            addCriterion("op_uri like", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriNotLike(String value) {
            addCriterion("op_uri not like", value, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriIn(List<String> values) {
            addCriterion("op_uri in", values, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriNotIn(List<String> values) {
            addCriterion("op_uri not in", values, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriBetween(String value1, String value2) {
            addCriterion("op_uri between", value1, value2, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpUriNotBetween(String value1, String value2) {
            addCriterion("op_uri not between", value1, value2, "opUri");
            return (Criteria) this;
        }

        public Criteria andOpIpIsNull() {
            addCriterion("op_ip is null");
            return (Criteria) this;
        }

        public Criteria andOpIpIsNotNull() {
            addCriterion("op_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOpIpEqualTo(String value) {
            addCriterion("op_ip =", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpNotEqualTo(String value) {
            addCriterion("op_ip <>", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpGreaterThan(String value) {
            addCriterion("op_ip >", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpGreaterThanOrEqualTo(String value) {
            addCriterion("op_ip >=", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpLessThan(String value) {
            addCriterion("op_ip <", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpLessThanOrEqualTo(String value) {
            addCriterion("op_ip <=", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpLike(String value) {
            addCriterion("op_ip like", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpNotLike(String value) {
            addCriterion("op_ip not like", value, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpIn(List<String> values) {
            addCriterion("op_ip in", values, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpNotIn(List<String> values) {
            addCriterion("op_ip not in", values, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpBetween(String value1, String value2) {
            addCriterion("op_ip between", value1, value2, "opIp");
            return (Criteria) this;
        }

        public Criteria andOpIpNotBetween(String value1, String value2) {
            addCriterion("op_ip not between", value1, value2, "opIp");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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