package com.sofency.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class EngineerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EngineerExample() {
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

        public Criteria andEngineerNameIsNull() {
            addCriterion("engineer_name is null");
            return (Criteria) this;
        }

        public Criteria andEngineerNameIsNotNull() {
            addCriterion("engineer_name is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerNameEqualTo(String value) {
            addCriterion("engineer_name =", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotEqualTo(String value) {
            addCriterion("engineer_name <>", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameGreaterThan(String value) {
            addCriterion("engineer_name >", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_name >=", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLessThan(String value) {
            addCriterion("engineer_name <", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLessThanOrEqualTo(String value) {
            addCriterion("engineer_name <=", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameLike(String value) {
            addCriterion("engineer_name like", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotLike(String value) {
            addCriterion("engineer_name not like", value, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameIn(List<String> values) {
            addCriterion("engineer_name in", values, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotIn(List<String> values) {
            addCriterion("engineer_name not in", values, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameBetween(String value1, String value2) {
            addCriterion("engineer_name between", value1, value2, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerNameNotBetween(String value1, String value2) {
            addCriterion("engineer_name not between", value1, value2, "engineerName");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathIsNull() {
            addCriterion("engineer_imgPath is null");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathIsNotNull() {
            addCriterion("engineer_imgPath is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathEqualTo(String value) {
            addCriterion("engineer_imgPath =", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathNotEqualTo(String value) {
            addCriterion("engineer_imgPath <>", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathGreaterThan(String value) {
            addCriterion("engineer_imgPath >", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_imgPath >=", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathLessThan(String value) {
            addCriterion("engineer_imgPath <", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathLessThanOrEqualTo(String value) {
            addCriterion("engineer_imgPath <=", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathLike(String value) {
            addCriterion("engineer_imgPath like", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathNotLike(String value) {
            addCriterion("engineer_imgPath not like", value, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathIn(List<String> values) {
            addCriterion("engineer_imgPath in", values, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathNotIn(List<String> values) {
            addCriterion("engineer_imgPath not in", values, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathBetween(String value1, String value2) {
            addCriterion("engineer_imgPath between", value1, value2, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerImgpathNotBetween(String value1, String value2) {
            addCriterion("engineer_imgPath not between", value1, value2, "engineerImgpath");
            return (Criteria) this;
        }

        public Criteria andEngineerSexIsNull() {
            addCriterion("engineer_sex is null");
            return (Criteria) this;
        }

        public Criteria andEngineerSexIsNotNull() {
            addCriterion("engineer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerSexEqualTo(String value) {
            addCriterion("engineer_sex =", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexNotEqualTo(String value) {
            addCriterion("engineer_sex <>", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexGreaterThan(String value) {
            addCriterion("engineer_sex >", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_sex >=", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexLessThan(String value) {
            addCriterion("engineer_sex <", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexLessThanOrEqualTo(String value) {
            addCriterion("engineer_sex <=", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexLike(String value) {
            addCriterion("engineer_sex like", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexNotLike(String value) {
            addCriterion("engineer_sex not like", value, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexIn(List<String> values) {
            addCriterion("engineer_sex in", values, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexNotIn(List<String> values) {
            addCriterion("engineer_sex not in", values, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexBetween(String value1, String value2) {
            addCriterion("engineer_sex between", value1, value2, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerSexNotBetween(String value1, String value2) {
            addCriterion("engineer_sex not between", value1, value2, "engineerSex");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIsNull() {
            addCriterion("engineer_tel is null");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIsNotNull() {
            addCriterion("engineer_tel is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerTelEqualTo(String value) {
            addCriterion("engineer_tel =", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotEqualTo(String value) {
            addCriterion("engineer_tel <>", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelGreaterThan(String value) {
            addCriterion("engineer_tel >", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_tel >=", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLessThan(String value) {
            addCriterion("engineer_tel <", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLessThanOrEqualTo(String value) {
            addCriterion("engineer_tel <=", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelLike(String value) {
            addCriterion("engineer_tel like", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotLike(String value) {
            addCriterion("engineer_tel not like", value, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelIn(List<String> values) {
            addCriterion("engineer_tel in", values, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotIn(List<String> values) {
            addCriterion("engineer_tel not in", values, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelBetween(String value1, String value2) {
            addCriterion("engineer_tel between", value1, value2, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerTelNotBetween(String value1, String value2) {
            addCriterion("engineer_tel not between", value1, value2, "engineerTel");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailIsNull() {
            addCriterion("engineer_email is null");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailIsNotNull() {
            addCriterion("engineer_email is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailEqualTo(String value) {
            addCriterion("engineer_email =", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailNotEqualTo(String value) {
            addCriterion("engineer_email <>", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailGreaterThan(String value) {
            addCriterion("engineer_email >", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_email >=", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailLessThan(String value) {
            addCriterion("engineer_email <", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailLessThanOrEqualTo(String value) {
            addCriterion("engineer_email <=", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailLike(String value) {
            addCriterion("engineer_email like", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailNotLike(String value) {
            addCriterion("engineer_email not like", value, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailIn(List<String> values) {
            addCriterion("engineer_email in", values, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailNotIn(List<String> values) {
            addCriterion("engineer_email not in", values, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailBetween(String value1, String value2) {
            addCriterion("engineer_email between", value1, value2, "engineerEmail");
            return (Criteria) this;
        }

        public Criteria andEngineerEmailNotBetween(String value1, String value2) {
            addCriterion("engineer_email not between", value1, value2, "engineerEmail");
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
            addCriterion("majorid is null");
            return (Criteria) this;
        }

        public Criteria andMajoridIsNotNull() {
            addCriterion("majorid is not null");
            return (Criteria) this;
        }

        public Criteria andMajoridEqualTo(Integer value) {
            addCriterion("majorid =", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotEqualTo(Integer value) {
            addCriterion("majorid <>", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridGreaterThan(Integer value) {
            addCriterion("majorid >", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("majorid >=", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridLessThan(Integer value) {
            addCriterion("majorid <", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridLessThanOrEqualTo(Integer value) {
            addCriterion("majorid <=", value, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridIn(List<Integer> values) {
            addCriterion("majorid in", values, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotIn(List<Integer> values) {
            addCriterion("majorid not in", values, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridBetween(Integer value1, Integer value2) {
            addCriterion("majorid between", value1, value2, "majorid");
            return (Criteria) this;
        }

        public Criteria andMajoridNotBetween(Integer value1, Integer value2) {
            addCriterion("majorid not between", value1, value2, "majorid");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoIsNull() {
            addCriterion("engineer_motto is null");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoIsNotNull() {
            addCriterion("engineer_motto is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoEqualTo(String value) {
            addCriterion("engineer_motto =", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoNotEqualTo(String value) {
            addCriterion("engineer_motto <>", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoGreaterThan(String value) {
            addCriterion("engineer_motto >", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_motto >=", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoLessThan(String value) {
            addCriterion("engineer_motto <", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoLessThanOrEqualTo(String value) {
            addCriterion("engineer_motto <=", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoLike(String value) {
            addCriterion("engineer_motto like", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoNotLike(String value) {
            addCriterion("engineer_motto not like", value, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoIn(List<String> values) {
            addCriterion("engineer_motto in", values, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoNotIn(List<String> values) {
            addCriterion("engineer_motto not in", values, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoBetween(String value1, String value2) {
            addCriterion("engineer_motto between", value1, value2, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerMottoNotBetween(String value1, String value2) {
            addCriterion("engineer_motto not between", value1, value2, "engineerMotto");
            return (Criteria) this;
        }

        public Criteria andEngineerGitIsNull() {
            addCriterion("engineer_git is null");
            return (Criteria) this;
        }

        public Criteria andEngineerGitIsNotNull() {
            addCriterion("engineer_git is not null");
            return (Criteria) this;
        }

        public Criteria andEngineerGitEqualTo(String value) {
            addCriterion("engineer_git =", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitNotEqualTo(String value) {
            addCriterion("engineer_git <>", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitGreaterThan(String value) {
            addCriterion("engineer_git >", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitGreaterThanOrEqualTo(String value) {
            addCriterion("engineer_git >=", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitLessThan(String value) {
            addCriterion("engineer_git <", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitLessThanOrEqualTo(String value) {
            addCriterion("engineer_git <=", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitLike(String value) {
            addCriterion("engineer_git like", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitNotLike(String value) {
            addCriterion("engineer_git not like", value, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitIn(List<String> values) {
            addCriterion("engineer_git in", values, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitNotIn(List<String> values) {
            addCriterion("engineer_git not in", values, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitBetween(String value1, String value2) {
            addCriterion("engineer_git between", value1, value2, "engineerGit");
            return (Criteria) this;
        }

        public Criteria andEngineerGitNotBetween(String value1, String value2) {
            addCriterion("engineer_git not between", value1, value2, "engineerGit");
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