package com.bc.pagewatch.storage.s3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage.s3")
@NoArgsConstructor
@Getter
public class S3Properties {

    private String url;

    private String bucket;

    private String accessKey;

    private String secretAccessKey;
}
