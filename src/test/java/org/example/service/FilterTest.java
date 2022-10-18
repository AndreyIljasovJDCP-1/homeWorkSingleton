package org.example.service;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@DisplayName("Тест класса Filter.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FilterTest {

    @Test
    @Order(1)
    @DisplayName("Тест: filterOut() возвращает отфильтрованный лист.")
    void filterOut() {
        Filter filter = new Filter(5);
        List<Integer> listCheck = List.of( 5, 5, 7, 10, 12, 13, 13, 14);
        List<Integer> listInput = new ArrayList<>(
                List.of(10, 12, 13, 5, 2, 4, 14, 13, 1, 5, 7)
        );
        List<Integer> listResult = filter.filterOut(listInput);
        listResult.sort(Comparator.naturalOrder());
        Assertions.assertAll("Сравнение листов",
                () -> Assertions.assertEquals(listCheck.size(), listResult.size()),
                () -> Assertions.assertEquals(listCheck, listResult)
        );
    }
}