package com.wzsport.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wzsport.service.CloudStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by kouga on 2017/8/17.
 */

@Service
public class QiniuService implements CloudStorageService {

    private String domain;
    /**
     *
     */
    private String accessKey;

    /**
     *
     */
    private String secretKey;

    /**
     *
     */
    private String bucket;

    /**
     *
     */
    private Auth auth;


    /**
     * 华东	Zone.zone0()     1
     * 华北	Zone.zone1()     2
     * 华南	Zone.zone2()     3
     * 北美	Zone.zoneNa0()   4
     */
//    private int zoneIndex;

    public QiniuService(@Value("${qiniu.url}") String domain, @Value("${qiniu.accessKey}") String accessKey, @Value("${qiniu.secretKey}") String secretKey) {
        this.domain = domain;
        this.accessKey = accessKey;
        this.secretKey = secretKey;

        this.init();
    }

    private void init() {
        this.auth = Auth.create(this.accessKey, this.secretKey);
    }


    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public void uploadImage(String localFilePath, String key) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String upToken = this.auth.uploadToken(this.bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    @Override
    public String generateUrl(String fileName) {
        return this.auth.privateDownloadUrl(this.domain + "/" + fileName);
    }
}
