package com.wzsport.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;

public class UpdatePhysicalTestRecordExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public UpdatePhysicalTestRecordExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
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

		public Criteria andPhysicalTestIdIsNull() {
			addCriterion("physical_test_id is null");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdIsNotNull() {
			addCriterion("physical_test_id is not null");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdEqualTo(Long value) {
			addCriterion("physical_test_id =", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdNotEqualTo(Long value) {
			addCriterion("physical_test_id <>", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdGreaterThan(Long value) {
			addCriterion("physical_test_id >", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdGreaterThanOrEqualTo(Long value) {
			addCriterion("physical_test_id >=", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdLessThan(Long value) {
			addCriterion("physical_test_id <", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdLessThanOrEqualTo(Long value) {
			addCriterion("physical_test_id <=", value, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdIn(List<Long> values) {
			addCriterion("physical_test_id in", values, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdNotIn(List<Long> values) {
			addCriterion("physical_test_id not in", values, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdBetween(Long value1, Long value2) {
			addCriterion("physical_test_id between", value1, value2, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andPhysicalTestIdNotBetween(Long value1, Long value2) {
			addCriterion("physical_test_id not between", value1, value2, "physicalTestId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdIsNull() {
			addCriterion("alter_user_id is null");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdIsNotNull() {
			addCriterion("alter_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdEqualTo(Long value) {
			addCriterion("alter_user_id =", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdNotEqualTo(Long value) {
			addCriterion("alter_user_id <>", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdGreaterThan(Long value) {
			addCriterion("alter_user_id >", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("alter_user_id >=", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdLessThan(Long value) {
			addCriterion("alter_user_id <", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdLessThanOrEqualTo(Long value) {
			addCriterion("alter_user_id <=", value, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdIn(List<Long> values) {
			addCriterion("alter_user_id in", values, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdNotIn(List<Long> values) {
			addCriterion("alter_user_id not in", values, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdBetween(Long value1, Long value2) {
			addCriterion("alter_user_id between", value1, value2, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserIdNotBetween(Long value1, Long value2) {
			addCriterion("alter_user_id not between", value1, value2, "alterUserId");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameIsNull() {
			addCriterion("alter_user_name is null");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameIsNotNull() {
			addCriterion("alter_user_name is not null");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameEqualTo(String value) {
			addCriterion("alter_user_name =", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameNotEqualTo(String value) {
			addCriterion("alter_user_name <>", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameGreaterThan(String value) {
			addCriterion("alter_user_name >", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("alter_user_name >=", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameLessThan(String value) {
			addCriterion("alter_user_name <", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameLessThanOrEqualTo(String value) {
			addCriterion("alter_user_name <=", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameLike(String value) {
			addCriterion("alter_user_name like", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameNotLike(String value) {
			addCriterion("alter_user_name not like", value, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameIn(List<String> values) {
			addCriterion("alter_user_name in", values, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameNotIn(List<String> values) {
			addCriterion("alter_user_name not in", values, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameBetween(String value1, String value2) {
			addCriterion("alter_user_name between", value1, value2, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andAlterUserNameNotBetween(String value1, String value2) {
			addCriterion("alter_user_name not between", value1, value2, "alterUserName");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("remarks is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("remarks is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("remarks =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("remarks <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("remarks >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("remarks >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("remarks <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("remarks <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("remarks like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("remarks not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("remarks in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("remarks not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("remarks between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("remarks not between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andAlterTimeIsNull() {
			addCriterion("alter_time is null");
			return (Criteria) this;
		}

		public Criteria andAlterTimeIsNotNull() {
			addCriterion("alter_time is not null");
			return (Criteria) this;
		}

		public Criteria andAlterTimeEqualTo(Timestamp value) {
			addCriterion("alter_time =", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeNotEqualTo(Timestamp value) {
			addCriterion("alter_time <>", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeGreaterThan(Timestamp value) {
			addCriterion("alter_time >", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("alter_time >=", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeLessThan(Timestamp value) {
			addCriterion("alter_time <", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("alter_time <=", value, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeIn(List<Timestamp> values) {
			addCriterion("alter_time in", values, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeNotIn(List<Timestamp> values) {
			addCriterion("alter_time not in", values, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("alter_time between", value1, value2, "alterTime");
			return (Criteria) this;
		}

		public Criteria andAlterTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("alter_time not between", value1, value2, "alterTime");
			return (Criteria) this;
		}

		public Criteria andIsAlterIsNull() {
			addCriterion("is_alter is null");
			return (Criteria) this;
		}

		public Criteria andIsAlterIsNotNull() {
			addCriterion("is_alter is not null");
			return (Criteria) this;
		}

		public Criteria andIsAlterEqualTo(Boolean value) {
			addCriterion("is_alter =", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterNotEqualTo(Boolean value) {
			addCriterion("is_alter <>", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterGreaterThan(Boolean value) {
			addCriterion("is_alter >", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_alter >=", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterLessThan(Boolean value) {
			addCriterion("is_alter <", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterLessThanOrEqualTo(Boolean value) {
			addCriterion("is_alter <=", value, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterIn(List<Boolean> values) {
			addCriterion("is_alter in", values, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterNotIn(List<Boolean> values) {
			addCriterion("is_alter not in", values, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterBetween(Boolean value1, Boolean value2) {
			addCriterion("is_alter between", value1, value2, "isAlter");
			return (Criteria) this;
		}

		public Criteria andIsAlterNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_alter not between", value1, value2, "isAlter");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_update_physical_test_record
	 * @mbg.generated  Sat Mar 24 15:25:08 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wzsport_update_physical_test_record
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 23 16:26:35 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}