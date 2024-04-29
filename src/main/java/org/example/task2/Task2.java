package org.example.task2;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        try{
            List<String> circleData = Files.readAllLines(Paths.get(args[0])); // all data from circle.txt

            BigDecimal centerX, centerY, radius;
            BigDecimal x, y;

            String[] centerCoordinates = circleData.get(0).trim().split("\\s+");
            centerX = new BigDecimal(centerCoordinates[0]);
            centerY = new BigDecimal(centerCoordinates[1]);

            radius = new BigDecimal(circleData.get(1).trim());

            List<String> pointsData = Files.readAllLines(Paths.get(args[1])); // all data from dot.txt
            for (String point : pointsData) {
                String[] coordinates = point.trim().split("\\s+");
                x = new BigDecimal(coordinates[0]);
                y = new BigDecimal(coordinates[1]);

                BigDecimal distance = x.subtract(centerX).pow(2)
                        .add(y.subtract(centerY).pow(2))
                        .sqrt(MathContext.DECIMAL128);
                if (distance.compareTo(radius) < 0) {
                    System.out.println("1"); // Точка внутри
                } else if (distance.compareTo(radius) == 0) {
                    System.out.println("0"); // Точка на окружности
                } else {
                    System.out.println("2"); // Точка снаружи
                }
            }
        } catch (IOException e){
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
