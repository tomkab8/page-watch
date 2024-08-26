package com.bc.pagewatch.schedule;

import com.bc.pagewatch.service.SnapshotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {

    @Bean
    public SnapshotScheduler snapshotScheduler(SnapshotService snapshotService) {
        return new SnapshotScheduler(snapshotService);
    }
}
