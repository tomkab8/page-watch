package com.bc.pagewatch.schedule;

import com.bc.pagewatch.service.SnapshotService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class SnapshotScheduler {

    // TODO This should come from the DB!
    private static final String URL = "https://www.news247.gr/";
    private static final String BASE_PATH = "snapshots/";

    private SnapshotService snapshotService;

    @Scheduled(fixedRate = 3600000) // 1 hour in milliseconds
    public void captureSnapshot() throws IOException {
        String filePath = BASE_PATH + "snapshot_" + getTimestamp() + ".png";

        snapshotService.takeSnapshot(URL, filePath);
    }

    private String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
