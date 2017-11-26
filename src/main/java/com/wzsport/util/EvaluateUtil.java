package com.wzsport.util;

import java.math.BigDecimal;

import com.wzsport.model.PhysicalTest;

public class EvaluateUtil {
	public static PhysicalTest calculateScoreAndLevel(PhysicalTest physicalTest){
		
		Double BMI = null;
		//计算BMI
		if(physicalTest.getHeight() != null && physicalTest.getWeight() != null){
			BMI = (physicalTest.getWeight()/(physicalTest.getHeight()*physicalTest.getHeight()));
			physicalTest.setBmi(BigDecimal.valueOf(BMI));
		}
		
		// 获取体重BMI成绩
		if (BMI != null) {
			BigDecimal bd = new BigDecimal(BMI);
	        if (physicalTest.getIsMan()) {
	            for (int i = 0; i < Constant.BMILevel.length; i++) {
	                if (bd.compareTo(new BigDecimal(Constant.BMIStardardM[i])) >= 0) {
	                	physicalTest.setBmiGrade(Constant.BMILevel[i]);
	                	physicalTest.setBmiScore((short)Constant.BMIScore[i]);
	                    break;
	                }
	            }
	        } else {
	            for (int i = 0; i < Constant.BMILevel.length; i++) {
	                if (bd.compareTo(new BigDecimal(Constant.BMIStardardF[i])) >= 0) {
	                	physicalTest.setBmiGrade(Constant.BMILevel[i]);
	                	physicalTest.setBmiScore((short)Constant.BMIScore[i]);
	                    break;
	                }
	            }
	        }
		}
		
        // 获取肺活量成绩
		if (physicalTest.getVitalCapacity() != null) {
			if (physicalTest.getIsMan()) {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 男生-高年级
	                for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getVitalCapacity() >= Constant.VCStardardMH[i]) {
	                    	physicalTest.setVitalCapacityGrade(Constant.Levels[i]);
	                    	physicalTest.setVitalCapacityScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 男生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getVitalCapacity() >= Constant.VCStardardML[i]) {
	                    	physicalTest.setVitalCapacityGrade(Constant.Levels[i]);
	                    	physicalTest.setVitalCapacityScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        } else {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 女生-高年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getVitalCapacity() >= Constant.VCStardardFH[i]) {
	                    	physicalTest.setVitalCapacityGrade(Constant.Levels[i]);
	                    	physicalTest.setVitalCapacityScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 女生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getVitalCapacity() >= Constant.VCStardardFL[i]) {
	                    	physicalTest.setVitalCapacityGrade(Constant.Levels[i]);
	                    	physicalTest.setVitalCapacityScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        }
		}
        
        
        // 获取50M短跑成绩
		if (physicalTest.getFiftyRunTime() != null){
			if (physicalTest.getIsMan()) {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 男生-高年级
	                for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getFiftyRunTime() <= Constant.SprintStardardMH[i]) {
	                    	physicalTest.setFiftyRunGrade(Constant.Levels[i]);
	                    	physicalTest.setFiftyRunScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 男生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getFiftyRunTime() <= Constant.SprintStardardML[i]) {
	                    	physicalTest.setFiftyRunGrade(Constant.Levels[i]);
	                    	physicalTest.setFiftyRunScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        } else {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 女生-高年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getFiftyRunTime() <= Constant.SprintStardardFH[i]) {
	                    	physicalTest.setFiftyRunGrade(Constant.Levels[i]);
	                    	physicalTest.setFiftyRunScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 女生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getFiftyRunTime() <= Constant.SprintStardardFL[i]) {
	                    	physicalTest.setFiftyRunGrade(Constant.Levels[i]);
	                    	physicalTest.setFiftyRunScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        }
		}
        
        
        // 获取坐位体前屈成绩
		if (physicalTest.getSitAndReach() != null){
			if (physicalTest.getIsMan()) {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 男生-高年级
	                for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getSitAndReach() >= Constant.SitReachStardardMH[i]) {
	                    	physicalTest.setSitAndReachGrade(Constant.Levels[i]);
	                    	physicalTest.setSitAndReachScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 男生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getSitAndReach() >= Constant.SitReachStardardML[i]) {
	                    	physicalTest.setSitAndReachGrade(Constant.Levels[i]);
	                    	physicalTest.setSitAndReachScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        } else {
	            if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
	                // 女生-高年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getSitAndReach() >= Constant.SitReachStardardFH[i]) {
	                    	physicalTest.setSitAndReachGrade(Constant.Levels[i]);
	                    	physicalTest.setSitAndReachScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            } else {
	                // 女生-低年级
	            	for (int i = 0; i < Constant.Levels.length; i++) {
	                    if (physicalTest.getSitAndReach() >= Constant.SitReachStardardFL[i]) {
	                    	physicalTest.setSitAndReachGrade(Constant.Levels[i]);
	                    	physicalTest.setSitAndReachScore((short)Constant.Scores[i]);
	                        break;
	                    }
	                }
	            }
	        }
		}

