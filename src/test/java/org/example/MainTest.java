package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("Тест класса Main.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {


    @Order(1)
    @DisplayName("Тест: createList(n, m) возвращает лист ")
    @MethodSource("getArguments")
    @ParameterizedTest(name = "размер n = {0}, значения от 0 до m = {1} exclusive")
    void createList(int n, int m) {

        List<Integer> list = Main.createList(n, m);
        Assertions.assertAll("Проверка созданного листа",
                () -> Assertions.assertEquals(n, list.size()),
                () -> Assertions.assertTrue(Collections.max(list) < m),
                () -> Assertions.assertTrue(Collections.min(list) >= 0)
        );
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(10, 100),
                Arguments.of(100, 1000),
                Arguments.of(1, 1)
        );
    }
}