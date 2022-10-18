package org.example.service;

import org.junit.jupiter.api.*;

@DisplayName("Тест класса Logger.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoggerTest {
    private static final Logger logger = Logger.getInstance();

    @Order(1)
    @RepeatedTest(3)
    @DisplayName("Тест: getInstance() возвращает один и тот же объект logger.")
    void getInstanceReturnSameLogger() {
        Assertions.assertEquals(logger, Logger.getInstance());
    }
}