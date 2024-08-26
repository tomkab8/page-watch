package com.bc.pagewatch.storage.s3;

import lombok.AllArgsConstructor;

import java.io.InputStream;

@AllArgsConstructor
public class S3Service {

    private S3Storage s3Storage;
    private String bucketName;

    public boolean objectExists(String storageKey) {
        return s3Storage.objectExists(bucketName, storageKey);
    }

    public void storeObject(String storageKey, InputStream inputStream, long contentLength) {
        if (inputStream == null || contentLength == 0) {
            // TODO log empty
            return;
        }

        s3Storage.storeObject(bucketName, storageKey, inputStream, contentLength);
    }

    public InputStream getObject(String storageKey) {
        return s3Storage.getObject(bucketName, storageKey);
    }

    public boolean deleteObject(String storageKey) {
        // TODO

        return false;
    }
}
