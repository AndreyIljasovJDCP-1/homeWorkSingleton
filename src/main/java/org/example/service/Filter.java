package org.example.service;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final int filter;

    public Filter(int filter) {
        this.filter = filter;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        return source.stream()
                .peek(el -> {
                    if (el >= filter) {
                        logger.log("элемент " + el + " проходит");
                    } else {
                        logger.log("элемент " + el + " не проходит");
                    }
                })
                .filter(el -> el >= filter)
                .collect(Collectors.toList());
    }
}
