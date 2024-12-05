package com.adventcode2024.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1_Part1 {

    public static void main(String[] args) {

        solveDay1Part1();

        }

    public static void solveDay1Part1() {

        System.out.println("SOLVING EXERCISE DAY 1, PART 1 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1_2024.txt";

        try {
            // 1) Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // 2) declare variables
            String linea;
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();

            // 3) Iterate over each line of the file
            while ((linea = reader.readLine()) != null) {
                //Divide la línea en dos números, usando split con tres espacios
                String[] parts = linea.split("   ");
                linea = linea.trim();
                // Añade los números a las listas
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
                }
                reader.close();

                // 4) Ordenar las dos listas
                Collections.sort(leftList);
                Collections.sort(rightList);

                //5) Calcular las "distancias"(diferencias) entre los números ordenados de las dos listas y la distancia total
                int totalDistance = 0;
                for (int i = 0; i < leftList.size(); i++) {
                    totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
                }
          
                // 6) Show the result
                System.out.println("Total distance " + totalDistance);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'solveDay1Part1'");
    }
}

