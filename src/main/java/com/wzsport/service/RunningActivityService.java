package com.wzsport.service;

import java.util.Date;

import com.wzsport.model.RunningActivity;

// TODO: Auto-generated Javadoc
/**
* RunningActivity service interface.
* 
* @author x1ny
* @date 2017年5月26日
*/
public interface RunningActivityService {

	/**
	 * 创建RunningActivity.
	 *
	 * @param runningActivity the running activity
	 * @return the running activity
	 */
	RunningActivity create(RunningActivity runningActivity);
	
	
	/**
	 * 活动开始记录.
	 *
	 * @param studentId the student id
	 * @param runningSportId the runningSport id
	 * @param startTime the start time
	 * @return the running activity
	 */
	RunningActivity startRunningActivity(long studentId, long runningSportId, Date startTime);
	
	/**
	 * 结束一次活动.
	 *
	 * @param runningActivity the running activity
	 * @return the running activity
	 */
	RunningActivity endRunningActivity(RunningActivity runningActivity);
	
	/**
	 * 获取一名学生本学期的有效活动次数.
	 *
	 * @param studentId 学生id
	 * @param universityId 大学id
	 * @return the current term qualified activity count
	 */
	int getCurrentTermQualifiedActivityCount(long studentId, long universityId);
	
	/**
	 * 获取一名学生指定时期内的有效活动次数.
	 *
	 * @param studentId 学生id
	 * @param start 开始时期
	 * @param end 结束时期
	 * @return the qualified activity count
	 */
	int getQualifiedActivityCount(long studentId, Date start, Date end);
	
	/**
	 * 获取一名学生指定时期内的打卡次数.
	 *
	 * @param studentId 学生id
	 * @param start 开始时期
	 * @param end 结束时期
	 * @return the qualified activity count
	 */
	int getSignInCount(long studentId, Date start, Date end);
	
	/**
	 * 获取一名学生指定时期内的累计活动次数.
	 *
	 * @param studentId 学生id
	 * @param start 开始时期
	 * @param end 结束时期
	 * @return the qualified activity count
	 */
	int getAccuActivityCount(long studentId, Date start, Date end);
	/**
	 * 获取一名学生本学期的总活动次数.
	 *
	 * @param studentId 学生id
	 * @param universityId 大学id
	 * @return the current term activity count
	 */
	int getCurrentTermActivityCount(long studentId, long universityId);
	
	/**
	 * 获取学生的卡路里消耗量.
	 *
	 * @param studentId the student id
	 * @return the student calories consumption
	 */
	int getStudentKCalConsumption(long studentId);
	
	/**
	 * 获取学生的累计运动时长.
	 *
	 * @param studentId the student id
	 * @return the student time costed
	 */
	int getStudentTimeCosted(long studentId);
	
	/**
	 * 获取学生指定时段的卡路里消耗量.
	 *
	 * @param studentId the student id
	 * @param start 开始时期
	 * @param end 结束时期
	 * @return the student calories consumption
	 */
	int getStudentKcalConsumption(long studentId, Date start, Date end);
	
	/**
	 * 获取学生指定时段的运动时长.
	 *
	 * @param studentId the student id
	 * @param start 开始时期
	 * @param end 结束时期
	 * @return the student time costed
	 */
	int getStudentTimeCosted(long studentId, Date start, Date end);
	
	
	/**
	 * 获取参加人数。.
	 *
	 * @param runningSportId the runningSport id
	 * @return the participant num
	 */
	int getParticipantNum(long runningSportId);
	
	
	/**
	 * Checks if is activity exist.
	 *
	 * @param activityId the activity id
	 * @return true, if is activity exist
	 */
	boolean isActivityExist(long activityId);
}
