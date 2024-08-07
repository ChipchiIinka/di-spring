package ru.egar.dispring.model.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.egar.dispring.model.ReportSender;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultReportSenderTest {

    private ReportSender reportSender;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp(){
        reportSender = new DefaultReportSender();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void setOriginalSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    void sendReportTest(){
        reportSender.sendReport("Test text");
        String output = outContent.toString().trim();
        assertEquals("Task result: Test text", output, "The execute method should return the correct success message in console");
    }
}