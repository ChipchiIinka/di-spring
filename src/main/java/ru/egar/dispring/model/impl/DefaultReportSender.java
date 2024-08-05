package ru.egar.dispring.model.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.egar.dispring.di.annotation.Benchmark;
import ru.egar.dispring.model.ReportSender;

@Slf4j
@Component
public class DefaultReportSender implements ReportSender {

    @Benchmark
    @Override
    public void sendReport(String text) {
        log.info("Task result: {}", text);
    }
}
