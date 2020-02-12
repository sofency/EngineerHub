package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class FameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FameExample() {
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

        public Criteria andFameNameIsNull() {
            addCriterion("fame_name is null");
            return (Criteria) this;
        }

        public Criteria andFameNameIsNotNull() {
            addCriterion("fame_name is not null");
            return (Criteria) this;
        }

        public Criteria andFameNameEqualTo(String value) {
            addCriterion("fame_name =", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameNotEqualTo(String value) {
            addCriterion("fame_name <>", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameGreaterThan(String value) {
            addCriterion("fame_name >", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameGreaterThanOrEqualTo(String value) {
            addCriterion("fame_name >=", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameLessThan(String value) {
            addCriterion("fame_name <", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameLessThanOrEqualTo(String value) {
            addCriterion("fame_name <=", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameLike(String value) {
            addCriterion("fame_name like", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameNotLike(String value) {
            addCriterion("fame_name not like", value, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameIn(List<String> values) {
            addCriterion("fame_name in", values, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameNotIn(List<String> values) {
            addCriterion("fame_name not in", values, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameBetween(String value1, String value2) {
            addCriterion("fame_name between", value1, value2, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameNameNotBetween(String value1, String value2) {
            addCriterion("fame_name not between", value1, value2, "fameName");
            return (Criteria) this;
        }

        public Criteria andFameLevelIsNull() {
            addCriterion("fame_level is null");
            return (Criteria) this;
        }

        public Criteria andFameLevelIsNotNull() {
            addCriterion("fame_level is not null");
            return (Criteria) this;
        }

        public Criteria andFameLevelEqualTo(Integer value) {
            addCriterion("fame_level =", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelNotEqualTo(Integer value) {
            addCriterion("fame_level <>", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelGreaterThan(Integer value) {
            addCriterion("fame_level >", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("fame_level >=", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelLessThan(Integer value) {
            addCriterion("fame_level <", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelLessThanOrEqualTo(Integer value) {
            addCriterion("fame_level <=", value, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelIn(List<Integer> values) {
            addCriterion("fame_level in", values, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelNotIn(List<Integer> values) {
            addCriterion("fame_level not in", values, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelBetween(Integer value1, Integer value2) {
            addCriterion("fame_level between", value1, value2, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFameLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("fame_level not between", value1, value2, "fameLevel");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionIsNull() {
            addCriterion("famedescription is null");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionIsNotNull() {
            addCriterion("famedescription is not null");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionEqualTo(String value) {
            addCriterion("famedescription =", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionNotEqualTo(String value) {
            addCriterion("famedescription <>", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionGreaterThan(String value) {
            addCriterion("famedescription >", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("famedescription >=", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionLessThan(String value) {
            addCriterion("famedescription <", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionLessThanOrEqualTo(String value) {
            addCriterion("famedescription <=", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionLike(String value) {
            addCriterion("famedescription like", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionNotLike(String value) {
            addCriterion("famedescription not like", value, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionIn(List<String> values) {
            addCriterion("famedescription in", values, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionNotIn(List<String> values) {
            addCriterion("famedescription not in", values, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionBetween(String value1, String value2) {
            addCriterion("famedescription between", value1, value2, "famedescription");
            return (Criteria) this;
        }

        public Criteria andFamedescriptionNotBetween(String value1, String value2) {
            addCriterion("famedescription not between", value1, value2, "famedescription");
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