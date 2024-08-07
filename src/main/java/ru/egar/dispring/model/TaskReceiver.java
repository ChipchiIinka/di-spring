package ru.egar.dispring.model;

import java.util.List;

public interface TaskReceiver {
    List<Task> getTasks();
    void addTask(String name, String comment);
}
