package com.adventcode2024.day1;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Day1_Part2 {

    public static void main(String[] args) {

        solveDay1Part2();

    }

    public static void solveDay1Part2()  {

        System.out.println("SOLVING EXERCISE DAY 1, PART 2 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1_2024.txt";

            // 1) declarar variables (y llamo al método que carga las listas del Day1_Part1)
            List<List<Integer>> lists = Day1_Part1.loadListsFromFileDay1(filePath);
            List<Integer> leftList = lists.get(0);
            List<Integer> rightList = lists.get(1);

             // 2) Crear un HashMap para contar las ocurrencias de cada número en la lista derecha
            // HashMap<Integer, Integer> rightCounts = new HashMap<>();
            // for (int number : rightList) {
            //     rightCounts.put(number, rightCounts.getOrDefault(number, 0) + 1);
            // }

            //pero uso un Map en lugar de un HashMap por tener más flexibilidad (y sigue siendo eficiente). 
            //Ademas, el HasMap no garantiza ningnun orden
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : rightList) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            // 3.a) Calcular el "similarity score"
            int similarityScore = 0;
            // for (int number : leftList) {
            //     int countInRight = rightCounts.getOrDefault(number, 0); // Obtener cuántas veces aparece en la derecha
            //     similarityScore += number * countInRight; // Multiplica el número por su ocurrencia y suma al total
            // }
            for (int num : leftList) {
                int count = frequencyMap.getOrDefault(num, 0); // Veces que aparece el número en la derecha

                 //3.b) sumar los valores de cada número multiplicado por su ocurrencia
                similarityScore += num * count;
            }


            //4) Show the result
                System.out.println("Total score " + similarityScore);
            
            
    throw new UnsupportedOperationException("Unimplemented method 'solveDay1Part2'");
    }
}
