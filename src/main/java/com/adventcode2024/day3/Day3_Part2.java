package com.adventcode2024.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_Part2 {

    public static void main(String[] args) {

        solveDay3Part2();
        }

    public static void solveDay3Part2() {

        System.out.println("SOLVING EXERCISE DAY 3, PART 2 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia3_2024.txt";

        try {
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //2) declare variables
        String linea;
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        String controlRegex = "do\\(\\)|don't\\(\\)";
        boolean isMulEnabled = true; // Variable para rastrear el estado de habilitación
        int totalSumPattern = 0;

        // 3) Compilar el patrón combinado
        String combinedRegex = regex + "|" + controlRegex;
        Pattern combinedPattern = Pattern.compile(combinedRegex);

        // 4) Leer el archivo línea por línea y procesar instrucciones
        while ((linea = reader.readLine()) != null) {
            Matcher matcher = combinedPattern.matcher(linea);

            while (matcher.find()) {
                String match = matcher.group();
        
                // 5) Procesar instrucciones de control
                if (match.equals("do()")) {
                    isMulEnabled = true;
                } else if (match.equals("don't()")) {
                    isMulEnabled = false;
                }
                
                // 6) Procesar multiplicaciones si están habilitadas
                else if (match.startsWith("mul(")) {
                    if (isMulEnabled) {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        totalSumPattern += x * y;
                    }
                }
            }
        }
                
        // //3)Para leer el archivo
        // StringBuilder contenido = new StringBuilder();
        // while ((linea = reader.readLine()) != null) {
        //     contenido.append(linea);
        // }

        // String textoCompleto = contenido.toString(); // Ahora tengo todo el texto en una sola variable

        // //4) Compilar los patrones (uno para "mul" y otro para "do y don't")
        //  Pattern pattern =  Pattern.compile(regex); //compila la expresion regular (regex) en un patrón
        //  Pattern controlPattern = Pattern.compile(controlRegex);
        //  Matcher matcher = pattern.matcher(textoCompleto);  
        //  Matcher controlMatcher = controlPattern.matcher(textoCompleto);

        // //5) Buscar coincidencias de control y actualizar el estado
        // while (controlMatcher.find()) { 
        //     if (controlMatcher.group().equals("do()")) {
        //         isMulEnabled = true;
        //     } else if (controlMatcher.group().equals("don't()")) {
        //         isMulEnabled = false;
        //     }
        // }

        // // 6) Buscar coincidencias de "mul" y procesarlas si están habilitadas
        // List<int[]> listaNumeros = new ArrayList<>();
        // while (matcher.find()) {
        //     if (isMulEnabled) {
        //         int x = Integer.parseInt(matcher.group(1));
        //         int y = Integer.parseInt(matcher.group(2));
        //         listaNumeros.add(new int[]{x, y});
        //     }
        // }

        // //7) Recorrer la lista, hacer las multiplicaciones pertinentes y después sumarlas
        // int totalSumPattern = 0;
        // for (int[] group1 : listaNumeros) {
        //     int multiplicationResult = 1;
        //     for (int number : group1) {
        //         multiplicationResult *= number;
        //     }
        //     totalSumPattern += multiplicationResult;
        // }

         // 8) Close the file
         reader.close();

         // 9) Show the result
         System.out.println("Suma de todos los numeros del patron multiplicados " + totalSumPattern);

    } catch (IOException e) {
        System.err.println("Error leyendo el archivo: " + e.getMessage());
   }
    
}
}
