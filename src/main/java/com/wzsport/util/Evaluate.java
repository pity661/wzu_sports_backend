package com.wzsport.util;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.joda.time.DateTime;

public class Evaluate {
    
	//计算BMI
	public static Double calculateBmi(Integer weight, Integer height){
		return (double) (weight/((height/100.0)*(height/100.0)));
	}
	
    // 获取体重BMI成绩
    public static Level getBMIEvaluate(boolean isMan, double bmi) {
        Level level = new Level();
        BigDecimal bd = new BigDecimal(bmi);
        if (isMan) {
            for (int i = 0; i < Constant.BMILevel.length; i++) {
                if (bd.compareTo(new BigDecimal(Constant.BMIStardardM[i])) >= 0) {
                    level.setLevel(Constant.BMILevel[i]);
                    level.setScore(Constant.BMIScore[i]);
                    break;
                }
            }
        } else {
            for (int i = 0; i < Constant.BMILevel.length; i++) {
                if (bd.compareTo(new BigDecimal(Constant.BMIStardardF[i])) >= 0) {
                    level.setLevel(Constant.BMILevel[i]);
                    level.setScore(Constant.BMIScore[i]);
                    break;
                }
            }
        }
        return level;
    }

    // 获取肺活量成绩
    public static Level getVitalCapacityEvaluate(String studentNo,
            boolean isMan, int vitalCapacity) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (vitalCapacity >= Constant.VCStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (vitalCapacity >= Constant.VCStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (vitalCapacity >= Constant.VCStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (vitalCapacity >= Constant.VCStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }

    // 获取50M短跑成绩
    public static Level getSprintEvaluate(String studentNo, boolean isMan,
            double costTime) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (costTime <= Constant.SprintStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (costTime <= Constant.SprintStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (costTime <= Constant.SprintStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (costTime <= Constant.SprintStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }

    // 获取坐位体前屈成绩
    public static Level getSitReachEvaluate(String studentNo, boolean isMan,
            double cm) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.SitReachStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.SitReachStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.SitReachStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.SitReachStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }

    // 获取跳绳成绩
    public static Level getRopeSkipEvaluate(String studentNo, boolean isMan,
            double times) {
        Level level = new Level();
        if (isMan) {
            int[] RopeSkipStardardM = getGradeArray(studentNo, isMan);
            for (int i = 0; i < Constant.Levels.length; i++) {
                if (times >= RopeSkipStardardM[i]) {
                    level.setLevel(Constant.Levels[i]);
                    level.setScore(Constant.Scores[i]);
                    break;
                }
            }
        } else {
            int[] RopeSkipStardardF = getGradeArray(studentNo, isMan);
            for (int i = 0; i < Constant.Levels.length; i++) {
                if (times >= RopeSkipStardardF[i]) {
                    level.setLevel(Constant.Levels[i]);
                    level.setScore(Constant.Scores[i]);
                    break;
                }
            }
        }
        return level;
    }

    //获取立定跳远成绩
    public static Level getLongJumpEvaluate(String studentNo, boolean isMan,
            double cm) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.LongJumpStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.LongJumpStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.LongJumpStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (cm >= Constant.LongJumpStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }

    //获取引体向上、仰卧起坐成绩
    public static Level getPullUpSitUpEvaluate(String studentNo, boolean isMan,
            double times) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times >= Constant.PullUpStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times >= Constant.PullUpStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times >= Constant.SitUpStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times >= Constant.SitUpStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }
    
    //获取1000/800米长跑成绩
    public static Level getRaceEvaluate(String studentNo, boolean isMan,
            double times) {
        Level level = new Level();
        if (isMan) {
            if (isHighGrade(studentNo)) {
                // 男生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times <= Constant.RaceStardardMH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 男生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times <= Constant.RaceStardardML[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        } else {
            if (isHighGrade(studentNo)) {
                // 女生-高年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times <= Constant.RaceStardardFH[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            } else {
                // 女生-低年级
                for (int i = 0; i < Constant.Levels.length; i++) {
                    if (times <= Constant.RaceStardardFL[i]) {
                        level.setLevel(Constant.Levels[i]);
                        level.setScore(Constant.Scores[i]);
                        break;
                    }
                }
            }
        }
        return level;
    }
    
    // 判断是否是高年级   改成根据体测成绩中的学年来判断
    public static Boolean isHighGrade(String studentNo) {
        DateTime dt = new DateTime();
        String year = String.valueOf(dt.getYear()).substring(2);
        if (Integer.parseInt(year) - Integer.parseInt(studentNo.substring(0, 2)) < 2) {
            return false;
        } else if (Integer.parseInt(year) - Integer.parseInt(studentNo.substring(0, 2)) == 2) {
            if (dt.getMonthOfYear() <= 8) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    //获取年级并返回对应数组   
    public static int[] getGradeArray(String studentNo, boolean isMan) {
        
        return Constant.RopeSkipStardardM1;
    }
    
    
    public static void getNumber(Integer num) {
        num = 4;
    }
    
    class MutableInteger {
        public int value;
    }
    
    class C {
        public C(int[] i) {
            ++i[0];
        }
    }
    
    class D {
        public D(MutableInteger i) {
            ++i.value;
        }
    }
    
    class E {
        public E(AtomicInteger i) {
            i.incrementAndGet();
        }
    }
    public static void main(String[] args) {
//        Integer integer = new Integer(2);
//        getNumber(integer);
//        System.out.println(integer);
        
        Evaluate e = new Evaluate();
        int[] i = new int[] { 0 };
        System.out.println(i[0]);
        e.new C(i);
        System.out.println(i[0]);
        
        MutableInteger ii = e.new MutableInteger();
        System.out.println(ii.value);
        e.new D(ii);
        System.out.println(ii.value);
        
        AtomicInteger iii = new AtomicInteger(0);
        System.out.println(iii);
        e.new E(iii);
        System.out.println(iii);
        
    }

}