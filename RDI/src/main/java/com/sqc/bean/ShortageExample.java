package com.sqc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShortageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShortageExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNull() {
            addCriterion("drug_id is null");
            return (Criteria) this;
        }

        public Criteria andDrugIdIsNotNull() {
            addCriterion("drug_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIdEqualTo(String value) {
            addCriterion("drug_id =", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotEqualTo(String value) {
            addCriterion("drug_id <>", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThan(String value) {
            addCriterion("drug_id >", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdGreaterThanOrEqualTo(String value) {
            addCriterion("drug_id >=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThan(String value) {
            addCriterion("drug_id <", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLessThanOrEqualTo(String value) {
            addCriterion("drug_id <=", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdLike(String value) {
            addCriterion("drug_id like", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotLike(String value) {
            addCriterion("drug_id not like", value, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdIn(List<String> values) {
            addCriterion("drug_id in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotIn(List<String> values) {
            addCriterion("drug_id not in", values, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdBetween(String value1, String value2) {
            addCriterion("drug_id between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andDrugIdNotBetween(String value1, String value2) {
            addCriterion("drug_id not between", value1, value2, "drugId");
            return (Criteria) this;
        }

        public Criteria andPharmIdIsNull() {
            addCriterion("pharm_id is null");
            return (Criteria) this;
        }

        public Criteria andPharmIdIsNotNull() {
            addCriterion("pharm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPharmIdEqualTo(String value) {
            addCriterion("pharm_id =", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdNotEqualTo(String value) {
            addCriterion("pharm_id <>", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdGreaterThan(String value) {
            addCriterion("pharm_id >", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdGreaterThanOrEqualTo(String value) {
            addCriterion("pharm_id >=", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdLessThan(String value) {
            addCriterion("pharm_id <", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdLessThanOrEqualTo(String value) {
            addCriterion("pharm_id <=", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdLike(String value) {
            addCriterion("pharm_id like", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdNotLike(String value) {
            addCriterion("pharm_id not like", value, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdIn(List<String> values) {
            addCriterion("pharm_id in", values, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdNotIn(List<String> values) {
            addCriterion("pharm_id not in", values, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdBetween(String value1, String value2) {
            addCriterion("pharm_id between", value1, value2, "pharmId");
            return (Criteria) this;
        }

        public Criteria andPharmIdNotBetween(String value1, String value2) {
            addCriterion("pharm_id not between", value1, value2, "pharmId");
            return (Criteria) this;
        }

        public Criteria andShortNumIsNull() {
            addCriterion("short_num is null");
            return (Criteria) this;
        }

        public Criteria andShortNumIsNotNull() {
            addCriterion("short_num is not null");
            return (Criteria) this;
        }

        public Criteria andShortNumEqualTo(Integer value) {
            addCriterion("short_num =", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumNotEqualTo(Integer value) {
            addCriterion("short_num <>", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumGreaterThan(Integer value) {
            addCriterion("short_num >", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("short_num >=", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumLessThan(Integer value) {
            addCriterion("short_num <", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumLessThanOrEqualTo(Integer value) {
            addCriterion("short_num <=", value, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumIn(List<Integer> values) {
            addCriterion("short_num in", values, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumNotIn(List<Integer> values) {
            addCriterion("short_num not in", values, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumBetween(Integer value1, Integer value2) {
            addCriterion("short_num between", value1, value2, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortNumNotBetween(Integer value1, Integer value2) {
            addCriterion("short_num not between", value1, value2, "shortNum");
            return (Criteria) this;
        }

        public Criteria andShortDateIsNull() {
            addCriterion("short_date is null");
            return (Criteria) this;
        }

        public Criteria andShortDateIsNotNull() {
            addCriterion("short_date is not null");
            return (Criteria) this;
        }

        public Criteria andShortDateEqualTo(Date value) {
            addCriterionForJDBCDate("short_date =", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("short_date <>", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateGreaterThan(Date value) {
            addCriterionForJDBCDate("short_date >", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("short_date >=", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateLessThan(Date value) {
            addCriterionForJDBCDate("short_date <", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("short_date <=", value, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateIn(List<Date> values) {
            addCriterionForJDBCDate("short_date in", values, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("short_date not in", values, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("short_date between", value1, value2, "shortDate");
            return (Criteria) this;
        }

        public Criteria andShortDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("short_date not between", value1, value2, "shortDate");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterionForJDBCDate("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterionForJDBCDate("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterionForJDBCDate("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddUserIsNull() {
            addCriterion("add_user is null");
            return (Criteria) this;
        }

        public Criteria andAddUserIsNotNull() {
            addCriterion("add_user is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserEqualTo(String value) {
            addCriterion("add_user =", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotEqualTo(String value) {
            addCriterion("add_user <>", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThan(String value) {
            addCriterion("add_user >", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThanOrEqualTo(String value) {
            addCriterion("add_user >=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThan(String value) {
            addCriterion("add_user <", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThanOrEqualTo(String value) {
            addCriterion("add_user <=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLike(String value) {
            addCriterion("add_user like", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotLike(String value) {
            addCriterion("add_user not like", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserIn(List<String> values) {
            addCriterion("add_user in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotIn(List<String> values) {
            addCriterion("add_user not in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserBetween(String value1, String value2) {
            addCriterion("add_user between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotBetween(String value1, String value2) {
            addCriterion("add_user not between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andIfDeletedIsNull() {
            addCriterion("if_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIfDeletedIsNotNull() {
            addCriterion("if_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIfDeletedEqualTo(Boolean value) {
            addCriterion("if_deleted =", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedNotEqualTo(Boolean value) {
            addCriterion("if_deleted <>", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedGreaterThan(Boolean value) {
            addCriterion("if_deleted >", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("if_deleted >=", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedLessThan(Boolean value) {
            addCriterion("if_deleted <", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("if_deleted <=", value, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedIn(List<Boolean> values) {
            addCriterion("if_deleted in", values, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedNotIn(List<Boolean> values) {
            addCriterion("if_deleted not in", values, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("if_deleted between", value1, value2, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andIfDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("if_deleted not between", value1, value2, "ifDeleted");
            return (Criteria) this;
        }

        public Criteria andDeleteUserIsNull() {
            addCriterion("delete_user is null");
            return (Criteria) this;
        }

        public Criteria andDeleteUserIsNotNull() {
            addCriterion("delete_user is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteUserEqualTo(String value) {
            addCriterion("delete_user =", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserNotEqualTo(String value) {
            addCriterion("delete_user <>", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserGreaterThan(String value) {
            addCriterion("delete_user >", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserGreaterThanOrEqualTo(String value) {
            addCriterion("delete_user >=", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserLessThan(String value) {
            addCriterion("delete_user <", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserLessThanOrEqualTo(String value) {
            addCriterion("delete_user <=", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserLike(String value) {
            addCriterion("delete_user like", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserNotLike(String value) {
            addCriterion("delete_user not like", value, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserIn(List<String> values) {
            addCriterion("delete_user in", values, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserNotIn(List<String> values) {
            addCriterion("delete_user not in", values, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserBetween(String value1, String value2) {
            addCriterion("delete_user between", value1, value2, "deleteUser");
            return (Criteria) this;
        }

        public Criteria andDeleteUserNotBetween(String value1, String value2) {
            addCriterion("delete_user not between", value1, value2, "deleteUser");
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