        //获取立定跳远成绩
        if (physicalTest.getStandingLongJump() != null){
        	if (physicalTest.getIsMan()) {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 男生-高年级
                    for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getStandingLongJump() >= Constant.LongJumpStardardMH[i]) {
                        	physicalTest.setStandingLongJumpGrade(Constant.Levels[i]);
                        	physicalTest.setStandingLongJumpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 男生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getStandingLongJump() >= Constant.LongJumpStardardML[i]) {
                        	physicalTest.setStandingLongJumpGrade(Constant.Levels[i]);
                        	physicalTest.setStandingLongJumpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            } else {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 女生-高年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getStandingLongJump() >= Constant.LongJumpStardardFH[i]) {
                        	physicalTest.setStandingLongJumpGrade(Constant.Levels[i]);
                        	physicalTest.setStandingLongJumpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 女生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getStandingLongJump() >= Constant.LongJumpStardardFL[i]) {
                        	physicalTest.setStandingLongJumpGrade(Constant.Levels[i]);
                        	physicalTest.setStandingLongJumpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            }
        }

        //获取引体向上、仰卧起坐成绩
        if ((physicalTest.getIsMan() == true && physicalTest.getPullUp() != null) || (physicalTest.getIsMan() == false && physicalTest.getOneMinuteSitUp() != null)) {
        	if (physicalTest.getIsMan()) {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 男生-高年级
                    for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getPullUp() >= Constant.PullUpStardardMH[i]) {
                        	physicalTest.setPullUpGrade(Constant.Levels[i]);
                        	physicalTest.setPullUpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 男生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getPullUp() >= Constant.PullUpStardardML[i]) {
                        	physicalTest.setPullUpGrade(Constant.Levels[i]);
                        	physicalTest.setPullUpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            } else {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 女生-高年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getOneMinuteSitUp() >= Constant.SitUpStardardFH[i]) {
                        	physicalTest.setOneMinuteSitUpGrade(Constant.Levels[i]);
                        	physicalTest.setOneMinuteSitUpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 女生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                		if (physicalTest.getOneMinuteSitUp() >= Constant.SitUpStardardFL[i]) {
                        	physicalTest.setOneMinuteSitUpGrade(Constant.Levels[i]);
                        	physicalTest.setOneMinuteSitUpScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            }
        }

        //获取1000/800米长跑成绩
        if ((physicalTest.getIsMan() == false && physicalTest.getEightHundredRunTime() != null) || (physicalTest.getIsMan() == true && physicalTest.getOneThousandRunTime() != null)) {
        	if (physicalTest.getIsMan()) {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 男生-高年级
                    for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getOneThousandRunTime() <= Constant.RaceStardardMH[i]) {
                        	physicalTest.setOneThousandRunGrade(Constant.Levels[i]);
                        	physicalTest.setOneThousandRunScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 男生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getOneThousandRunTime() <= Constant.RaceStardardML[i]) {
                        	physicalTest.setOneThousandRunGrade(Constant.Levels[i]);
                        	physicalTest.setOneThousandRunScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            } else {
                if (isHighGrade(physicalTest.getStudentNo(),physicalTest.getSchoolYear())) {
                    // 女生-高年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getEightHundredRunTime() <= Constant.RaceStardardFH[i]) {
                        	physicalTest.setEightHundredRunGrade(Constant.Levels[i]);
                        	physicalTest.setEightHundredRunScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                } else {
                    // 女生-低年级
                	for (int i = 0; i < Constant.Levels.length; i++) {
                        if (physicalTest.getEightHundredRunTime() <= Constant.RaceStardardFL[i]) {
                        	physicalTest.setEightHundredRunGrade(Constant.Levels[i]);
                        	physicalTest.setEightHundredRunScore((short)Constant.Scores[i]);
                            break;
                        }
                    }
                }
            }
        }
        
		return physicalTest;
	}
	
	// 判断是否是高年级   改成根据体测成绩中的学年来判断
    public static Boolean isHighGrade(String studentNo,String schoolYear) {
        String year = schoolYear.substring(2,4);
        if (Integer.parseInt(year) - Integer.parseInt(studentNo.substring(0, 2)) < 2) {
            return false;
        } else {
            return true;
        }
    }

}
