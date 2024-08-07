package ru.egar.dispring.di.aspect;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.egar.dispring.TestConfig;
import ru.egar.dispring.di.annotation.Benchmark;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class BenchmarkAspectTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Autowired
    BenchmarkTestService benchmarkTestService;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void setOriginalSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    void testBenchmarkAspect() {
        benchmarkTestService.benchmarkedMethod();
        // Проверка работы аспекта
        String output = outContent.toString().trim();
        assertTrue(output.contains("[[BENCHMARKED METHOD: benchmarkedMethod"), "Aspect should print benchmark information");
        assertTrue(output.contains("Method execution"), "Aspect should print result of method");
        assertTrue(output.contains("Execution time:"), "Aspect should print execution time");
    }
}

@Component
class BenchmarkTestService {
    @Benchmark
    void benchmarkedMethod(){
        System.out.println("Method execution");
    }
}