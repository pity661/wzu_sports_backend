package com.wzsport.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientVersionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public ClientVersionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
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

		public Criteria andVersionNameIsNull() {
			addCriterion("version_name is null");
			return (Criteria) this;
		}

		public Criteria andVersionNameIsNotNull() {
			addCriterion("version_name is not null");
			return (Criteria) this;
		}

		public Criteria andVersionNameEqualTo(String value) {
			addCriterion("version_name =", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameNotEqualTo(String value) {
			addCriterion("version_name <>", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameGreaterThan(String value) {
			addCriterion("version_name >", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameGreaterThanOrEqualTo(String value) {
			addCriterion("version_name >=", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameLessThan(String value) {
			addCriterion("version_name <", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameLessThanOrEqualTo(String value) {
			addCriterion("version_name <=", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameLike(String value) {
			addCriterion("version_name like", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameNotLike(String value) {
			addCriterion("version_name not like", value, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameIn(List<String> values) {
			addCriterion("version_name in", values, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameNotIn(List<String> values) {
			addCriterion("version_name not in", values, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameBetween(String value1, String value2) {
			addCriterion("version_name between", value1, value2, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionNameNotBetween(String value1, String value2) {
			addCriterion("version_name not between", value1, value2, "versionName");
			return (Criteria) this;
		}

		public Criteria andVersionCodeIsNull() {
			addCriterion("version_code is null");
			return (Criteria) this;
		}

		public Criteria andVersionCodeIsNotNull() {
			addCriterion("version_code is not null");
			return (Criteria) this;
		}

		public Criteria andVersionCodeEqualTo(Integer value) {
			addCriterion("version_code =", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeNotEqualTo(Integer value) {
			addCriterion("version_code <>", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeGreaterThan(Integer value) {
			addCriterion("version_code >", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeGreaterThanOrEqualTo(Integer value) {
			addCriterion("version_code >=", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeLessThan(Integer value) {
			addCriterion("version_code <", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeLessThanOrEqualTo(Integer value) {
			addCriterion("version_code <=", value, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeIn(List<Integer> values) {
			addCriterion("version_code in", values, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeNotIn(List<Integer> values) {
			addCriterion("version_code not in", values, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeBetween(Integer value1, Integer value2) {
			addCriterion("version_code between", value1, value2, "versionCode");
			return (Criteria) this;
		}

		public Criteria andVersionCodeNotBetween(Integer value1, Integer value2) {
			addCriterion("version_code not between", value1, value2, "versionCode");
			return (Criteria) this;
		}

		public Criteria andChangeLogIsNull() {
			addCriterion("change_log is null");
			return (Criteria) this;
		}

		public Criteria andChangeLogIsNotNull() {
			addCriterion("change_log is not null");
			return (Criteria) this;
		}

		public Criteria andChangeLogEqualTo(String value) {
			addCriterion("change_log =", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotEqualTo(String value) {
			addCriterion("change_log <>", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogGreaterThan(String value) {
			addCriterion("change_log >", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogGreaterThanOrEqualTo(String value) {
			addCriterion("change_log >=", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLessThan(String value) {
			addCriterion("change_log <", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLessThanOrEqualTo(String value) {
			addCriterion("change_log <=", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogLike(String value) {
			addCriterion("change_log like", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotLike(String value) {
			addCriterion("change_log not like", value, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogIn(List<String> values) {
			addCriterion("change_log in", values, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotIn(List<String> values) {
			addCriterion("change_log not in", values, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogBetween(String value1, String value2) {
			addCriterion("change_log between", value1, value2, "changeLog");
			return (Criteria) this;
		}

		public Criteria andChangeLogNotBetween(String value1, String value2) {
			addCriterion("change_log not between", value1, value2, "changeLog");
			return (Criteria) this;
		}

		public Criteria andIsForcedIsNull() {
			addCriterion("is_forced is null");
			return (Criteria) this;
		}

		public Criteria andIsForcedIsNotNull() {
			addCriterion("is_forced is not null");
			return (Criteria) this;
		}

		public Criteria andIsForcedEqualTo(Boolean value) {
			addCriterion("is_forced =", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedNotEqualTo(Boolean value) {
			addCriterion("is_forced <>", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedGreaterThan(Boolean value) {
			addCriterion("is_forced >", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_forced >=", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedLessThan(Boolean value) {
			addCriterion("is_forced <", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_forced <=", value, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedIn(List<Boolean> values) {
			addCriterion("is_forced in", values, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedNotIn(List<Boolean> values) {
			addCriterion("is_forced not in", values, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_forced between", value1, value2, "isForced");
			return (Criteria) this;
		}

		public Criteria andIsForcedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_forced not between", value1, value2, "isForced");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIsNull() {
			addCriterion("download_url is null");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIsNotNull() {
			addCriterion("download_url is not null");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlEqualTo(String value) {
			addCriterion("download_url =", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotEqualTo(String value) {
			addCriterion("download_url <>", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlGreaterThan(String value) {
			addCriterion("download_url >", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
			addCriterion("download_url >=", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLessThan(String value) {
			addCriterion("download_url <", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
			addCriterion("download_url <=", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlLike(String value) {
			addCriterion("download_url like", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotLike(String value) {
			addCriterion("download_url not like", value, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlIn(List<String> values) {
			addCriterion("download_url in", values, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotIn(List<String> values) {
			addCriterion("download_url not in", values, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlBetween(String value1, String value2) {
			addCriterion("download_url between", value1, value2, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andDownloadUrlNotBetween(String value1, String value2) {
			addCriterion("download_url not between", value1, value2, "downloadUrl");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIsNull() {
			addCriterion("is_published is null");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIsNotNull() {
			addCriterion("is_published is not null");
			return (Criteria) this;
		}

		public Criteria andIsPublishedEqualTo(Boolean value) {
			addCriterion("is_published =", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotEqualTo(Boolean value) {
			addCriterion("is_published <>", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedGreaterThan(Boolean value) {
			addCriterion("is_published >", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_published >=", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedLessThan(Boolean value) {
			addCriterion("is_published <", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_published <=", value, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedIn(List<Boolean> values) {
			addCriterion("is_published in", values, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotIn(List<Boolean> values) {
			addCriterion("is_published not in", values, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_published between", value1, value2, "isPublished");
			return (Criteria) this;
		}

		public Criteria andIsPublishedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_published not between", value1, value2, "isPublished");
			return (Criteria) this;
		}

		public Criteria andPlatformIdIsNull() {
			addCriterion("platform_id is null");
			return (Criteria) this;
		}

		public Criteria andPlatformIdIsNotNull() {
			addCriterion("platform_id is not null");
			return (Criteria) this;
		}

		public Criteria andPlatformIdEqualTo(Byte value) {
			addCriterion("platform_id =", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotEqualTo(Byte value) {
			addCriterion("platform_id <>", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdGreaterThan(Byte value) {
			addCriterion("platform_id >", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdGreaterThanOrEqualTo(Byte value) {
			addCriterion("platform_id >=", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdLessThan(Byte value) {
			addCriterion("platform_id <", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdLessThanOrEqualTo(Byte value) {
			addCriterion("platform_id <=", value, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdIn(List<Byte> values) {
			addCriterion("platform_id in", values, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotIn(List<Byte> values) {
			addCriterion("platform_id not in", values, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdBetween(Byte value1, Byte value2) {
			addCriterion("platform_id between", value1, value2, "platformId");
			return (Criteria) this;
		}

		public Criteria andPlatformIdNotBetween(Byte value1, Byte value2) {
			addCriterion("platform_id not between", value1, value2, "platformId");
			return (Criteria) this;
		}

		public Criteria andCreatedAtIsNull() {
			addCriterion("created_at is null");
			return (Criteria) this;
		}

		public Criteria andCreatedAtIsNotNull() {
			addCriterion("created_at is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedAtEqualTo(Date value) {
			addCriterion("created_at =", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotEqualTo(Date value) {
			addCriterion("created_at <>", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtGreaterThan(Date value) {
			addCriterion("created_at >", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
			addCriterion("created_at >=", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtLessThan(Date value) {
			addCriterion("created_at <", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
			addCriterion("created_at <=", value, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtIn(List<Date> values) {
			addCriterion("created_at in", values, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotIn(List<Date> values) {
			addCriterion("created_at not in", values, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtBetween(Date value1, Date value2) {
			addCriterion("created_at between", value1, value2, "createdAt");
			return (Criteria) this;
		}

		public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
			addCriterion("created_at not between", value1, value2, "createdAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIsNull() {
			addCriterion("updated_at is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIsNotNull() {
			addCriterion("updated_at is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtEqualTo(Date value) {
			addCriterion("updated_at =", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotEqualTo(Date value) {
			addCriterion("updated_at <>", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtGreaterThan(Date value) {
			addCriterion("updated_at >", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
			addCriterion("updated_at >=", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtLessThan(Date value) {
			addCriterion("updated_at <", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
			addCriterion("updated_at <=", value, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtIn(List<Date> values) {
			addCriterion("updated_at in", values, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotIn(List<Date> values) {
			addCriterion("updated_at not in", values, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtBetween(Date value1, Date value2) {
			addCriterion("updated_at between", value1, value2, "updatedAt");
			return (Criteria) this;
		}

		public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
			addCriterion("updated_at not between", value1, value2, "updatedAt");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_client_version
	 * @mbg.generated  Sun Dec 24 13:07:03 CST 2017
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
     * This class corresponds to the database table wzsport_client_version
     *
     * @mbg.generated do_not_delete_during_merge Mon Aug 14 09:47:56 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}