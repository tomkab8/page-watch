package com.bc.pagewatch.web;

import com.bc.pagewatch.service.ImageComparisonService;
import com.bc.pagewatch.service.SnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SnapshotController {

    @Autowired
    private SnapshotService snapshotService;

    @Autowired
    private ImageComparisonService imageComparisonService;

    @GetMapping("/snapshot")
    public String takeSnapshot(@RequestParam String url, @RequestParam String filePath) throws IOException {
        snapshotService.takeSnapshot(url, filePath);

        return "Snapshot taken and saved to " + filePath;
    }

    @GetMapping("/compare")
    public String compareSnapshots(
            @RequestParam String imagePath1, @RequestParam String imagePath2, @RequestParam String diffImagePath
    ) {
        imageComparisonService.compareImages(imagePath1, imagePath2, diffImagePath);

        return "Comparison done and diff image saved to " + diffImagePath;
    }
}
