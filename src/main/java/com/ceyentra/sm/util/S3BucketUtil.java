package com.ceyentra.sm.util;

import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.model.*;

import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.transfer.model.UploadResult;
import com.amazonaws.util.IOUtils;

import com.ceyentra.sm.exception.ApplicationServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class S3BucketUtil {

    @Value("${aws.s3.bucket.url}")
    private String bucketUrl;

    @Value("${aws.s3.bucket.bucket.name}")
    private String bucketName;

    @Value("${aws.s3.bucket.bucket.domain}")
    private String bucketDomain;

    @Autowired
    private AmazonS3 amazonS3Client;

    private final Object uploadLock = new Object();

    public String uploadFileToS3bucket(String folderName, String fileName, File file) {
        return uploadFileToS3bucket(folderName + "/" + fileName, file);
    }



    public String uploadMultipartToS3bucket(String fileName, MultipartFile file) {
        try {
            String contentType = file.getContentType();
            return uploadInputStreamToS3bucket(fileName, file.getInputStream(), contentType);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String uploadInputStreamToS3bucket(String fileName, InputStream inputStream, String contentType) {
        TransferManagerBuilder transferManagerBuilder = TransferManagerBuilder.standard();
        transferManagerBuilder.setS3Client(amazonS3Client);
        TransferManager transferManager = transferManagerBuilder.build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(inputStream.available());
            metadata.setContentType(contentType);
            metadata.setCacheControl("no-cache");

//            PutObjectResult putObjectResult = amazonS3Client.putObject(
//                    new PutObjectRequest(bucketName, fileName, inputStream, metadata)
//            );
            Upload upload = transferManager.upload(new PutObjectRequest(bucketName, fileName, inputStream, metadata));
            log.info("is upload done: " + upload.isDone());
            upload.waitForCompletion();
            log.info("is upload done: " + upload.isDone());
            log.info("upload info: " + upload.waitForUploadResult().getKey());
//            return bucketUrl + "/" + fileName;
            return bucketDomain + "/" + fileName;
        } catch (Exception e) {
            log.info("uploading image failed");
            log.info(e.getMessage());
            return null;
        }
    }

    private String uploadFileToS3bucket(String fileName, File file) {

        amazonS3Client.putObject(
                new PutObjectRequest(bucketName, fileName, file)
        );
        return bucketDomain + "/" + fileName;
    }


    public String getContentTypeFromBase64EncodedImage(String encodedImage) {
        String[] firstSplit = encodedImage.split(";");
        if (firstSplit.length < 2) {
            log.info("failed to get image content type");
            return null;
        }
        String[] secondSplit = firstSplit[0].split(":");
        if (secondSplit.length < 2) {
            log.info("failed to get image content type 2");
            return null;
        }
        return secondSplit[1];

    }

    public InputStream getObjectAsInputStream(String objectName) {
        S3Object s3Object = amazonS3Client.getObject(bucketName, objectName);
        return s3Object.getObjectContent();
    }

    public S3Object getS3Object(String objectName) {
        S3Object s3Object = amazonS3Client.getObject(bucketName, objectName);
        return s3Object;
    }


    public String getImageStringbody(String encodedImage) {
        String[] firstSplit = encodedImage.split(",");
        if (firstSplit.length < 2) {
            log.info("failed to get image");
            return null;
        }
        return firstSplit[1];

    }

    public List<String> getAllFileNamesInABucket(String bucketName) {
        try {
            ObjectListing objectListing = amazonS3Client.listObjects(bucketName);
            List<S3ObjectSummary> summeries = objectListing.getObjectSummaries();
            List<String> fileNameList = summeries.stream().map(s3ObjectSummary -> s3ObjectSummary.getKey()).collect(Collectors.toList());
            return fileNameList;
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw new ApplicationServiceException(200,false, "static files load failed");
        }
    }
}
