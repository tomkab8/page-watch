package com.bc.pagewatch.schedule;

import com.bc.pagewatch.service.SnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SnapshotScheduler {

    private static final String URL = "http://example.com";
    private static final String BASE_PATH = "snapshots/";

    @Autowired
    private SnapshotService snapshotService;

    @Scheduled(fixedRate = 3600000) // 1 hour in milliseconds
    public void captureSnapshot() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String filePath = BASE_PATH + "snapshot_" + timestamp + ".png";

        snapshotService.takeSnapshot(URL, filePath);
    }
}
