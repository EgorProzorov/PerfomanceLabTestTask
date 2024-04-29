package org.example.task4;

import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {

        String filePath = args[0];
//        String filePath = "/Users/egorprozorov/Java/PerfomanceLabTestTask/src/main/java/org/example/task4/numbers.txt";
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    numbers.add(Integer.parseInt(token));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа: " + e.getMessage());
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Файл пуст или не содержит целых чисел.");
            return;
        }

        int minMoves = calculateMinMoves(numbers);
        System.out.println(minMoves);
    }

    private static int calculateMinMoves(List<Integer> numbers) {
        Collections.sort(numbers);
        int median = numbers.get(numbers.size() / 2);
        int moves = 0;
        for (int number : numbers) {
            moves += Math.abs(number - median);
        }
        return moves;
    }
}
