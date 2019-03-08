package com.sqc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PharmacyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PharmacyExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPharmNameIsNull() {
            addCriterion("pharm_name is null");
            return (Criteria) this;
        }

        public Criteria andPharmNameIsNotNull() {
            addCriterion("pharm_name is not null");
            return (Criteria) this;
        }

        public Criteria andPharmNameEqualTo(String value) {
            addCriterion("pharm_name =", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameNotEqualTo(String value) {
            addCriterion("pharm_name <>", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameGreaterThan(String value) {
            addCriterion("pharm_name >", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameGreaterThanOrEqualTo(String value) {
            addCriterion("pharm_name >=", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameLessThan(String value) {
            addCriterion("pharm_name <", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameLessThanOrEqualTo(String value) {
            addCriterion("pharm_name <=", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameLike(String value) {
            addCriterion("pharm_name like", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameNotLike(String value) {
            addCriterion("pharm_name not like", value, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameIn(List<String> values) {
            addCriterion("pharm_name in", values, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameNotIn(List<String> values) {
            addCriterion("pharm_name not in", values, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameBetween(String value1, String value2) {
            addCriterion("pharm_name between", value1, value2, "pharmName");
            return (Criteria) this;
        }

        public Criteria andPharmNameNotBetween(String value1, String value2) {
            addCriterion("pharm_name not between", value1, value2, "pharmName");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPharmAddressIsNull() {
            addCriterion("pharm_address is null");
            return (Criteria) this;
        }

        public Criteria andPharmAddressIsNotNull() {
            addCriterion("pharm_address is not null");
            return (Criteria) this;
        }

        public Criteria andPharmAddressEqualTo(String value) {
            addCriterion("pharm_address =", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressNotEqualTo(String value) {
            addCriterion("pharm_address <>", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressGreaterThan(String value) {
            addCriterion("pharm_address >", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pharm_address >=", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressLessThan(String value) {
            addCriterion("pharm_address <", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressLessThanOrEqualTo(String value) {
            addCriterion("pharm_address <=", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressLike(String value) {
            addCriterion("pharm_address like", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressNotLike(String value) {
            addCriterion("pharm_address not like", value, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressIn(List<String> values) {
            addCriterion("pharm_address in", values, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressNotIn(List<String> values) {
            addCriterion("pharm_address not in", values, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressBetween(String value1, String value2) {
            addCriterion("pharm_address between", value1, value2, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andPharmAddressNotBetween(String value1, String value2) {
            addCriterion("pharm_address not between", value1, value2, "pharmAddress");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(String value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(String value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(String value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(String value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(String value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(String value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLike(String value) {
            addCriterion("district_id like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotLike(String value) {
            addCriterion("district_id not like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<String> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<String> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(String value1, String value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(String value1, String value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
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