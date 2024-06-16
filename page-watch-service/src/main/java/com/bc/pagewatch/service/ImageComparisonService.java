package com.bc.pagewatch.service;

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
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public void compareImages(String imagePath1, String imagePath2, String diffImagePath) {
        Mat img1 = Imgcodecs.imread(imagePath1);
        Mat img2 = Imgcodecs.imread(imagePath2);

        Mat diff = new Mat();
        Core.absdiff(img1, img2, diff);
        Imgproc.cvtColor(diff, diff, Imgproc.COLOR_BGR2GRAY);
        Core.normalize(diff, diff, 0, 255, Core.NORM_MINMAX);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(diff, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            Rect rect = Imgproc.boundingRect(contour);
            Imgproc.rectangle(img1, rect, new Scalar(0, 0, 255), 2);
        }

        Imgcodecs.imwrite(diffImagePath, img1);
    }
}
