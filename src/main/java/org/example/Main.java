package org.example;

import org.example.service.Filter;
import org.example.service.Logger;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("запуск");
        logger.log("приветствие");
        System.out.println("Hey, mate!");
        logger.log("инициализация переменных");
        boolean flag = true;
        int n = 0, m = 0, f = 0;
        logger.log("запуск диалога с пользователем");

        while (flag) {
            logger.log("ввод N");
            System.out.println("Введи размер списка N->");

            try {
                n = Integer.parseInt(scanner.nextLine());
                logger.log("ввод M");
                System.out.println("Введи верхнюю границу списка М->");
                m = Integer.parseInt(scanner.nextLine());

                if (n < 1 || m < 1) {
                    logger.log("ошибка ввода");
                    System.out.println("Некорректные входные данные, N и M д.б. > 1");
                    continue;
                }
                logger.log("ввод F");
                System.out.println("Введи порог для фильтра F->");
                f = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                logger.log("ошибка ввода");
                System.out.println("Введи число больше 0!");
            }
        }
        logger.log("создание списка");
        List<Integer> checkList = createList(n, m);
        logger.log("печать списка");
        System.out.println(checkList);
        logger.log("создание фильтра");
        Filter filter = new Filter(f);
        logger.log("запуск фильтрации");
        List<Integer> listResult = filter.filterOut(checkList);
        logger.log("прошло фильтр " + listResult.size() + " из " + n);
        logger.log("печать итогов");
        System.out.println(listResult);
        scanner.close();
        logger.log("завершение программы");
    }

    public static List<Integer> createList(int n, int m) {
        Logger logger = Logger.getInstance();
        return IntStream.range(0, n)
                .peek(x -> logger.log("добавление " + (x + 1) + "-го элемента в список"))
                .mapToObj(x -> random.nextInt(m))
                .collect(Collectors.toList());
    }
}