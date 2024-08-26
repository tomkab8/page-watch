package com.bc.pagewatch.service;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageComparisonService {

    static {
        OpenCV.loadLocally();
    }

    public void compareImages(String oldImagePath, String newImagePath, String diffImagePath) {
        Mat oldImage = Imgcodecs.imread(oldImagePath);
        Mat newImage = Imgcodecs.imread(newImagePath);

        Mat diff = new Mat();
        Core.absdiff(oldImage, newImage, diff);
        Imgproc.cvtColor(diff, diff, Imgproc.COLOR_BGR2GRAY);
        Core.normalize(diff, diff, 0, 255, Core.NORM_MINMAX);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(diff, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            Rect rect = Imgproc.boundingRect(contour);
            Imgproc.rectangle(oldImage, rect, new Scalar(0, 0, 255), 2);
        }

        Imgcodecs.imwrite(diffImagePath, oldImage);
    }
}
