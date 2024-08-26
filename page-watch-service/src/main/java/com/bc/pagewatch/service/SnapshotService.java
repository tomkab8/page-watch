package com.bc.pagewatch.service;

import lombok.AllArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class SnapshotService {

    private WebDriver webDriver;

    public void takeSnapshot(String url, String filePath) throws IOException {
        webDriver.get(url);
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        BufferedImage bufferedImage = ImageIO.read(screenshot);

        ImageIO.write(bufferedImage, "png", new File(filePath));
    }

}
