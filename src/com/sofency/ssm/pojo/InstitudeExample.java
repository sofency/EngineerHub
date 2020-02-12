package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class InstitudeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstitudeExample() {
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

        public Criteria andInstidIsNull() {
            addCriterion("instId is null");
            return (Criteria) this;
        }

        public Criteria andInstidIsNotNull() {
            addCriterion("instId is not null");
            return (Criteria) this;
        }

        public Criteria andInstidEqualTo(Integer value) {
            addCriterion("instId =", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotEqualTo(Integer value) {
            addCriterion("instId <>", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidGreaterThan(Integer value) {
            addCriterion("instId >", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidGreaterThanOrEqualTo(Integer value) {
            addCriterion("instId >=", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidLessThan(Integer value) {
            addCriterion("instId <", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidLessThanOrEqualTo(Integer value) {
            addCriterion("instId <=", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidIn(List<Integer> values) {
            addCriterion("instId in", values, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotIn(List<Integer> values) {
            addCriterion("instId not in", values, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidBetween(Integer value1, Integer value2) {
            addCriterion("instId between", value1, value2, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotBetween(Integer value1, Integer value2) {
            addCriterion("instId not between", value1, value2, "instid");
            return (Criteria) this;
        }

        public Criteria andInstnameIsNull() {
            addCriterion("instName is null");
            return (Criteria) this;
        }

        public Criteria andInstnameIsNotNull() {
            addCriterion("instName is not null");
            return (Criteria) this;
        }

        public Criteria andInstnameEqualTo(String value) {
            addCriterion("instName =", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameNotEqualTo(String value) {
            addCriterion("instName <>", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameGreaterThan(String value) {
            addCriterion("instName >", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameGreaterThanOrEqualTo(String value) {
            addCriterion("instName >=", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameLessThan(String value) {
            addCriterion("instName <", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameLessThanOrEqualTo(String value) {
            addCriterion("instName <=", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameLike(String value) {
            addCriterion("instName like", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameNotLike(String value) {
            addCriterion("instName not like", value, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameIn(List<String> values) {
            addCriterion("instName in", values, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameNotIn(List<String> values) {
            addCriterion("instName not in", values, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameBetween(String value1, String value2) {
            addCriterion("instName between", value1, value2, "instname");
            return (Criteria) this;
        }

        public Criteria andInstnameNotBetween(String value1, String value2) {
            addCriterion("instName not between", value1, value2, "instname");
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