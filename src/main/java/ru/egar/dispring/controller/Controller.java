package ru.egar.dispring.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.egar.dispring.model.RobotClerk;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final RobotClerk robotClerk;

    @PostConstruct
    public void doWork() {
        robotClerk.doWork();
    }
}
