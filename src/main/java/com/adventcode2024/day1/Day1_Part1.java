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

        // try {
            // // 1) Open the file for reading
            // BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // // 2) declare variables
            // String linea;
            // List<Integer> leftList = new ArrayList<>();
            // List<Integer> rightList = new ArrayList<>();

            // // 3) Iterate over each line of the file
            // while ((linea = reader.readLine()) != null) {
            //     //Divide la línea en dos números, usando split con tres espacios
            //     String[] parts = linea.split("   ");
            //     linea = linea.trim();
            //     // Añade los números a las listas
            //     leftList.add(Integer.parseInt(parts[0]));
            //     rightList.add(Integer.parseInt(parts[1]));
            //     }
            //     reader.close();

            //todo el paso 1, 2 y 3 de antes lo sustituyo ahora por un nuevo método para cargar las listas:
            List<List<Integer>> lists = loadListsFromFileDay1(filePath);
            List<Integer> leftList = lists.get(0);
            List<Integer> rightList = lists.get(1);


                // 4) Ordenar las dos listas
                Collections.sort(leftList);
                Collections.sort(rightList);

                //5) Calcular las "distancias"(diferencias) entre los números ordenados de las dos listas y los va sumando a la variable con el total
                int totalDistance = 0;
                for (int i = 0; i < leftList.size(); i++) {
                    totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
                }
          
                // 6) Show the result
                System.out.println("Total distance " + totalDistance);
            

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

    }

 /**
     * Método para cargar las listas izquierda y derecha desde un archivo.
     * @param filePath Ruta del archivo que contiene los datos.
     * @return Una lista de listas: la primera contiene los números de la izquierda,
     *         la segunda los de la derecha.
     */
    public static List<List<Integer>> loadListsFromFileDay1(String filePath) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Divide la línea en dos números usando split con tres espacios
                String[] parts = linea.trim().split("   ");
                leftList.add(Integer.parseInt(parts[0]));
                rightList.add(Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Devuelve las listas como una lista de listas
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(leftList);
        lists.add(rightList);
        return lists;
    }

}

