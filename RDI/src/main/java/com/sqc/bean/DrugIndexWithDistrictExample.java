package com.sqc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DrugIndexWithDistrictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugIndexWithDistrictExample() {
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

        public Criteria andDrugIndexIsNull() {
            addCriterion("drug_index is null");
            return (Criteria) this;
        }

        public Criteria andDrugIndexIsNotNull() {
            addCriterion("drug_index is not null");
            return (Criteria) this;
        }

        public Criteria andDrugIndexEqualTo(Float value) {
            addCriterion("drug_index =", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexNotEqualTo(Float value) {
            addCriterion("drug_index <>", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexGreaterThan(Float value) {
            addCriterion("drug_index >", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexGreaterThanOrEqualTo(Float value) {
            addCriterion("drug_index >=", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexLessThan(Float value) {
            addCriterion("drug_index <", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexLessThanOrEqualTo(Float value) {
            addCriterion("drug_index <=", value, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexIn(List<Float> values) {
            addCriterion("drug_index in", values, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexNotIn(List<Float> values) {
            addCriterion("drug_index not in", values, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexBetween(Float value1, Float value2) {
            addCriterion("drug_index between", value1, value2, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andDrugIndexNotBetween(Float value1, Float value2) {
            addCriterion("drug_index not between", value1, value2, "drugIndex");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNull() {
            addCriterion("avg_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNotNull() {
            addCriterion("avg_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceEqualTo(Float value) {
            addCriterion("avg_price =", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotEqualTo(Float value) {
            addCriterion("avg_price <>", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThan(Float value) {
            addCriterion("avg_price >", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("avg_price >=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThan(Float value) {
            addCriterion("avg_price <", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThanOrEqualTo(Float value) {
            addCriterion("avg_price <=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIn(List<Float> values) {
            addCriterion("avg_price in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotIn(List<Float> values) {
            addCriterion("avg_price not in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceBetween(Float value1, Float value2) {
            addCriterion("avg_price between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotBetween(Float value1, Float value2) {
            addCriterion("avg_price not between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Float value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Float value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Float value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Float value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Float value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Float> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Float> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Float value1, Float value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Float value1, Float value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andSalesIsNull() {
            addCriterion("sales is null");
            return (Criteria) this;
        }

        public Criteria andSalesIsNotNull() {
            addCriterion("sales is not null");
            return (Criteria) this;
        }

        public Criteria andSalesEqualTo(Float value) {
            addCriterion("sales =", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotEqualTo(Float value) {
            addCriterion("sales <>", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThan(Float value) {
            addCriterion("sales >", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesGreaterThanOrEqualTo(Float value) {
            addCriterion("sales >=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThan(Float value) {
            addCriterion("sales <", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesLessThanOrEqualTo(Float value) {
            addCriterion("sales <=", value, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesIn(List<Float> values) {
            addCriterion("sales in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotIn(List<Float> values) {
            addCriterion("sales not in", values, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesBetween(Float value1, Float value2) {
            addCriterion("sales between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andSalesNotBetween(Float value1, Float value2) {
            addCriterion("sales not between", value1, value2, "sales");
            return (Criteria) this;
        }

        public Criteria andStatisDateIsNull() {
            addCriterion("statis_date is null");
            return (Criteria) this;
        }

        public Criteria andStatisDateIsNotNull() {
            addCriterion("statis_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatisDateEqualTo(Date value) {
            addCriterionForJDBCDate("statis_date =", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("statis_date <>", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateGreaterThan(Date value) {
            addCriterionForJDBCDate("statis_date >", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("statis_date >=", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateLessThan(Date value) {
            addCriterionForJDBCDate("statis_date <", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("statis_date <=", value, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateIn(List<Date> values) {
            addCriterionForJDBCDate("statis_date in", values, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("statis_date not in", values, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("statis_date between", value1, value2, "statisDate");
            return (Criteria) this;
        }

        public Criteria andStatisDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("statis_date not between", value1, value2, "statisDate");
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