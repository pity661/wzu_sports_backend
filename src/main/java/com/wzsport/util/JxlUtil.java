package com.wzsport.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.mapper.PhysicalTestMapper;
import com.wzsport.mapper.SportsCourseMapper;
import com.wzsport.model.PhysicalTest;
import com.wzsport.model.PhysicalTestExample;
import com.wzsport.model.SportsCourse;
import com.wzsport.model.SportsCourseExample;
import com.wzsport.service.PhysicalTestService;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author wenky
 *
 */
public class JxlUtil {
	
	/**
	 * @param file
	 * @param universityId
	 * @param schoolYear
	 * @param term
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SportsCourse> dealSportsCourse(File file, Long universityId, String schoolYear, String term) {
		// TODO Auto-generated method stub
		List<SportsCourse> sportsCourses = new ArrayList();
		Workbook book;
		Sheet sheet;
		try {
			book = Workbook.getWorkbook(file);
			sheet = book.getSheet(0);
			for (int i = 1; i<sheet.getRows();i++) {
				List<String> cel = new ArrayList();
				SportsCourse sportsCourse = new SportsCourse();
				for (int j=0; j < 12 ; j++) {
					cel.add(sheet.getCell(j, i).getContents());
				}
				sportsCourse.setUniversityId(universityId);
				sportsCourse.setSchoolYear(schoolYear);
				if (term.equals("第一学期")) {
					sportsCourse.setTerm(1);
					sportsCourse.setYear(schoolYear.substring(0, 4));
				} else {
					sportsCourse.setTerm(2);
					sportsCourse.setYear(schoolYear.substring(5, 9));
				}
				sportsCourse.setSubjectNumber(cel.get(3));
				sportsCourse.setCourseName(cel.get(4));
				sportsCourse.setTeacherName(cel.get(5));
				sportsCourse.setCourseTime(cel.get(6));
				sportsCourse.setStudentNo(cel.get(7));
				sportsCourse.setStudentName(cel.get(8));
				if (cel.get(9).equals("男")) {
					sportsCourse.setIsMan(true);
				} else {
					sportsCourse.setIsMan(false);
				}
				sportsCourse.setMajorName(cel.get(10));
				sportsCourse.setCollegeName(cel.get(11));
				sportsCourses.add(sportsCourse);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sportsCourses;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PhysicalTest> dealPhysicalTest(File file,Long universityId,String schoolYear,String term) {
		List<PhysicalTest> physicalTests = new ArrayList();
		Workbook book;
		Sheet sheet;
		try {
			book = Workbook.getWorkbook(file);
			sheet = book.getSheet(0);
			//第一行是名称，从第二行开始写
			for (int i = 1; i<sheet.getRows(); i++) {
				List<String> cel = new ArrayList();
				PhysicalTest physicalTest = new PhysicalTest();
				for (int j = 0; j<19;j++) {
					cel.add(sheet.getCell(j, i).getContents());
				}
				physicalTest.setUniversityId(universityId);
				physicalTest.setSchoolYear(schoolYear);
				if (term.equals("第一学期")) {
					physicalTest.setTerm(1);
					physicalTest.setYear(schoolYear.substring(0, 4));
				} else {
					physicalTest.setTerm(2);
					physicalTest.setYear(schoolYear.substring(5, 9));
				}
				if (cel.get(0).length() == 0 || cel.get(0).equals("")) {
					physicalTest.setGradeNo((long)0);
				} else {
					physicalTest.setGradeNo(Long.parseLong(cel.get(0)));
				}
				physicalTest.setStudentName(cel.get(1));
				physicalTest.setClassName(cel.get(2));
				physicalTest.setCollegeName(cel.get(3));
				if (cel.get(4).equals("男")) {
					physicalTest.setIsMan(true);
				} else {
					physicalTest.setIsMan(false);
				}
				physicalTest.setStudentNo(cel.get(5));
				physicalTest.setMark(cel.get(6));
				cel.set(7, testIsNull(cel.get(7)));
				physicalTest.setTotalScore(new BigDecimal(cel.get(7)).doubleValue());
				physicalTest.setTotalScoreGrade(cel.get(8));
				cel.set(9, testIsNull(cel.get(9)));
				physicalTest.setHeight(new BigDecimal(cel.get(9)).doubleValue());
				cel.set(10, testIsNull(cel.get(10)));
				physicalTest.setWeight(new BigDecimal(cel.get(10)).doubleValue());
				cel.set(11, testNotDouble(cel.get(11)));
				physicalTest.setVitalCapacity((long)new Long(cel.get(11)));
				cel.set(12, testNotDouble(cel.get(12)));
				physicalTest.setStandingLongJump(new Integer(cel.get(12)));
				cel.set(13, testIsNull(cel.get(13)));
				physicalTest.setSitAndReach(new BigDecimal(cel.get(13)).doubleValue());
				cel.set(14, testNotDouble(cel.get(14)));
				physicalTest.setOneMinuteSitUp(new Integer(cel.get(14)));
				cel.set(15, testNotDouble(cel.get(15)));
				physicalTest.setPullUp(new Integer(cel.get(15)));
				cel.set(16, testIsNull(cel.get(16)));
				physicalTest.setFiftyRunTime(new BigDecimal(cel.get(16)).doubleValue());
				cel.set(17, testIsNull(cel.get(17)));
				physicalTest.setEightHundredRunTime(new BigDecimal(cel.get(17)).doubleValue());
				cel.set(18, testIsNull(cel.get(18)));
				physicalTest.setOneThousandRunTime(new BigDecimal(cel.get(18)).doubleValue());
				physicalTests.add(physicalTest);
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return physicalTests;
	}
	private String testNotDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if (str.length() == 0 || str.equals("")) {
			return new String("0");
		} else if (!pattern.matcher(str).matches()) {
			int idx = str.lastIndexOf(".");//查找小数点的位置
			return str.substring(0,idx);
		} else {
			return str;
		}
	}
	private String testIsNull(String str) {
		if (str.length() == 0 || str.equals("")) {
			return new String("0");
		} else {
			return str;
		}
	}
	
}
