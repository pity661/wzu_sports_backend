package com.wzsport.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wzsport.mapper.TeachingClassStudentSignInCountViewMapper;
import com.wzsport.model.AreaActivity;
import com.wzsport.model.TeachingClassStudentSignInCountView;
import com.wzsport.model.TeachingClassStudentSignInCountViewExample;
import com.wzsport.model.TeachingClassStudentSignInCountViewExample.Criteria;
import com.wzsport.util.PathUtil;
import com.wzsport.util.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Api(tags = "TeachingClassSignInCountFile相关接口")
@RestController()
@RequestMapping(value = "/",produces = "application/json;charset=UTF-8")
public class TeachingClassSignInCountFileController {
	
	@Autowired
	private TeachingClassStudentSignInCountViewMapper teachingClassStudentSignInCountViewMapper;
	
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "导出excel文件", notes = "根据用户页面上传的筛选条件获取所有的学生数据，生成excle文件并导出")
	@RequestMapping(value = "/exportFile", method = RequestMethod.POST)
	public ResponseEntity<?> create(
								@ApiParam("学校")
								@RequestParam Long universityId,		
								@ApiParam("学年")
								@RequestParam String schoolYear,
								@ApiParam("学期")
								@RequestParam String term,
								@ApiParam("教师姓名") 
								@RequestParam String teacherName,
								@ApiParam("课程名") 
								@RequestParam String courseName,
								@ApiParam("课程时间") 
								@RequestParam String courseTime
								)
								{
		TeachingClassStudentSignInCountViewExample example = new TeachingClassStudentSignInCountViewExample();
		Criteria criteria = example.createCriteria();
		if (universityId != null) {
			criteria.andUniversityIdEqualTo(universityId);
		}
		if (schoolYear.length() != 0) {
			criteria.andSchoolYearEqualTo(schoolYear);
		}
		if (term.length() != 0) {
			criteria.andTermEqualTo(term);
		}
		if (teacherName.length() != 0) {
			criteria.andTeacherNameEqualTo(teacherName);
		}
		if (courseName.length() != 0) {
			criteria.andCourseNameEqualTo(courseName);
		}
		if (courseTime.length() != 0) {
			criteria.andCourseTimeEqualTo(courseTime);
		}
		//根据条件取数据
		List<TeachingClassStudentSignInCountView> dataList = 
				teachingClassStudentSignInCountViewMapper.selectByExample(example);
		System.out.println(dataList.size());
		String excelName = null;
		String fileName = null;
		try {
			//导出excel到桌面
			WritableWorkbook wwb = null;
			// 创建可写入的Excel工作簿
		    excelName = String.valueOf(Calendar.getInstance().getTimeInMillis()) + ".xls";
	        fileName = PathUtil.FILE_STORAGE_PATH + excelName;
	        System.out.println(fileName);
	        
	        File file=new File(fileName);
	        if (!file.exists()) {
	        	    file.createNewFile();
	        }
	        //以fileName为文件名来创建一个Workbook
	        wwb = Workbook.createWorkbook(file);
	        // 创建工作表
	        WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
	        //头
	        List<String> firstRow = new ArrayList<>();
	        firstRow.add("学年");firstRow.add("学期");firstRow.add("教师");firstRow.add("课程名");
	        firstRow.add("课程时间");firstRow.add("学生姓名");firstRow.add("学号");firstRow.add("性别");
	        firstRow.add("区域运动打卡次数");firstRow.add("跑步运动打卡次数");firstRow.add("打卡总次数");
	        for (int i = 0;i < firstRow.size();i ++) {
	        	Label lable = new Label(i,0,firstRow.get(i));
	        	ws.addCell(lable);
	        }
	        //数据
	        List<String> dataRow = new ArrayList<>();
            for (int i = 1;i <= dataList.size(); i ++) {
            	dataRow = new ArrayList<>();
            	dataRow.add(dataList.get(i-1).getSchoolYear());
            	dataRow.add(dataList.get(i-1).getTerm());
            	dataRow.add(dataList.get(i-1).getTeacherName());
            	dataRow.add(dataList.get(i-1).getCourseName());
            	dataRow.add(dataList.get(i-1).getCourseTime());
            	dataRow.add(dataList.get(i-1).getStudentName());
            	dataRow.add(dataList.get(i-1).getStudentNo());
            	if (dataList.get(i-1).getIsMan()) {
                	dataRow.add("男");
            	} else {
                	dataRow.add("女");
            	}
            	dataRow.add(dataList.get(i-1).getAreaActivityQualifiedCount().toString());
            	dataRow.add(dataList.get(i-1).getRunningActivityQualifiedCount().toString());
            	Long count = dataList.get(i-1).getAreaActivityQualifiedCount() + dataList.get(i-1).getRunningActivityQualifiedCount();
            	dataRow.add(count.toString());
            	
            	for (int j = 0;j < firstRow.size();j ++) {
            		Label lable = new Label(j,i,dataRow.get(j));
    	        	ws.addCell(lable);
            	}
            }
            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpServletResponse.SC_OK).body(excelName); 
	}
}
