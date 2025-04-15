package com.easypay.settlementservice.scheduler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SettlementBatchScheduler {

    private static final Logger logger = LoggerFactory.getLogger(SettlementBatchScheduler.class);

    private final JobLauncher jobLauncher;
    private final Job settlementJob;

    @Scheduled(fixedRate = 10000) // 10초마다 실행
    public void runSettlementJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(settlementJob, jobParameters);
            logger.info("Settlement job started successfully with parameters: {}", jobParameters);
        } catch (Exception e) {
            logger.error("Error occurred while launching settlement job", e);
        }
    }
}
