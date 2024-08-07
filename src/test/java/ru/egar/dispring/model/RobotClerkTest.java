package ru.egar.dispring.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import ru.egar.dispring.TestConfig;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class RobotClerkTest {

    @Mock
    private TaskReceiver taskReceiver;

    @Mock
    private TaskExecutor taskExecutor;

    @Mock
    private ReportSender reportSender;

    @InjectMocks
    private RobotClerk robotClerk;

    @BeforeEach
    public void setup() {
        robotClerk.init();
        robotClerk.setRepeat(12);
    }

    @Test
    void testDoWork() {
        // Задание поведения мок-объекта: когда вызывается getTasks, вернуть поток задач
        when(taskReceiver.getTasks()).thenReturn(List.of(new Task("Task1", "Comment1")));
        when(taskExecutor.execute(any(Task.class))).thenReturn("Task executed");

        robotClerk.doWork();

        // Проверка, что метод вызывается один раз с указанными параметрами
        verify(taskReceiver, times(1)).addTask("Drink coffee", "Drank a lot of coffee");
        // Проверка, что методы вызываются столько раз, сколько значение repeat в robotClerk
        verify(taskReceiver, times(robotClerk.getRepeat())).getTasks();
        verify(taskExecutor, times(robotClerk.getRepeat())).execute(any(Task.class));
        verify(reportSender, times(robotClerk.getRepeat())).sendReport(anyString());
    }
}