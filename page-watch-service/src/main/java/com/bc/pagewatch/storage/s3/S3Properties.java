package com.bc.pagewatch.storage.s3;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage.s3")
@NoArgsConstructor
@Data
public class S3Properties {

    private String url;

    private String bucketName;

    private String accessKey;

    private String secretAccessKey;
}
