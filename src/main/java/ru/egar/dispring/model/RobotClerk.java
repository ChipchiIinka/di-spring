package ru.egar.dispring.model;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.egar.dispring.di.annotation.InjectRandomInt;

@Slf4j
@Data
@Component
@RequiredArgsConstructor
public class RobotClerk {

    private final TaskReceiver taskReceiver;
    private final TaskExecutor taskExecutor;
    private final ReportSender reportSender;

    private String name;

    @InjectRandomInt(min = 2, max = 3)
    private int repeat = 1;

    public void doWork() {
        log.info("Count of repeats: {}", repeat);
        taskReceiver.addTask("Drink coffee", "Drank a lot of coffee");
        for (int i = 0; i < repeat; i++) {
            taskReceiver.getTasks()
                    .map(taskExecutor::execute)
                    .forEach(reportSender::sendReport);
        }
    }

    @PostConstruct
    public void init() {
        this.name = "Jack";
        log.info("Hello, my name is {}", this.name);
    }
}
