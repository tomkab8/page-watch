package com.bc.pagewatch.storage.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.bc.pagewatch.logging.LogBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.regions.Regions.EU_CENTRAL_1;

@Configuration
@Log4j2
@AllArgsConstructor
@EnableConfigurationProperties(S3Properties.class)
public class S3Config implements InitializingBean {

    private S3Properties s3Properties;

    @Override
    public void afterPropertiesSet() {
        log.info(LogBuilder.configure(s3Properties));
    }

    @Bean
    public S3Service s3Service(S3Properties s3Properties, S3Storage s3Storage) {
        return new S3Service(s3Storage, s3Properties.getBucket());
    }

    @Bean
    public S3Storage s3Storage(AmazonS3 amazonS3) {
        return new S3Storage(amazonS3);
    }

    @Bean
    public AmazonS3 s3Client(S3Properties properties) {
        return AmazonS3ClientBuilder
                .standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(properties.getUrl(), EU_CENTRAL_1.getName()))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", EU_CENTRAL_1.getName()))
                .withPathStyleAccessEnabled(true)
// .withClientConfiguration(new ClientConfiguration())
                .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))
                .build();
    }
}
