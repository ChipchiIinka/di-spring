package ru.egar.dispring.model.impl;

import org.springframework.stereotype.Component;
import ru.egar.dispring.di.annotation.Benchmark;
import ru.egar.dispring.model.ReportSender;

@Component
public class DefaultReportSender implements ReportSender {

    @Benchmark
    @Override
    public void sendReport(String text) {
        System.out.println("Task result: " + text);
    }
}
