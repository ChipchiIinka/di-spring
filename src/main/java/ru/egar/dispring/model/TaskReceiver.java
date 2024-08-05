package ru.egar.dispring.model;

import java.util.stream.Stream;

public interface TaskReceiver {
    Stream<Task> getTasks();
    void addTask(String name, String comment);
}
