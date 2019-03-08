package com.sqc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugExample() {
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

        public Criteria andDrugNameIsNull() {
            addCriterion("drug_name is null");
            return (Criteria) this;
        }

        public Criteria andDrugNameIsNotNull() {
            addCriterion("drug_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrugNameEqualTo(String value) {
            addCriterion("drug_name =", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotEqualTo(String value) {
            addCriterion("drug_name <>", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThan(String value) {
            addCriterion("drug_name >", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("drug_name >=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThan(String value) {
            addCriterion("drug_name <", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLessThanOrEqualTo(String value) {
            addCriterion("drug_name <=", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameLike(String value) {
            addCriterion("drug_name like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotLike(String value) {
            addCriterion("drug_name not like", value, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameIn(List<String> values) {
            addCriterion("drug_name in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotIn(List<String> values) {
            addCriterion("drug_name not in", values, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameBetween(String value1, String value2) {
            addCriterion("drug_name between", value1, value2, "drugName");
            return (Criteria) this;
        }

        public Criteria andDrugNameNotBetween(String value1, String value2) {
            addCriterion("drug_name not between", value1, value2, "drugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameIsNull() {
            addCriterion("common_drug_name is null");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameIsNotNull() {
            addCriterion("common_drug_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameEqualTo(String value) {
            addCriterion("common_drug_name =", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameNotEqualTo(String value) {
            addCriterion("common_drug_name <>", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameGreaterThan(String value) {
            addCriterion("common_drug_name >", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameGreaterThanOrEqualTo(String value) {
            addCriterion("common_drug_name >=", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameLessThan(String value) {
            addCriterion("common_drug_name <", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameLessThanOrEqualTo(String value) {
            addCriterion("common_drug_name <=", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameLike(String value) {
            addCriterion("common_drug_name like", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameNotLike(String value) {
            addCriterion("common_drug_name not like", value, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameIn(List<String> values) {
            addCriterion("common_drug_name in", values, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameNotIn(List<String> values) {
            addCriterion("common_drug_name not in", values, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameBetween(String value1, String value2) {
            addCriterion("common_drug_name between", value1, value2, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andCommonDrugNameNotBetween(String value1, String value2) {
            addCriterion("common_drug_name not between", value1, value2, "commonDrugName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("english_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("english_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("english_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("english_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("english_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("english_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNull() {
            addCriterion("dosage_form is null");
            return (Criteria) this;
        }

        public Criteria andDosageFormIsNotNull() {
            addCriterion("dosage_form is not null");
            return (Criteria) this;
        }

        public Criteria andDosageFormEqualTo(String value) {
            addCriterion("dosage_form =", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotEqualTo(String value) {
            addCriterion("dosage_form <>", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThan(String value) {
            addCriterion("dosage_form >", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormGreaterThanOrEqualTo(String value) {
            addCriterion("dosage_form >=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThan(String value) {
            addCriterion("dosage_form <", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLessThanOrEqualTo(String value) {
            addCriterion("dosage_form <=", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormLike(String value) {
            addCriterion("dosage_form like", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotLike(String value) {
            addCriterion("dosage_form not like", value, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormIn(List<String> values) {
            addCriterion("dosage_form in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotIn(List<String> values) {
            addCriterion("dosage_form not in", values, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormBetween(String value1, String value2) {
            addCriterion("dosage_form between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andDosageFormNotBetween(String value1, String value2) {
            addCriterion("dosage_form not between", value1, value2, "dosageForm");
            return (Criteria) this;
        }

        public Criteria andAtcCodeIsNull() {
            addCriterion("atc_code is null");
            return (Criteria) this;
        }

        public Criteria andAtcCodeIsNotNull() {
            addCriterion("atc_code is not null");
            return (Criteria) this;
        }

        public Criteria andAtcCodeEqualTo(String value) {
            addCriterion("atc_code =", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeNotEqualTo(String value) {
            addCriterion("atc_code <>", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeGreaterThan(String value) {
            addCriterion("atc_code >", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("atc_code >=", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeLessThan(String value) {
            addCriterion("atc_code <", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeLessThanOrEqualTo(String value) {
            addCriterion("atc_code <=", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeLike(String value) {
            addCriterion("atc_code like", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeNotLike(String value) {
            addCriterion("atc_code not like", value, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeIn(List<String> values) {
            addCriterion("atc_code in", values, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeNotIn(List<String> values) {
            addCriterion("atc_code not in", values, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeBetween(String value1, String value2) {
            addCriterion("atc_code between", value1, value2, "atcCode");
            return (Criteria) this;
        }

        public Criteria andAtcCodeNotBetween(String value1, String value2) {
            addCriterion("atc_code not between", value1, value2, "atcCode");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approval_number is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approval_number is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approval_number =", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approval_number <>", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approval_number >", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approval_number >=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approval_number <", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approval_number <=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approval_number like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approval_number not like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIn(List<String> values) {
            addCriterion("approval_number in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotIn(List<String> values) {
            addCriterion("approval_number not in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approval_number between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approval_number not between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityIsNull() {
            addCriterion("approval_validity is null");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityIsNotNull() {
            addCriterion("approval_validity is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityEqualTo(Date value) {
            addCriterionForJDBCDate("approval_validity =", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityNotEqualTo(Date value) {
            addCriterionForJDBCDate("approval_validity <>", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityGreaterThan(Date value) {
            addCriterionForJDBCDate("approval_validity >", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approval_validity >=", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityLessThan(Date value) {
            addCriterionForJDBCDate("approval_validity <", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approval_validity <=", value, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityIn(List<Date> values) {
            addCriterionForJDBCDate("approval_validity in", values, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityNotIn(List<Date> values) {
            addCriterionForJDBCDate("approval_validity not in", values, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approval_validity between", value1, value2, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andApprovalValidityNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approval_validity not between", value1, value2, "approvalValidity");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNull() {
            addCriterion("specifications is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIsNotNull() {
            addCriterion("specifications is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationsEqualTo(Float value) {
            addCriterion("specifications =", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotEqualTo(Float value) {
            addCriterion("specifications <>", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThan(Float value) {
            addCriterion("specifications >", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsGreaterThanOrEqualTo(Float value) {
            addCriterion("specifications >=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThan(Float value) {
            addCriterion("specifications <", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsLessThanOrEqualTo(Float value) {
            addCriterion("specifications <=", value, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsIn(List<Float> values) {
            addCriterion("specifications in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotIn(List<Float> values) {
            addCriterion("specifications not in", values, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsBetween(Float value1, Float value2) {
            addCriterion("specifications between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecificationsNotBetween(Float value1, Float value2) {
            addCriterion("specifications not between", value1, value2, "specifications");
            return (Criteria) this;
        }

        public Criteria andSpecUnitIsNull() {
            addCriterion("spec_unit is null");
            return (Criteria) this;
        }

        public Criteria andSpecUnitIsNotNull() {
            addCriterion("spec_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSpecUnitEqualTo(String value) {
            addCriterion("spec_unit =", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitNotEqualTo(String value) {
            addCriterion("spec_unit <>", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitGreaterThan(String value) {
            addCriterion("spec_unit >", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitGreaterThanOrEqualTo(String value) {
            addCriterion("spec_unit >=", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitLessThan(String value) {
            addCriterion("spec_unit <", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitLessThanOrEqualTo(String value) {
            addCriterion("spec_unit <=", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitLike(String value) {
            addCriterion("spec_unit like", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitNotLike(String value) {
            addCriterion("spec_unit not like", value, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitIn(List<String> values) {
            addCriterion("spec_unit in", values, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitNotIn(List<String> values) {
            addCriterion("spec_unit not in", values, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitBetween(String value1, String value2) {
            addCriterion("spec_unit between", value1, value2, "specUnit");
            return (Criteria) this;
        }

        public Criteria andSpecUnitNotBetween(String value1, String value2) {
            addCriterion("spec_unit not between", value1, value2, "specUnit");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNull() {
            addCriterion("numbers is null");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNotNull() {
            addCriterion("numbers is not null");
            return (Criteria) this;
        }

        public Criteria andNumbersEqualTo(Byte value) {
            addCriterion("numbers =", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotEqualTo(Byte value) {
            addCriterion("numbers <>", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThan(Byte value) {
            addCriterion("numbers >", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThanOrEqualTo(Byte value) {
            addCriterion("numbers >=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThan(Byte value) {
            addCriterion("numbers <", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThanOrEqualTo(Byte value) {
            addCriterion("numbers <=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersIn(List<Byte> values) {
            addCriterion("numbers in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotIn(List<Byte> values) {
            addCriterion("numbers not in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersBetween(Byte value1, Byte value2) {
            addCriterion("numbers between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotBetween(Byte value1, Byte value2) {
            addCriterion("numbers not between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumUnitIsNull() {
            addCriterion("num_unit is null");
            return (Criteria) this;
        }

        public Criteria andNumUnitIsNotNull() {
            addCriterion("num_unit is not null");
            return (Criteria) this;
        }

        public Criteria andNumUnitEqualTo(String value) {
            addCriterion("num_unit =", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitNotEqualTo(String value) {
            addCriterion("num_unit <>", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitGreaterThan(String value) {
            addCriterion("num_unit >", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitGreaterThanOrEqualTo(String value) {
            addCriterion("num_unit >=", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitLessThan(String value) {
            addCriterion("num_unit <", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitLessThanOrEqualTo(String value) {
            addCriterion("num_unit <=", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitLike(String value) {
            addCriterion("num_unit like", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitNotLike(String value) {
            addCriterion("num_unit not like", value, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitIn(List<String> values) {
            addCriterion("num_unit in", values, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitNotIn(List<String> values) {
            addCriterion("num_unit not in", values, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitBetween(String value1, String value2) {
            addCriterion("num_unit between", value1, value2, "numUnit");
            return (Criteria) this;
        }

        public Criteria andNumUnitNotBetween(String value1, String value2) {
            addCriterion("num_unit not between", value1, value2, "numUnit");
            return (Criteria) this;
        }

        public Criteria andDddIsNull() {
            addCriterion("ddd is null");
            return (Criteria) this;
        }

        public Criteria andDddIsNotNull() {
            addCriterion("ddd is not null");
            return (Criteria) this;
        }

        public Criteria andDddEqualTo(Float value) {
            addCriterion("ddd =", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddNotEqualTo(Float value) {
            addCriterion("ddd <>", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddGreaterThan(Float value) {
            addCriterion("ddd >", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddGreaterThanOrEqualTo(Float value) {
            addCriterion("ddd >=", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddLessThan(Float value) {
            addCriterion("ddd <", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddLessThanOrEqualTo(Float value) {
            addCriterion("ddd <=", value, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddIn(List<Float> values) {
            addCriterion("ddd in", values, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddNotIn(List<Float> values) {
            addCriterion("ddd not in", values, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddBetween(Float value1, Float value2) {
            addCriterion("ddd between", value1, value2, "ddd");
            return (Criteria) this;
        }

        public Criteria andDddNotBetween(Float value1, Float value2) {
            addCriterion("ddd not between", value1, value2, "ddd");
            return (Criteria) this;
        }

        public Criteria andCategIdIsNull() {
            addCriterion("categ_id is null");
            return (Criteria) this;
        }

        public Criteria andCategIdIsNotNull() {
            addCriterion("categ_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategIdEqualTo(String value) {
            addCriterion("categ_id =", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdNotEqualTo(String value) {
            addCriterion("categ_id <>", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdGreaterThan(String value) {
            addCriterion("categ_id >", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdGreaterThanOrEqualTo(String value) {
            addCriterion("categ_id >=", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdLessThan(String value) {
            addCriterion("categ_id <", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdLessThanOrEqualTo(String value) {
            addCriterion("categ_id <=", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdLike(String value) {
            addCriterion("categ_id like", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdNotLike(String value) {
            addCriterion("categ_id not like", value, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdIn(List<String> values) {
            addCriterion("categ_id in", values, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdNotIn(List<String> values) {
            addCriterion("categ_id not in", values, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdBetween(String value1, String value2) {
            addCriterion("categ_id between", value1, value2, "categId");
            return (Criteria) this;
        }

        public Criteria andCategIdNotBetween(String value1, String value2) {
            addCriterion("categ_id not between", value1, value2, "categId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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