package lab11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTask {

    private static final int SIZE = 100000;

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }

    private static void testArrayList() {
        List<Integer> list = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.get(i);
        }
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(0, i);
        }
        long insertTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.remove(0);
        }
        long removeTime = System.nanoTime() - start;

        printResults("ArrayList", addTime, searchTime, insertTime, removeTime);
    }

    private static void testLinkedList() {
        List<Integer> list = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.get(i);
        }
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(0, i);
        }
        long insertTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.remove(0);
        }
        long removeTime = System.nanoTime() - start;

        printResults("LinkedList", addTime, searchTime, insertTime, removeTime);
    }

    private static void printResults(String name, long addTime,
                                     long searchTime, long insertTime,
                                     long removeTime) {
        System.out.println("\n" + name + ":");
        System.out.println("Добавление: " + addTime / 1_000_000.0 + " мс");
        System.out.println("Поиск по индексу: " + searchTime / 1_000_000.0 + " мс");
        System.out.println("Вставка в начало: " + insertTime / 1_000_000.0 + " мс");
        System.out.println("Удаление из начала: " + removeTime / 1_000_000.0 + " мс");
    }
}