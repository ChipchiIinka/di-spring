package ru.egar.dispring.dao;


import ru.egar.dispring.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getTasks();
    void addTask(Task task);
}
