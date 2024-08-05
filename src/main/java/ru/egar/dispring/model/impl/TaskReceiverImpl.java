package ru.egar.dispring.model.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.egar.dispring.dao.TaskRepository;
import ru.egar.dispring.di.annotation.Benchmark;
import ru.egar.dispring.model.Task;
import ru.egar.dispring.model.TaskReceiver;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class TaskReceiverImpl implements TaskReceiver {
    private final TaskRepository taskRepository;

    @Override
    @Benchmark
    public Stream<Task> getTasks() {
        return taskRepository.getTasks().stream();
    }

    @Override
    @Benchmark
    public void addTask(String name, String comment) {
        taskRepository.addTask(new Task(name, comment));
    }
}
