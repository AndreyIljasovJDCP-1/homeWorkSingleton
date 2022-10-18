package org.example.service;

import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

@DisplayName("Тест класса Logger.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoggerTest {
    private static final Logger logger = Logger.getInstance();

    @Order(1)
    @RepeatedTest(3)
    @DisplayName("Тест: getInstance() возвращает один и тот же объект logger,")
    void getInstanceReturnSameLogger() {
        Assertions.assertEquals(logger, Logger.getInstance());
    }

    @Order(2)
    @RepeatedTest(3)
    @DisplayName("Тест: log() вывод тестового лога на экран, ")
    void log() throws Exception {

        String dateAndTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        String expected = "[" + dateAndTime + " " + logger.getNum() + "] " + "test";
        String actual = tapSystemOut(() -> logger.log("test"));

        Assertions.assertEquals(expected, actual.trim());
    }
}