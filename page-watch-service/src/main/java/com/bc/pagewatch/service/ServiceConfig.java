package com.bc.pagewatch.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SnapshotService snapshotService(WebDriver webDriver) {
        return new SnapshotService(webDriver);
    }

    @Bean
    public ImageComparisonService imageComparisonService() {
        return new ImageComparisonService();
    }

    @Bean
    WebDriver webDriver() {
        // TODO not sure we need this property since using the maven java lib
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        return new ChromeDriver(options);
    }
}
