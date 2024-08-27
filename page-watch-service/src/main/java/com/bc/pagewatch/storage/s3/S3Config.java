package com.bc.pagewatch.storage.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.regions.Regions.EU_CENTRAL_1;

@Configuration
@Log4j2
//@EnableConfigurationProperties(S3Properties.class)
public class S3Config {

    @Value("${storage.s3.url}")
    private String url;

    @Value("${storage.s3.bucket}")
    private String bucket;

    //private S3Properties s3Properties;
    //@Override
    //public void afterPropertiesSet() {
    //    log.info(LogBuilder.configure(s3Properties));
    //}

    @Bean
    public S3Service s3Service(S3Storage s3Storage) {
        return new S3Service(s3Storage, bucket);
    }

    @Bean
    public S3Storage s3Storage(AmazonS3 amazonS3) {
        return new S3Storage(amazonS3);
    }

    @Bean
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder
                .standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(properties.getUrl(), EU_CENTRAL_1.getName()))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(url, EU_CENTRAL_1.getName()))
                .withPathStyleAccessEnabled(true)
// .withClientConfiguration(new ClientConfiguration())
                .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
                .build();
    }
}
