package com.wzsport.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wzsport.model.Student;
import com.wzsport.util.FileUtil;
import com.wzsport.util.PathUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Api(tags = "文件上传相关接口")
@CrossOrigin
@Controller
//@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
public class FileController {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> uploadFile(@ApiParam("Excel文件") @RequestParam("file") MultipartFile file) {
        String imagePath = "";
        String imageUrl = "";
        try {
            imagePath = FileUtil.uploadFile(PathUtil.FILE_STORAGE_PATH, file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        imageUrl = PathUtil.ORIGIN + File.separator + PathUtil.FILE_FOLDER_PATH + imagePath;
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(imageUrl);
    }
    
//    public List<Student> ReadExcelAsList(){
//        List<Student> stus= new ArrayList<>();
//        Workbook book;
//        Sheet sheet;
//        Cell colName1,colName2,colName3,colName4;
//        Cell cel1,cel2,cel3,cel4;
//        try {
//            book = Workbook.getWorkbook(new File("f:/text.xls"));
//            sheet=book.getSheet("Sheet1");
//            colName1= sheet.getCell(0, 0);
//            colName2= sheet.getCell(1, 0);
//            colName3= sheet.getCell(2, 0);
//            colName4= sheet.getCell(3, 0);
//            System.out.println(colName1.getContents()+"  "+colName2.getContents()+
//                    "  "+colName3.getContents()+"  "+colName4.getContents());
//        
//            int i=1;
//            for( i=1;i<sheet.getRows();i++)
//            {
//                cel1= sheet.getCell(0,i);
//                cel2= sheet.getCell(1,i);
//                cel3= sheet.getCell(2,i);
//                cel4= sheet.getCell(3,i);
//                
//                String no = cel1.getContents();
//                String name = cel2.getContents();
//                String age = cel3.getContents();
//                float score = Float.parseFloat(cel4.getContents());
//                
//                Student stu = new Student(no, name, age, score);
//                stus.add(stu);
//                System.out.println(no + name + age + score);
//                
//            }
//            
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return stus;
//    }
}
