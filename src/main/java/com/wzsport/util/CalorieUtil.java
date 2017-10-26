package com.wzsport.util;

/**
* 卡路里工具类
* 
* @author x1ny
* @date 2017年5月26日
*/
public class CalorieUtil {

	/**
	 * 标准体重
	 */
	private static final double  STANDARD_WEIGHT = 68.00;
	
	/**
	 * 标准时间
	 */
	private static final double STANDARD_FACTOR = 60.00 * 60;
	
	/**
	* 计算卡路里消耗量
	* 
	* @param weight 体重
	* @param time 运动时间
	* @param hourlyCalorieConsumption 每小时卡路里标准消耗量
	* @return 总卡路里消耗
	*/
	public static int calculateCalorieConsumption(int weight, int time, int hourlyCalorieConsumption) {
		double calorieConsumption = (weight / STANDARD_WEIGHT) * hourlyCalorieConsumption * (time / STANDARD_FACTOR);
		return (int) Math.round(calorieConsumption);
	}
}
