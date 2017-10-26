package com.wzsport.util;

/**
 * 计算BMI工具类
 * 
 * @author Watermelon_R(ljf)
 * 2017年5月27日
 */
public class BmiUtil {
	/**
	 * 根据身高体重计算BMI  体质指数（BMI）=体重（kg）÷身高^2（m）
	 * 
	 * @param weight
	 * @param height
	 * @return
	 */
	public static Float calculateBmi(Integer weight, Integer height){
		return (float) (weight/((height/100.0)*(height/100.0)));
	}
}
