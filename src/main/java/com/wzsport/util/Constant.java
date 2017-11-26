package com.wzsport.util;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    // ------------------------------------------------------------------------
    // 体重
    // ------------------------------------------------------------------------
    public static final String GRADE_OBESITY = "肥胖";
    public static final String GRADE_WEIGHT = "超重";
    public static final String GRADE_NORMAL = "正常";
    public static final String GRADE_LIGHT = "低体重";
    public static final String[] BMILevel = { GRADE_OBESITY, GRADE_WEIGHT,
            GRADE_NORMAL, GRADE_LIGHT };// 体重等级

    public static final int[] BMIScore = { 60, 80, 100, 80 };// 体重分数

    public static final double[] BMIStardardM = { 28.0, 24.0, 17.8,
            Double.NEGATIVE_INFINITY };// 男生体重标准

    public static final double[] BMIStardardF = { 28.0, 24.0, 17.1,
            Double.NEGATIVE_INFINITY };// 女生体重标准
    // ------------------------------------------------------------------------
    // 通用
    // ------------------------------------------------------------------------
    public static final String GRADE_EXCELLENCE = "优秀";
    public static final String GRADE_WELL = "良好";
    public static final String GRADE_PASS = "及格";
    public static final String GRADE_NOT_PASS = "不及格";
    public static final String[] Levels = { GRADE_EXCELLENCE, GRADE_EXCELLENCE,
            GRADE_EXCELLENCE, GRADE_WELL, GRADE_WELL, GRADE_PASS, GRADE_PASS,
            GRADE_PASS, GRADE_PASS, GRADE_PASS, GRADE_PASS, GRADE_PASS,
            GRADE_PASS, GRADE_PASS, GRADE_PASS, GRADE_NOT_PASS, GRADE_NOT_PASS,
            GRADE_NOT_PASS, GRADE_NOT_PASS, GRADE_NOT_PASS, GRADE_NOT_PASS };// 通用等级

    public static final int[] Scores = { 100, 95, 90, 85, 80, 78, 76, 74, 72,
            70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 0 };// 通用分数
    // ------------------------------------------------------------------------
    // 肺活量
    // ------------------------------------------------------------------------
    public static final int[] VCStardardML = { 5040, 4920, 4800, 4550, 4300,
            4180, 4060, 3940, 3820, 3700, 3580, 3460, 3340, 3220, 3100, 2940,
            2780, 2620, 2460, 2300, Integer.MIN_VALUE };// 男生-低年级-肺活量标准

    public static final int[] VCStardardMH = { 5140, 5020, 4900, 4650, 4400,
            4280, 4160, 4040, 3920, 3800, 3680, 3560, 3440, 3320, 3200, 3030,
            2860, 2690, 2520, 2350, Integer.MIN_VALUE };// 男生-高年级-肺活量标准

    public static final int[] VCStardardFL = { 3400, 3350, 3300, 3150, 3000,
            2900, 2800, 2700, 2600, 2500, 2400, 2300, 2200, 2100, 2000, 1960,
            1920, 1880, 1840, 1800, Integer.MIN_VALUE };// 女生-低年级-肺活量标准

    public static final int[] VCStardardFH = { 3450, 3400, 3350, 3200, 3050,
            2950, 2850, 2750, 2650, 2550, 2450, 2350, 2250, 2150, 2050, 2010,
            1970, 1930, 1890, 1850, Integer.MIN_VALUE };// 女生-高年级-肺活量标准
    // ------------------------------------------------------------------------
    // 50M短跑
    // ------------------------------------------------------------------------
    public static final double[] SprintStardardML = { 6.7, 6.8, 6.9, 7.0, 7.1,
            7.3, 7.5, 7.7, 7.9, 8.1, 8.3, 8.5, 8.7, 8.9, 9.1, 9.3, 9.5, 9.7,
            9.9, 10.1, Double.MAX_VALUE };// 男生-低年级-50M标准

    public static final double[] SprintStardardMH = { 6.6, 6.7, 6.8, 6.9, 7.0,
            7.2, 7.4, 7.6, 7.8, 8.0, 8.2, 8.4, 8.6, 8.8, 9.0, 9.2, 9.4, 9.6,
            9.8, 10.0, Double.MAX_VALUE };// 男生-高年级-50M标准

    public static final double[] SprintStardardFL = { 7.5, 7.6, 7.7, 8.0, 8.3,
            8.5, 8.7, 8.9, 9.1, 9.3, 9.5, 9.7, 9.9, 10.1, 10.3, 10.5, 10.7,
            10.9, 11.1, 11.3, Double.MAX_VALUE };// 女生-低年级-50M标准

    public static final double[] SprintStardardFH = { 7.4, 7.5, 7.6, 7.9, 8.2,
            8.4, 8.6, 8.8, 9.0, 9.2, 9.4, 9.6, 9.8, 10.0, 10.2, 10.4, 10.6,
            10.8, 11.0, 11.2, Double.MAX_VALUE };// 女生-高年级-50M标准
    // ------------------------------------------------------------------------
    // 坐位体前屈
    // ------------------------------------------------------------------------
    public static final double[] SitReachStardardML = { 24.9, 23.1, 21.3, 19.5,
            17.7, 16.3, 14.9, 13.5, 12.1, 10.7, 9.3, 7.9, 6.5, 5.1, 3.7, 2.7,
            1.7, 0.7, -0.3, -1.3, Double.NEGATIVE_INFINITY };// 男生-低年级-坐位体前屈标准

    public static final double[] SitReachStardardMH = { 25.1, 23.3, 21.5, 19.9,
            18.2, 16.8, 15.4, 14.0, 12.6, 11.2, 9.8, 8.4, 7.0, 5.6, 4.2, 3.2,
            2.2, 1.2, 0.2, -0.8, Double.NEGATIVE_INFINITY };// 男生-高年级-坐位体前屈标准

    public static final double[] SitReachStardardFL = { 25.8, 24.0, 22.2, 20.6,
            19.0, 17.7, 16.4, 15.1, 13.8, 12.5, 11.2, 9.9, 8.6, 7.3, 6.0, 5.2,
            4.4, 3.6, 2.8, 2.0, Double.NEGATIVE_INFINITY };// 女生-低年级-坐位体前屈标准

    public static final double[] SitReachStardardFH = { 26.3, 24.4, 22.4, 21.0,
            19.5, 18.2, 16.9, 15.6, 14.3, 13.0, 11.7, 10.4, 9.1, 7.8, 6.5, 5.7,
            4.9, 4.1, 3.3, 2.5, Double.NEGATIVE_INFINITY };// 女生-高年级-坐位体前屈标准
    // ------------------------------------------------------------------------
    // 跳绳
    // ------------------------------------------------------------------------
    public static final int[] RopeSkipStardardM1 = { 109, 104, 99, 93, 87, 80,
            73, 66, 59, 52, 45, 38, 31, 24, 17, 14, 11, 8, 5, 2,
            Integer.MIN_VALUE };// 男生-一年级-跳绳标准
    public static final int[] RopeSkipStardardM2 = { 117, 112, 107, 101, 95,
            88, 81, 74, 67, 60, 53, 46, 39, 32, 25, 22, 19, 16, 13, 10,
            Integer.MIN_VALUE };// 男生-二年级-跳绳标准
    public static final int[] RopeSkipStardardM3 = { 126, 121, 116, 110, 104,
            97, 90, 83, 76, 69, 62, 55, 48, 41, 34, 31, 28, 25, 22, 19,
            Integer.MIN_VALUE };// 男生-三年级-跳绳标准
    public static final int[] RopeSkipStardardM4 = { 137, 132, 127, 121, 115,
            108, 101, 94, 87, 80, 73, 66, 59, 52, 45, 42, 39, 36, 33, 30,
            Integer.MIN_VALUE };// 男生-四年级-跳绳标准
    public static final int[] RopeSkipStardardM5 = { 148, 143, 138, 132, 126,
            119, 112, 105, 98, 91, 84, 77, 70, 63, 56, 53, 50, 47, 44, 41,
            Integer.MIN_VALUE };// 男生-五年级-跳绳标准
    public static final int[] RopeSkipStardardM6 = { 157, 152, 147, 141, 135,
            128, 121, 114, 107, 100, 93, 86, 79, 72, 65, 62, 59, 56, 53, 50,
            Integer.MIN_VALUE };// 男生-六年级-跳绳标准

    public static final int[] RopeSkipStardardF1 = { 117, 110, 103, 95, 87, 80,
            73, 66, 59, 52, 45, 38, 31, 24, 17, 14, 11, 8, 5, 2,
            Integer.MIN_VALUE };// 女生-一年级-跳绳标准
    public static final int[] RopeSkipStardardF2 = { 127, 120, 113, 105, 97,
            90, 83, 76, 69, 62, 55, 48, 41, 34, 27, 24, 21, 18, 15, 12,
            Integer.MIN_VALUE };// 女生-二年级-跳绳标准
    public static final int[] RopeSkipStardardF3 = { 139, 132, 125, 117, 109,
            102, 95, 88, 81, 74, 67, 60, 53, 46, 39, 36, 33, 30, 27, 24,
            Integer.MIN_VALUE };// 女生-三年级-跳绳标准
    public static final int[] RopeSkipStardardF4 = { 149, 142, 135, 127, 119,
            112, 105, 98, 91, 84, 77, 70, 63, 56, 49, 46, 43, 40, 37, 34,
            Integer.MIN_VALUE };// 女生-四年级-跳绳标准
    public static final int[] RopeSkipStardardF5 = { 158, 151, 144, 136, 128,
            121, 114, 107, 100, 93, 86, 79, 72, 65, 58, 55, 52, 49, 46, 43,
            Integer.MIN_VALUE };// 女生-五年级-跳绳标准
    public static final int[] RopeSkipStardardF6 = { 166, 159, 152, 144, 136,
            129, 122, 115, 108, 101, 94, 87, 80, 73, 66, 63, 60, 57, 54, 51,
            Integer.MIN_VALUE };// 女生-六年级-跳绳标准
    // ------------------------------------------------------------------------
    // 立定跳远
    // ------------------------------------------------------------------------
    public static final int[] LongJumpStardardML = { 273, 268, 263, 256, 248,
            244, 240, 236, 232, 228, 224, 220, 216, 212, 208, 203, 198, 193,
            188, 183, Integer.MIN_VALUE };// 男生-低年级-立定跳远标准

    public static final int[] LongJumpStardardMH = { 275, 270, 265, 258, 250,
            246, 242, 238, 234, 230, 226, 222, 218, 214, 210, 205, 200, 195,
            190, 185, Integer.MIN_VALUE };// 男生-高年级-立定跳远标准

    public static final int[] LongJumpStardardFL = { 207, 201, 195, 188, 181,
            178, 175, 172, 169, 166, 163, 160, 157, 154, 151, 146, 141, 136,
            131, 126, Integer.MIN_VALUE };// 女生-低年级-立定跳远标准

    public static final int[] LongJumpStardardFH = { 208, 202, 196, 189, 182,
            179, 176, 173, 170, 167, 164, 161, 158, 155, 152, 147, 142, 137,
            132, 127, Integer.MIN_VALUE };// 女生-高年级-立定跳远标准
    // ------------------------------------------------------------------------
    // 引体向上、仰卧起坐
    // ------------------------------------------------------------------------
    public static final int[] PullUpStardardML = { 19, 18, 17, 16, 15,
            Integer.MAX_VALUE, 14, Integer.MAX_VALUE, 13, Integer.MAX_VALUE,
            12, Integer.MAX_VALUE, 11, Integer.MAX_VALUE, 10, 9, 8, 7, 6, 5,
            Integer.MIN_VALUE };// 男生-低年级-引体向上标准

    public static final int[] PullUpStardardMH = { 20, 19, 18, 17, 16,
            Integer.MAX_VALUE, 15, Integer.MAX_VALUE, 14, Integer.MAX_VALUE,
            13, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, 11, 10, 9, 8, 7, 6,
            Integer.MIN_VALUE };// 男生-高年级-引体向上标准

    public static final int[] SitUpStardardFL = { 56, 54, 52, 49, 46, 44, 42,
            40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16,
            Integer.MIN_VALUE };// 女生-低年级-仰卧起坐标准

    public static final int[] SitUpStardardFH = { 57, 55, 53, 50, 47, 45, 43,
            41, 39, 37, 35, 33, 31, 29, 27, 25, 23, 21, 19, 17,
            Integer.MIN_VALUE };// 女生-高年级-仰卧起坐标准
    // ------------------------------------------------------------------------
    // 1000/800米长跑
    // ------------------------------------------------------------------------
    public static final double[] RaceStardardML = { 3.17, 3.22, 3.27, 3.34,
            3.42, 3.47, 3.52, 3.57, 4.02, 4.07, 4.12, 4.17, 4.22, 4.27, 4.32,
            4.52, 5.12, 5.32, 5.52, 6.12, Double.MAX_VALUE };// 男生-低年级-1000米长跑标准

    public static final double[] RaceStardardMH = { 3.15, 3.20, 3.25, 3.32,
            3.40, 3.45, 3.50, 3.55, 4.00, 4.05, 4.10, 4.15, 4.20, 4.25, 4.30,
            4.50, 5.10, 5.30, 5.50, 6.10, Double.MAX_VALUE };// 男生-高年级-1000米长跑标准

    public static final double[] RaceStardardFL = { 3.18, 3.24, 3.30, 3.37,
            3.44, 3.49, 3.54, 3.59, 4.04, 4.09, 4.14, 4.19, 4.24, 4.29, 4.34,
            4.44, 4.54, 5.04, 5.14, 5.24, Double.MAX_VALUE };// 女生-低年级-800米长跑标准

    public static final double[] RaceStardardFH = { 3.16, 3.22, 3.28, 3.35,
            3.42, 3.47, 3.52, 3.57, 4.02, 4.07, 4.12, 4.17, 4.22, 4.27, 4.32,
            4.42, 4.52, 5.02, 5.12, 5.22, Double.MAX_VALUE };// 女生-高年级-800米长跑标准
    // ------------------------------------------------------------------------
}
