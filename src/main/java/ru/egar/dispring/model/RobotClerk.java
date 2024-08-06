package ru.egar.dispring.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.egar.dispring.di.annotation.InjectRandomInt;

import javax.annotation.PostConstruct;

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
        System.out.println("Count of repeats: " + repeat);
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
        System.out.println("Hello, my name is " + this.name);
    }
}
