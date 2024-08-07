package ru.egar.dispring.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.egar.dispring.dao.TaskRepository;
import ru.egar.dispring.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepositoryImplTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new TaskRepositoryImpl();
    }

    @Test
    void repositoryTest() {
        taskRepository.addTask(new Task("Task1", "Comment1"));
        taskRepository.addTask(new Task("Task2", "Comment2"));
        assertEquals(2, taskRepository.getTasks().size(), "Task repo should have 2 tasks now");
    }
}