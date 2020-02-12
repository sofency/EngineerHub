package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetfameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GetfameExample() {
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

        public Criteria andFameIdIsNull() {
            addCriterion("fame_id is null");
            return (Criteria) this;
        }

        public Criteria andFameIdIsNotNull() {
            addCriterion("fame_id is not null");
            return (Criteria) this;
        }

        public Criteria andFameIdEqualTo(Integer value) {
            addCriterion("fame_id =", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdNotEqualTo(Integer value) {
            addCriterion("fame_id <>", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdGreaterThan(Integer value) {
            addCriterion("fame_id >", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fame_id >=", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdLessThan(Integer value) {
            addCriterion("fame_id <", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdLessThanOrEqualTo(Integer value) {
            addCriterion("fame_id <=", value, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdIn(List<Integer> values) {
            addCriterion("fame_id in", values, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdNotIn(List<Integer> values) {
            addCriterion("fame_id not in", values, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdBetween(Integer value1, Integer value2) {
            addCriterion("fame_id between", value1, value2, "fameId");
            return (Criteria) this;
        }

        public Criteria andFameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fame_id not between", value1, value2, "fameId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNull() {
            addCriterion("engineer_id is null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIsNotNull() {
            addCriterion("engineer_id is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerIdEqualTo(Integer value) {
            addCriterion("engineer_id =", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotEqualTo(Integer value) {
            addCriterion("engineer_id <>", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThan(Integer value) {
            addCriterion("engineer_id >", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("engineer_id >=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThan(Integer value) {
            addCriterion("engineer_id <", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdLessThanOrEqualTo(Integer value) {
            addCriterion("engineer_id <=", value, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdIn(List<Integer> values) {
            addCriterion("engineer_id in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotIn(List<Integer> values) {
            addCriterion("engineer_id not in", values, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdBetween(Integer value1, Integer value2) {
            addCriterion("engineer_id between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andEngineerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("engineer_id not between", value1, value2, "engineerId");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNull() {
            addCriterion("getTime is null");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNotNull() {
            addCriterion("getTime is not null");
            return (Criteria) this;
        }

        public Criteria andGettimeEqualTo(Date value) {
            addCriterion("getTime =", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotEqualTo(Date value) {
            addCriterion("getTime <>", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThan(Date value) {
            addCriterion("getTime >", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("getTime >=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThan(Date value) {
            addCriterion("getTime <", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThanOrEqualTo(Date value) {
            addCriterion("getTime <=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeIn(List<Date> values) {
            addCriterion("getTime in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotIn(List<Date> values) {
            addCriterion("getTime not in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeBetween(Date value1, Date value2) {
            addCriterion("getTime between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotBetween(Date value1, Date value2) {
            addCriterion("getTime not between", value1, value2, "gettime");
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