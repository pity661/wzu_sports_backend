package com.wzsport.service.impl;

import com.wzsport.mapper.StudentMapper;
import com.wzsport.model.Student;
import com.wzsport.model.StudentExample;
import com.wzsport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kouga on 2017/8/19.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentByUniversityIdAndStudentNo(long universityId, String studentNo) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andUniversityIdEqualTo(universityId).andStudentNoEqualTo(studentNo);

        List<Student> studentList = studentMapper.selectByExample(studentExample);

        return studentList;
    }
}
