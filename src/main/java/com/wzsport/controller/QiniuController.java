package com.wzsport.controller;

import com.wzsport.model.AreaActivityData;
import com.wzsport.service.CloudStorageService;
import com.wzsport.service.impl.QiniuService;
import com.wzsport.util.PathUtil;
import com.wzsport.util.PropertyUtil;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by kouga on 2017/8/18.
 */

@Api(tags = "对接七牛的SDK")
@RestController
@RequestMapping(value = "qiniu", produces = "application/json;charset=UTF-8")
public class QiniuController {

    private static final Logger logger = LoggerFactory.getLogger(QiniuController.class);

    @Autowired
    private CloudStorageService qiniuService;


    @ApiOperation(value = "七牛上传文件", notes = "七牛上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<?> upload(
            @ApiParam("图片")
            @RequestParam("mfile") MultipartFile mfile
    ) throws IOException {

        logger.info("进来啦");

        String fileName = mfile.getOriginalFilename();
        String filePath = PathUtil.getImagePath() + fileName;
        File file = new File(filePath);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        mfile.transferTo(file);


        this.qiniuService.setBucket(PropertyUtil.getProperty("qiniu.wzsport_head_image_bucket"));
        this.qiniuService.uploadImage(filePath, fileName);

        file.delete();

        ResponseBody resBody = new ResponseBody<AreaActivityData>();
        int status = 200;

        return ResponseEntity.status(status).body(resBody);

    }
}
