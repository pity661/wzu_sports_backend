package com.wzsport.service;

import java.util.Date;

import com.wzsport.model.AreaActivity;
import com.wzsport.util.ResponseBody;

/**
 * The Interface AreaActivityService.
 */
public interface AreaActivityService {

	/**
	 * Creates the.
	 *
	 * @param runningActivity
	 *            the running activity
	 * @return the int
	 */
	@SuppressWarnings("rawtypes")
	int create(AreaActivity runningActivity, ResponseBody resBody);
	
	@SuppressWarnings("rawtypes")
	int update(AreaActivity runningActivity, ResponseBody resBody);
	
	/**
	 * Start area activity.
	 *
	 * @param studentId
	 *            the student id
	 * @param runningSportId
	 *            the running sport id
	 * @param startTime
	 *            the start time
	 * @return the area activity
	 */
	AreaActivity startAreaActivity(long studentId, long runningSportId, Date startTime);
	
	/**
	 * End area activity.
	 *
	 * @param runningActivity
	 *            the running activity
	 * @return the area activity
	 */
	AreaActivity endAreaActivity(AreaActivity runningActivity);
	
	/**
	 * Gets the current term qualified activity count.
	 *
	 * @param studentId
	 *            the student id
	 * @param universityId
	 *            the university id
	 * @return the current term qualified activity count
	 */
	int getCurrentTermQualifiedActivityCount(long studentId, long universityId);
	
	/**
	 * Gets the qualified activity count.
	 *
	 * @param studentId
	 *            the student id
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the qualified activity count
	 */
	int getQualifiedActivityCount(long studentId, Date start, Date end);
	
	/**
	 * Gets the current term activity count.
	 *
	 * @param studentId
	 *            the student id
	 * @param universityId
	 *            the university id
	 * @return the current term activity count
	 */
	int getCurrentTermActivityCount(long studentId, long universityId);
	
	/**
	 * Gets the student K cal consumption.
	 *
	 * @param studentId
	 *            the student id
	 * @return the student K cal consumption
	 */
	int getStudentKCalConsumption(long studentId);
	
	/**
	 * Gets the student time costed.
	 *
	 * @param studentId
	 *            the student id
	 * @return the student time costed
	 */
	int getStudentTimeCosted(long studentId);
	
	/**
	 * Gets the student calories consumption.
	 *
	 * @param studentId
	 *            the student id
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the student calories consumption
	 */
	int getStudentKcalConsumption(long studentId, Date start, Date end);
	
	/**
	 * Gets the student time costed.
	 *
	 * @param studentId
	 *            the student id
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return the student time costed
	 */
	int getStudentTimeCosted(long studentId, Date start, Date end);
	
	
	/**
	 * Gets the participant num.
	 *
	 * @param runningSportId
	 *            the running sport id
	 * @return the participant num
	 */
	int getParticipantNum(long runningSportId);
	
	
	/**
	 * Checks if is activity exist.
	 *
	 * @param activityId
	 *            the activity id
	 * @return true, if is activity exist
	 */
	boolean isActivityExist(long activityId);

	Object getAccuActivityCount(long studentId, Date start, Date end);
}
