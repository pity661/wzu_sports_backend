package com.wzsport.controller;

import com.wzsport.model.Student;
import com.wzsport.service.StudentService;
import com.wzsport.util.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kouga on 2017/8/19.
 */
@Api(tags = "学生相关接口")
@RestController
@RequestMapping(value = "/student", produces = "application/json;charset=UTF-8")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

//    private int status = 0;

    /**
     * The res body.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
//    private ResponseBody resBody;


    @ApiOperation(value = "验证学生学籍信息", notes = "验证指定学校的学生学籍信息")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseEntity<?> validateStudentInfo(
            @ApiParam("学校id")
            @RequestParam long universityId,
            @ApiParam("学生学号")
            @RequestParam String studentNo,
            @ApiParam("学生姓名")
            @RequestParam String studentName
    ) {

        List<Student> studentList = studentService.getStudentByUniversityIdAndStudentNo(universityId, studentNo);

        if (studentList.size() == 0) {
        	ResponseBody resBody = new ResponseBody<Integer>();
            resBody.statusMsg = "该学号不存在哦！";
            resBody.obj = 1000;
            int status = 404;
            return ResponseEntity.status(status).body(resBody);
        }

        Student student = studentList.get(0);
        if (!student.getName().equals(studentName)) {
        	ResponseBody resBody = new ResponseBody<Integer>();
            resBody.statusMsg = "该学生姓名和学号不符合哦！";
            resBody.obj = 1001;
            int status = 404;
            return ResponseEntity.status(status).body(resBody);
        }

        int status = 200;
        ResponseBody resBody = new ResponseBody<Student>();
        resBody.obj = student;
        return ResponseEntity.status(status).body(resBody);
    }
}
