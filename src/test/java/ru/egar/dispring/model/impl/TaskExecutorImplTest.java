package ru.egar.dispring.model.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.egar.dispring.model.Task;
import ru.egar.dispring.model.TaskExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskExecutorImplTest {

    private TaskExecutor taskExecutor;

    @BeforeEach
    void setUp(){
    taskExecutor = new TaskExecutorImpl();
    }

    @Test
    void testExecute() {
        Task task = new Task("Test Task", "Test Comment");
        String result = taskExecutor.execute(task);
        assertEquals("Success execute task \"Test Task\"", result, "The execute method should return the correct success message.");
    }
}