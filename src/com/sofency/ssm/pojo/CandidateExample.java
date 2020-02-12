package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class CandidateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CandidateExample() {
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

        public Criteria andCandidateIdIsNull() {
            addCriterion("candidate_id is null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIsNotNull() {
            addCriterion("candidate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateIdEqualTo(Integer value) {
            addCriterion("candidate_id =", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotEqualTo(Integer value) {
            addCriterion("candidate_id <>", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThan(Integer value) {
            addCriterion("candidate_id >", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("candidate_id >=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThan(Integer value) {
            addCriterion("candidate_id <", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdLessThanOrEqualTo(Integer value) {
            addCriterion("candidate_id <=", value, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdIn(List<Integer> values) {
            addCriterion("candidate_id in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotIn(List<Integer> values) {
            addCriterion("candidate_id not in", values, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdBetween(Integer value1, Integer value2) {
            addCriterion("candidate_id between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andCandidateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("candidate_id not between", value1, value2, "candidateId");
            return (Criteria) this;
        }

        public Criteria andInstidIsNull() {
            addCriterion("instid is null");
            return (Criteria) this;
        }

        public Criteria andInstidIsNotNull() {
            addCriterion("instid is not null");
            return (Criteria) this;
        }

        public Criteria andInstidEqualTo(Integer value) {
            addCriterion("instid =", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotEqualTo(Integer value) {
            addCriterion("instid <>", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidGreaterThan(Integer value) {
            addCriterion("instid >", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidGreaterThanOrEqualTo(Integer value) {
            addCriterion("instid >=", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidLessThan(Integer value) {
            addCriterion("instid <", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidLessThanOrEqualTo(Integer value) {
            addCriterion("instid <=", value, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidIn(List<Integer> values) {
            addCriterion("instid in", values, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotIn(List<Integer> values) {
            addCriterion("instid not in", values, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidBetween(Integer value1, Integer value2) {
            addCriterion("instid between", value1, value2, "instid");
            return (Criteria) this;
        }

        public Criteria andInstidNotBetween(Integer value1, Integer value2) {
            addCriterion("instid not between", value1, value2, "instid");
            return (Criteria) this;
        }

        public Criteria andMajoridIsNull() {
            addCriterion("majorId is null");
            return (Criteria) this;
        }

        public Criteria andMajoridIsNotNull() {
            addCriterion("majorId is not null");
            return (Criteria) this;
        }

        public Criteria andMajoridEqualTo(Integer value) {
            addCriterion("majorId =", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotEqualTo(Integer value) {
            addCriterion("majorId <>", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridGreaterThan(Integer value) {
            addCriterion("majorId >", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("majorId >=", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridLessThan(Integer value) {
            addCriterion("majorId <", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridLessThanOrEqualTo(Integer value) {
            addCriterion("majorId <=", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridIn(List<Integer> values) {
            addCriterion("majorId in", values, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotIn(List<Integer> values) {
            addCriterion("majorId not in", values, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridBetween(Integer value1, Integer value2) {
            addCriterion("majorId between", value1, value2, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotBetween(Integer value1, Integer value2) {
            addCriterion("majorId not between", value1, value2, "majorid");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIsNull() {
            addCriterion("candidate_name is null");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIsNotNull() {
            addCriterion("candidate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateNameEqualTo(String value) {
            addCriterion("candidate_name =", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotEqualTo(String value) {
            addCriterion("candidate_name <>", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameGreaterThan(String value) {
            addCriterion("candidate_name >", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_name >=", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLessThan(String value) {
            addCriterion("candidate_name <", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLessThanOrEqualTo(String value) {
            addCriterion("candidate_name <=", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameLike(String value) {
            addCriterion("candidate_name like", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotLike(String value) {
            addCriterion("candidate_name not like", value, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameIn(List<String> values) {
            addCriterion("candidate_name in", values, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotIn(List<String> values) {
            addCriterion("candidate_name not in", values, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameBetween(String value1, String value2) {
            addCriterion("candidate_name between", value1, value2, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateNameNotBetween(String value1, String value2) {
            addCriterion("candidate_name not between", value1, value2, "candidateName");
            return (Criteria) this;
        }

        public Criteria andCandidateSexIsNull() {
            addCriterion("candidate_sex is null");
            return (Criteria) this;
        }

        public Criteria andCandidateSexIsNotNull() {
            addCriterion("candidate_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateSexEqualTo(String value) {
            addCriterion("candidate_sex =", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexNotEqualTo(String value) {
            addCriterion("candidate_sex <>", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexGreaterThan(String value) {
            addCriterion("candidate_sex >", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_sex >=", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexLessThan(String value) {
            addCriterion("candidate_sex <", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexLessThanOrEqualTo(String value) {
            addCriterion("candidate_sex <=", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexLike(String value) {
            addCriterion("candidate_sex like", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexNotLike(String value) {
            addCriterion("candidate_sex not like", value, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexIn(List<String> values) {
            addCriterion("candidate_sex in", values, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexNotIn(List<String> values) {
            addCriterion("candidate_sex not in", values, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexBetween(String value1, String value2) {
            addCriterion("candidate_sex between", value1, value2, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateSexNotBetween(String value1, String value2) {
            addCriterion("candidate_sex not between", value1, value2, "candidateSex");
            return (Criteria) this;
        }

        public Criteria andCandidateTelIsNull() {
            addCriterion("candidate_tel is null");
            return (Criteria) this;
        }

        public Criteria andCandidateTelIsNotNull() {
            addCriterion("candidate_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateTelEqualTo(String value) {
            addCriterion("candidate_tel =", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelNotEqualTo(String value) {
            addCriterion("candidate_tel <>", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelGreaterThan(String value) {
            addCriterion("candidate_tel >", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_tel >=", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelLessThan(String value) {
            addCriterion("candidate_tel <", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelLessThanOrEqualTo(String value) {
            addCriterion("candidate_tel <=", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelLike(String value) {
            addCriterion("candidate_tel like", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelNotLike(String value) {
            addCriterion("candidate_tel not like", value, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelIn(List<String> values) {
            addCriterion("candidate_tel in", values, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelNotIn(List<String> values) {
            addCriterion("candidate_tel not in", values, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelBetween(String value1, String value2) {
            addCriterion("candidate_tel between", value1, value2, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateTelNotBetween(String value1, String value2) {
            addCriterion("candidate_tel not between", value1, value2, "candidateTel");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailIsNull() {
            addCriterion("candidate_email is null");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailIsNotNull() {
            addCriterion("candidate_email is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailEqualTo(String value) {
            addCriterion("candidate_email =", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailNotEqualTo(String value) {
            addCriterion("candidate_email <>", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailGreaterThan(String value) {
            addCriterion("candidate_email >", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_email >=", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailLessThan(String value) {
            addCriterion("candidate_email <", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailLessThanOrEqualTo(String value) {
            addCriterion("candidate_email <=", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailLike(String value) {
            addCriterion("candidate_email like", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailNotLike(String value) {
            addCriterion("candidate_email not like", value, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailIn(List<String> values) {
            addCriterion("candidate_email in", values, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailNotIn(List<String> values) {
            addCriterion("candidate_email not in", values, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailBetween(String value1, String value2) {
            addCriterion("candidate_email between", value1, value2, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateEmailNotBetween(String value1, String value2) {
            addCriterion("candidate_email not between", value1, value2, "candidateEmail");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceIsNull() {
            addCriterion("candidate_introduce is null");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceIsNotNull() {
            addCriterion("candidate_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceEqualTo(String value) {
            addCriterion("candidate_introduce =", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceNotEqualTo(String value) {
            addCriterion("candidate_introduce <>", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceGreaterThan(String value) {
            addCriterion("candidate_introduce >", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_introduce >=", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceLessThan(String value) {
            addCriterion("candidate_introduce <", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceLessThanOrEqualTo(String value) {
            addCriterion("candidate_introduce <=", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceLike(String value) {
            addCriterion("candidate_introduce like", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceNotLike(String value) {
            addCriterion("candidate_introduce not like", value, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceIn(List<String> values) {
            addCriterion("candidate_introduce in", values, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceNotIn(List<String> values) {
            addCriterion("candidate_introduce not in", values, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceBetween(String value1, String value2) {
            addCriterion("candidate_introduce between", value1, value2, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateIntroduceNotBetween(String value1, String value2) {
            addCriterion("candidate_introduce not between", value1, value2, "candidateIntroduce");
            return (Criteria) this;
        }

        public Criteria andCandidateFameIsNull() {
            addCriterion("candidate_fame is null");
            return (Criteria) this;
        }

        public Criteria andCandidateFameIsNotNull() {
            addCriterion("candidate_fame is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateFameEqualTo(String value) {
            addCriterion("candidate_fame =", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameNotEqualTo(String value) {
            addCriterion("candidate_fame <>", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameGreaterThan(String value) {
            addCriterion("candidate_fame >", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_fame >=", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameLessThan(String value) {
            addCriterion("candidate_fame <", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameLessThanOrEqualTo(String value) {
            addCriterion("candidate_fame <=", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameLike(String value) {
            addCriterion("candidate_fame like", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameNotLike(String value) {
            addCriterion("candidate_fame not like", value, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameIn(List<String> values) {
            addCriterion("candidate_fame in", values, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameNotIn(List<String> values) {
            addCriterion("candidate_fame not in", values, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameBetween(String value1, String value2) {
            addCriterion("candidate_fame between", value1, value2, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidateFameNotBetween(String value1, String value2) {
            addCriterion("candidate_fame not between", value1, value2, "candidateFame");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusIsNull() {
            addCriterion("candidateStatus is null");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusIsNotNull() {
            addCriterion("candidateStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusEqualTo(Byte value) {
            addCriterion("candidateStatus =", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusNotEqualTo(Byte value) {
            addCriterion("candidateStatus <>", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusGreaterThan(Byte value) {
            addCriterion("candidateStatus >", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("candidateStatus >=", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusLessThan(Byte value) {
            addCriterion("candidateStatus <", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusLessThanOrEqualTo(Byte value) {
            addCriterion("candidateStatus <=", value, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusIn(List<Byte> values) {
            addCriterion("candidateStatus in", values, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusNotIn(List<Byte> values) {
            addCriterion("candidateStatus not in", values, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusBetween(Byte value1, Byte value2) {
            addCriterion("candidateStatus between", value1, value2, "candidatestatus");
            return (Criteria) this;
        }

        public Criteria andCandidatestatusNotBetween(Byte value1, Byte value2) {
            addCriterion("candidateStatus not between", value1, value2, "candidatestatus");
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