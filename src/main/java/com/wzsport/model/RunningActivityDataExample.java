package com.wzsport.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class RunningActivityDataExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public RunningActivityDataExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
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

		public Criteria andActivityIdIsNull() {
			addCriterion("activity_id is null");
			return (Criteria) this;
		}

		public Criteria andActivityIdIsNotNull() {
			addCriterion("activity_id is not null");
			return (Criteria) this;
		}

		public Criteria andActivityIdEqualTo(Long value) {
			addCriterion("activity_id =", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotEqualTo(Long value) {
			addCriterion("activity_id <>", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdGreaterThan(Long value) {
			addCriterion("activity_id >", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
			addCriterion("activity_id >=", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdLessThan(Long value) {
			addCriterion("activity_id <", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdLessThanOrEqualTo(Long value) {
			addCriterion("activity_id <=", value, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdIn(List<Long> values) {
			addCriterion("activity_id in", values, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotIn(List<Long> values) {
			addCriterion("activity_id not in", values, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdBetween(Long value1, Long value2) {
			addCriterion("activity_id between", value1, value2, "activityId");
			return (Criteria) this;
		}

		public Criteria andActivityIdNotBetween(Long value1, Long value2) {
			addCriterion("activity_id not between", value1, value2, "activityId");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeIsNull() {
			addCriterion("acquisition_time is null");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeIsNotNull() {
			addCriterion("acquisition_time is not null");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeEqualTo(Date value) {
			addCriterion("acquisition_time =", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeNotEqualTo(Date value) {
			addCriterion("acquisition_time <>", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeGreaterThan(Date value) {
			addCriterion("acquisition_time >", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("acquisition_time >=", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeLessThan(Date value) {
			addCriterion("acquisition_time <", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeLessThanOrEqualTo(Date value) {
			addCriterion("acquisition_time <=", value, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeIn(List<Date> values) {
			addCriterion("acquisition_time in", values, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeNotIn(List<Date> values) {
			addCriterion("acquisition_time not in", values, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeBetween(Date value1, Date value2) {
			addCriterion("acquisition_time between", value1, value2, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andAcquisitionTimeNotBetween(Date value1, Date value2) {
			addCriterion("acquisition_time not between", value1, value2, "acquisitionTime");
			return (Criteria) this;
		}

		public Criteria andStepCountIsNull() {
			addCriterion("step_count is null");
			return (Criteria) this;
		}

		public Criteria andStepCountIsNotNull() {
			addCriterion("step_count is not null");
			return (Criteria) this;
		}

		public Criteria andStepCountEqualTo(Integer value) {
			addCriterion("step_count =", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountNotEqualTo(Integer value) {
			addCriterion("step_count <>", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountGreaterThan(Integer value) {
			addCriterion("step_count >", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("step_count >=", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountLessThan(Integer value) {
			addCriterion("step_count <", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountLessThanOrEqualTo(Integer value) {
			addCriterion("step_count <=", value, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountIn(List<Integer> values) {
			addCriterion("step_count in", values, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountNotIn(List<Integer> values) {
			addCriterion("step_count not in", values, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountBetween(Integer value1, Integer value2) {
			addCriterion("step_count between", value1, value2, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountNotBetween(Integer value1, Integer value2) {
			addCriterion("step_count not between", value1, value2, "stepCount");
			return (Criteria) this;
		}

		public Criteria andStepCountCalIsNull() {
			addCriterion("step_count_cal is null");
			return (Criteria) this;
		}

		public Criteria andStepCountCalIsNotNull() {
			addCriterion("step_count_cal is not null");
			return (Criteria) this;
		}

		public Criteria andStepCountCalEqualTo(Short value) {
			addCriterion("step_count_cal =", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalNotEqualTo(Short value) {
			addCriterion("step_count_cal <>", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalGreaterThan(Short value) {
			addCriterion("step_count_cal >", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalGreaterThanOrEqualTo(Short value) {
			addCriterion("step_count_cal >=", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalLessThan(Short value) {
			addCriterion("step_count_cal <", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalLessThanOrEqualTo(Short value) {
			addCriterion("step_count_cal <=", value, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalIn(List<Short> values) {
			addCriterion("step_count_cal in", values, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalNotIn(List<Short> values) {
			addCriterion("step_count_cal not in", values, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalBetween(Short value1, Short value2) {
			addCriterion("step_count_cal between", value1, value2, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andStepCountCalNotBetween(Short value1, Short value2) {
			addCriterion("step_count_cal not between", value1, value2, "stepCountCal");
			return (Criteria) this;
		}

		public Criteria andDistanceIsNull() {
			addCriterion("distance is null");
			return (Criteria) this;
		}

		public Criteria andDistanceIsNotNull() {
			addCriterion("distance is not null");
			return (Criteria) this;
		}

		public Criteria andDistanceEqualTo(Integer value) {
			addCriterion("distance =", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceNotEqualTo(Integer value) {
			addCriterion("distance <>", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceGreaterThan(Integer value) {
			addCriterion("distance >", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
			addCriterion("distance >=", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceLessThan(Integer value) {
			addCriterion("distance <", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceLessThanOrEqualTo(Integer value) {
			addCriterion("distance <=", value, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceIn(List<Integer> values) {
			addCriterion("distance in", values, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceNotIn(List<Integer> values) {
			addCriterion("distance not in", values, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceBetween(Integer value1, Integer value2) {
			addCriterion("distance between", value1, value2, "distance");
			return (Criteria) this;
		}

		public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
			addCriterion("distance not between", value1, value2, "distance");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepIsNull() {
			addCriterion("distance_per_step is null");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepIsNotNull() {
			addCriterion("distance_per_step is not null");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepEqualTo(Double value) {
			addCriterion("distance_per_step =", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepNotEqualTo(Double value) {
			addCriterion("distance_per_step <>", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepGreaterThan(Double value) {
			addCriterion("distance_per_step >", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepGreaterThanOrEqualTo(Double value) {
			addCriterion("distance_per_step >=", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepLessThan(Double value) {
			addCriterion("distance_per_step <", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepLessThanOrEqualTo(Double value) {
			addCriterion("distance_per_step <=", value, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepIn(List<Double> values) {
			addCriterion("distance_per_step in", values, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepNotIn(List<Double> values) {
			addCriterion("distance_per_step not in", values, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepBetween(Double value1, Double value2) {
			addCriterion("distance_per_step between", value1, value2, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andDistancePerStepNotBetween(Double value1, Double value2) {
			addCriterion("distance_per_step not between", value1, value2, "distancePerStep");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondIsNull() {
			addCriterion("step_per_second is null");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondIsNotNull() {
			addCriterion("step_per_second is not null");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondEqualTo(Double value) {
			addCriterion("step_per_second =", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondNotEqualTo(Double value) {
			addCriterion("step_per_second <>", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondGreaterThan(Double value) {
			addCriterion("step_per_second >", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondGreaterThanOrEqualTo(Double value) {
			addCriterion("step_per_second >=", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondLessThan(Double value) {
			addCriterion("step_per_second <", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondLessThanOrEqualTo(Double value) {
			addCriterion("step_per_second <=", value, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondIn(List<Double> values) {
			addCriterion("step_per_second in", values, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondNotIn(List<Double> values) {
			addCriterion("step_per_second not in", values, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondBetween(Double value1, Double value2) {
			addCriterion("step_per_second between", value1, value2, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andStepPerSecondNotBetween(Double value1, Double value2) {
			addCriterion("step_per_second not between", value1, value2, "stepPerSecond");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNull() {
			addCriterion("longitude is null");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNotNull() {
			addCriterion("longitude is not null");
			return (Criteria) this;
		}

		public Criteria andLongitudeEqualTo(Double value) {
			addCriterion("longitude =", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotEqualTo(Double value) {
			addCriterion("longitude <>", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThan(Double value) {
			addCriterion("longitude >", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
			addCriterion("longitude >=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThan(Double value) {
			addCriterion("longitude <", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThanOrEqualTo(Double value) {
			addCriterion("longitude <=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeIn(List<Double> values) {
			addCriterion("longitude in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotIn(List<Double> values) {
			addCriterion("longitude not in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeBetween(Double value1, Double value2) {
			addCriterion("longitude between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotBetween(Double value1, Double value2) {
			addCriterion("longitude not between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNull() {
			addCriterion("latitude is null");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNotNull() {
			addCriterion("latitude is not null");
			return (Criteria) this;
		}

		public Criteria andLatitudeEqualTo(Double value) {
			addCriterion("latitude =", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotEqualTo(Double value) {
			addCriterion("latitude <>", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThan(Double value) {
			addCriterion("latitude >", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
			addCriterion("latitude >=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThan(Double value) {
			addCriterion("latitude <", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThanOrEqualTo(Double value) {
			addCriterion("latitude <=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIn(List<Double> values) {
			addCriterion("latitude in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotIn(List<Double> values) {
			addCriterion("latitude not in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeBetween(Double value1, Double value2) {
			addCriterion("latitude between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotBetween(Double value1, Double value2) {
			addCriterion("latitude not between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLocationTypeIsNull() {
			addCriterion("location_type is null");
			return (Criteria) this;
		}

		public Criteria andLocationTypeIsNotNull() {
			addCriterion("location_type is not null");
			return (Criteria) this;
		}

		public Criteria andLocationTypeEqualTo(Integer value) {
			addCriterion("location_type =", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeNotEqualTo(Integer value) {
			addCriterion("location_type <>", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeGreaterThan(Integer value) {
			addCriterion("location_type >", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("location_type >=", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeLessThan(Integer value) {
			addCriterion("location_type <", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeLessThanOrEqualTo(Integer value) {
			addCriterion("location_type <=", value, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeIn(List<Integer> values) {
			addCriterion("location_type in", values, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeNotIn(List<Integer> values) {
			addCriterion("location_type not in", values, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeBetween(Integer value1, Integer value2) {
			addCriterion("location_type between", value1, value2, "locationType");
			return (Criteria) this;
		}

		public Criteria andLocationTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("location_type not between", value1, value2, "locationType");
			return (Criteria) this;
		}

		public Criteria andIsNormalIsNull() {
			addCriterion("is_normal is null");
			return (Criteria) this;
		}

		public Criteria andIsNormalIsNotNull() {
			addCriterion("is_normal is not null");
			return (Criteria) this;
		}

		public Criteria andIsNormalEqualTo(Boolean value) {
			addCriterion("is_normal =", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalNotEqualTo(Boolean value) {
			addCriterion("is_normal <>", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalGreaterThan(Boolean value) {
			addCriterion("is_normal >", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_normal >=", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalLessThan(Boolean value) {
			addCriterion("is_normal <", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalLessThanOrEqualTo(Boolean value) {
			addCriterion("is_normal <=", value, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalIn(List<Boolean> values) {
			addCriterion("is_normal in", values, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalNotIn(List<Boolean> values) {
			addCriterion("is_normal not in", values, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalBetween(Boolean value1, Boolean value2) {
			addCriterion("is_normal between", value1, value2, "isNormal");
			return (Criteria) this;
		}

		public Criteria andIsNormalNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_normal not between", value1, value2, "isNormal");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wzsport_running_activity_data
	 * @mbg.generated  Wed Nov 15 15:06:04 CST 2017
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
     * This class corresponds to the database table wzsport_running_activity_data
     *
     * @mbg.generated do_not_delete_during_merge Tue Jun 27 14:08:17 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}