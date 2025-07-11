package com.easypay.settlementservice.job;

import com.easypay.settlementservice.tasklet.SettlementTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class SettlementJob {

  private final JobRepository jobRepository;
  private final PlatformTransactionManager transactionManager;
  private final SettlementTasklet helloTasklet;

  @Bean
  public Job job() {
    log.info("job 실행");
    return new JobBuilder("settlement", jobRepository)
        .start(step())
        .build();
  }

  @Bean
  public Step step() {
    log.info("step 실행");
    return new StepBuilder("settlementStep", jobRepository)
        .tasklet(helloTasklet, transactionManager)
        .build();
  }
}