package ru.egar.dispring.model.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.egar.dispring.model.Task;
import ru.egar.dispring.model.TaskExecutor;

@Slf4j
@Component
public class TaskExecutorImpl implements TaskExecutor {

    @Override
    public String execute(Task task) {
        log.info("Get task: {}, details: {}", task.getText(), task.getComment());

        // Some logic

        return String.format("Success execute task \"%s\"", task.getText());
    }
}
