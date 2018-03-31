/**
 * 
 */
package com.wzsport.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wzsport.model.PhysicalTest;
import com.wzsport.model.SportsCourse;
import com.wzsport.service.PhysicalTestService;
import com.wzsport.service.SportsCoursesService;
import com.wzsport.util.JxlUtil;

import io.swagger.annotations.ApiParam;

/**
 * @author wenky
 *
 */
@Controller
public class UploadExcelController {

	@Autowired
	private PhysicalTestService physicalTestService;
	
	@Autowired
	private SportsCoursesService sportsCoursesService;
	
	@RequestMapping(value = { "/importPhysicalTest" }, method = RequestMethod.POST)
	public ResponseEntity<?> importPhysicalTest(
			@ApiParam("excel文件") 
			@RequestParam(name = "file") MultipartFile multipartFile,
			@ApiParam("学校id")
			@RequestParam Long universityId,
			@ApiParam("学年")
			@RequestParam String schoolYear,
			@ApiParam("学期")
			@RequestParam String term,
			@ApiParam("文件名")
			@RequestParam String fileName) throws IOException {
		File file = multipartToFile(multipartFile,fileName);
		JxlUtil jxlUtil = new JxlUtil();
		List<PhysicalTest> physicalTests = jxlUtil.dealPhysicalTest(file,universityId,schoolYear,term);
		file.delete();
		if (physicalTests.size() == 1) {
			if (physicalTests.get(0).getStudentName().equals("解析时发生错误")) {
				return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN)
						.body("解析第"+physicalTests.get(0).getMark()+"行时发生错误");
			}
		}
		//读取成功新建线程处理任务
		System.out.println("-------  开始插入数据    ---------");
		Thread physicalTestThread = new Thread() {
			public void run() {
				for (PhysicalTest physicalTest:physicalTests) {
					physicalTestService.updatePhysicalTest(physicalTest);
				}
			}
		};
		physicalTestThread.start();
//		Runnable physicalTestRunnable = new PhysicalTestThread(physicalTests);
//		new Thread(physicalTestRunnable).start();
		System.out.println("-------  数据全部插入成功    ---------");
		return ResponseEntity.status(HttpServletResponse.SC_OK).body("上传成功,等待服务器处理");
	}
	
	@RequestMapping(value = { "/importSportsCourse" }, method = RequestMethod.POST)
	public ResponseEntity<?> importSportsCourse(
			@ApiParam("excel文件") 
			@RequestParam(name = "file") MultipartFile multipartFile,
			@ApiParam("学校id")
			@RequestParam Long universityId,
			@ApiParam("学年")
			@RequestParam String schoolYear,
			@ApiParam("学期")
			@RequestParam String term,
			@ApiParam("文件名")
			@RequestParam String fileName) throws IOException {
		File file = multipartToFile(multipartFile,fileName);
		JxlUtil jxlUtil = new JxlUtil();
		List<SportsCourse> sportsCourses = jxlUtil.dealSportsCourse(file,universityId,schoolYear,term);
		file.delete();
		//读取成功新建线程处理任务
		Thread sportsCourseThread = new Thread() {
			public void run() {
				for (SportsCourse sportsCourse : sportsCourses) {
					sportsCoursesService.updateSportsCourse(sportsCourse);
				}
			}
		};
		sportsCourseThread.start();
		return ResponseEntity.status(HttpServletResponse.SC_OK).body("上传成功,等待服务器处理");
	}
	
	private File multipartToFile(MultipartFile multfile,String fileName) throws IOException { 
	    CommonsMultipartFile cf = (CommonsMultipartFile)multfile;  
	    //这个myfile是MultipartFile的 
	    DiskFileItem fi = (DiskFileItem) cf.getFileItem();
	    File file = fi.getStoreLocation();
	    System.out.println(file.getParent());
        File newNameFile = new File(file.getParent() + File.separator + fileName);
        file.renameTo(newNameFile);
	    return newNameFile;
	}
	
}
