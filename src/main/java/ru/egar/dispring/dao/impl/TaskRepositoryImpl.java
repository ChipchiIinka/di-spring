package ru.egar.dispring.dao.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.egar.dispring.dao.TaskRepository;
import ru.egar.dispring.model.Task;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepositoryImpl implements TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    @PostConstruct
    private void init() {
        tasks.add(new Task("Print docs", "Print 10 pages of document"));
        tasks.add(new Task("Calculate expenses", "Calculate monthly expenses"));
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }
}
