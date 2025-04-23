package com.bzh.common.utils;

import com.aliyun.oss.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Component
public class AliYunOSSUtils {
    //1.阿里云 oss域名
    @Value("${aliyun.aliDomain}")
    private String aliDomain;
    //2.地域节点 密钥
    @Value("${aliyun.endPoint}")
    private String endPoint;
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKey}")
    private String accessKey;
    @Value("${aliyun.bucketName}")
    private String bucketName;
    // 3.OSS客户端对象
    public static OSS ossClient = null;

    // 1.上传
    public String uploadFile(MultipartFile file,String fileName) throws IOException {
        // 新建连接池
        ossClient = new OSSClientBuilder()
                .build(endPoint, accessKeyId, accessKey);
        // putObject(仓库名,文件名,文件。getInputStream):将文件上传到云
        ossClient.putObject(bucketName, fileName, file.getInputStream());
        ossClient.shutdown(); // 关闭阿里云 oss仓库
        return aliDomain + fileName;
    }

    // 1.上传byte
    public String uploadByte(byte[] content,String fileName) throws IOException {
        // 新建连接池
        ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKey);
        // putObject(仓库名,文件名,文件。getInputStream):将文件上传到云
        ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(content));
        ossClient.shutdown(); // 关闭阿里云 oss仓库
        return aliDomain + fileName;
    }




}



