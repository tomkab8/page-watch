package com.bc.pagewatch.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class SnapshotService {

    private WebDriver webDriver;

    public SnapshotService() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        this.webDriver = new ChromeDriver(options);
    }

    public void takeSnapshot(String url, String filePath) throws IOException {
        webDriver.get(url);
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        BufferedImage bufferedImage = ImageIO.read(screenshot);
        ImageIO.write(bufferedImage, "png", new File(filePath));
    }

}
