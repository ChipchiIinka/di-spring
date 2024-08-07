package ru.egar.dispring.model.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.egar.dispring.dao.TaskRepository;
import ru.egar.dispring.model.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskReceiverImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskReceiverImpl taskReceiver;

    @Test
    void testGetTasks() {
        when(taskRepository.getTasks()).thenReturn(List.of(new Task("Task1", "Comment1"), new Task("Task2", "Comment2")));
        var tasks = taskReceiver.getTasks();
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).getTasks();
    }

    @Test
    void testAddTask() {
        Task task = new Task("New Task", "New Comment");
        taskReceiver.addTask(task.getText(), task.getComment());
        verify(taskRepository, times(1)).addTask(any(Task.class));
    }
}