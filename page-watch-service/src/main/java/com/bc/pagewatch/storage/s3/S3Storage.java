package com.bc.pagewatch.storage.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import lombok.AllArgsConstructor;

import java.io.InputStream;

@AllArgsConstructor
public class S3Storage {

    private final AmazonS3 amazonS3;

    public boolean objectExists(String bucketName, String storageKey) {
        try {
            amazonS3.doesObjectExist(bucketName, storageKey);

            return true;
        } catch (AmazonS3Exception e) {
            throw e;
        }
    }

    public void storeObject(String bucketName, String storageKey, InputStream inputStream, long contentLength) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(contentLength);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, storageKey, inputStream, objectMetadata);

        try {
            amazonS3.putObject(putObjectRequest);

        } catch (AmazonS3Exception e) {
            throw e;
        }
    }

    public InputStream getObject(String bucketName, String storageKey) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, storageKey);

        S3Object s3Object = amazonS3.getObject(getObjectRequest);

        return s3Object.getObjectContent();
    }
}
