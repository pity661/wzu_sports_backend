package com.wzsport.service;

import com.wzsport.model.Student;

import java.util.List;

/**
 * Created by kouga on 2017/8/19.
 */
public interface StudentService {

    /**
     *
     */
    public List<Student> getStudentByUniversityIdAndStudentNo(long universityId, String studentNo);
}
