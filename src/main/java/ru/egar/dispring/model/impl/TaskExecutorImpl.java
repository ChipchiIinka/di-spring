package ru.egar.dispring.model.impl;

import org.springframework.stereotype.Component;
import ru.egar.dispring.model.Task;
import ru.egar.dispring.model.TaskExecutor;

@Component
public class TaskExecutorImpl implements TaskExecutor {

    @Override
    public String execute(Task task) {
        System.out.printf("Get task: %s, details: %s\n", task.getText(), task.getComment());

        // Some logic

        return String.format("Success execute task \"%s\"", task.getText());
    }
}
