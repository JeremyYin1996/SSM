package com.sqc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ManufacturerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManufacturerExample() {
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

        public Criteria andManuIdIsNull() {
            addCriterion("manu_id is null");
            return (Criteria) this;
        }

        public Criteria andManuIdIsNotNull() {
            addCriterion("manu_id is not null");
            return (Criteria) this;
        }

        public Criteria andManuIdEqualTo(String value) {
            addCriterion("manu_id =", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdNotEqualTo(String value) {
            addCriterion("manu_id <>", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdGreaterThan(String value) {
            addCriterion("manu_id >", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdGreaterThanOrEqualTo(String value) {
            addCriterion("manu_id >=", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdLessThan(String value) {
            addCriterion("manu_id <", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdLessThanOrEqualTo(String value) {
            addCriterion("manu_id <=", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdLike(String value) {
            addCriterion("manu_id like", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdNotLike(String value) {
            addCriterion("manu_id not like", value, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdIn(List<String> values) {
            addCriterion("manu_id in", values, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdNotIn(List<String> values) {
            addCriterion("manu_id not in", values, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdBetween(String value1, String value2) {
            addCriterion("manu_id between", value1, value2, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuIdNotBetween(String value1, String value2) {
            addCriterion("manu_id not between", value1, value2, "manuId");
            return (Criteria) this;
        }

        public Criteria andManuNameIsNull() {
            addCriterion("manu_name is null");
            return (Criteria) this;
        }

        public Criteria andManuNameIsNotNull() {
            addCriterion("manu_name is not null");
            return (Criteria) this;
        }

        public Criteria andManuNameEqualTo(String value) {
            addCriterion("manu_name =", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameNotEqualTo(String value) {
            addCriterion("manu_name <>", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameGreaterThan(String value) {
            addCriterion("manu_name >", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameGreaterThanOrEqualTo(String value) {
            addCriterion("manu_name >=", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameLessThan(String value) {
            addCriterion("manu_name <", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameLessThanOrEqualTo(String value) {
            addCriterion("manu_name <=", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameLike(String value) {
            addCriterion("manu_name like", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameNotLike(String value) {
            addCriterion("manu_name not like", value, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameIn(List<String> values) {
            addCriterion("manu_name in", values, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameNotIn(List<String> values) {
            addCriterion("manu_name not in", values, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameBetween(String value1, String value2) {
            addCriterion("manu_name between", value1, value2, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuNameNotBetween(String value1, String value2) {
            addCriterion("manu_name not between", value1, value2, "manuName");
            return (Criteria) this;
        }

        public Criteria andManuAdressIsNull() {
            addCriterion("manu_adress is null");
            return (Criteria) this;
        }

        public Criteria andManuAdressIsNotNull() {
            addCriterion("manu_adress is not null");
            return (Criteria) this;
        }

        public Criteria andManuAdressEqualTo(String value) {
            addCriterion("manu_adress =", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressNotEqualTo(String value) {
            addCriterion("manu_adress <>", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressGreaterThan(String value) {
            addCriterion("manu_adress >", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressGreaterThanOrEqualTo(String value) {
            addCriterion("manu_adress >=", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressLessThan(String value) {
            addCriterion("manu_adress <", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressLessThanOrEqualTo(String value) {
            addCriterion("manu_adress <=", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressLike(String value) {
            addCriterion("manu_adress like", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressNotLike(String value) {
            addCriterion("manu_adress not like", value, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressIn(List<String> values) {
            addCriterion("manu_adress in", values, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressNotIn(List<String> values) {
            addCriterion("manu_adress not in", values, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressBetween(String value1, String value2) {
            addCriterion("manu_adress between", value1, value2, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuAdressNotBetween(String value1, String value2) {
            addCriterion("manu_adress not between", value1, value2, "manuAdress");
            return (Criteria) this;
        }

        public Criteria andManuPhoneIsNull() {
            addCriterion("manu_phone is null");
            return (Criteria) this;
        }

        public Criteria andManuPhoneIsNotNull() {
            addCriterion("manu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andManuPhoneEqualTo(String value) {
            addCriterion("manu_phone =", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneNotEqualTo(String value) {
            addCriterion("manu_phone <>", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneGreaterThan(String value) {
            addCriterion("manu_phone >", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("manu_phone >=", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneLessThan(String value) {
            addCriterion("manu_phone <", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneLessThanOrEqualTo(String value) {
            addCriterion("manu_phone <=", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneLike(String value) {
            addCriterion("manu_phone like", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneNotLike(String value) {
            addCriterion("manu_phone not like", value, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneIn(List<String> values) {
            addCriterion("manu_phone in", values, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneNotIn(List<String> values) {
            addCriterion("manu_phone not in", values, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneBetween(String value1, String value2) {
            addCriterion("manu_phone between", value1, value2, "manuPhone");
            return (Criteria) this;
        }

        public Criteria andManuPhoneNotBetween(String value1, String value2) {
            addCriterion("manu_phone not between", value1, value2, "manuPhone");
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