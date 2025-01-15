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
         // Leer el archivo completo en una sola línea
         StringBuilder contenido = new StringBuilder();

         String linea;
         while ((linea = reader.readLine()) != null) {
             contenido.append(linea);
         }
         String textoCompleto = contenido.toString();


        //2) declare variables y expresiones regulares
        String regexAll = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";
        // String regexMul = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        // String controlRegex = "do\\(\\)|don't\\(\\)";
        boolean isMulEnabled = true; // Variable para rastrear el estado de habilitación
        int totalSumPattern = 0;

        //3) Compilar patrones
        Pattern pattern = Pattern.compile(regexAll);
        Matcher matcher = pattern.matcher(textoCompleto);


        //4) Buscar coincidencias de control y actualizar el estado
        while (matcher.find()) {
                String match = matcher.group();

                if (match.equals("do()")) {
                    isMulEnabled = true; // Activar multiplicaciones
                } else if (match.equals("don't()")) {
                    isMulEnabled = false; // Desactivar multiplicaciones
                } else {
                    // Procesar mul(x, y) solo si están habilitadas
                    if (isMulEnabled) {
                        Matcher mulMatcher = Pattern.compile("mul\\((\\d+),(\\d+)\\)").matcher(match);
                        if (mulMatcher.find()) {
                            int x = Integer.parseInt(mulMatcher.group(1));
                            int y = Integer.parseInt(mulMatcher.group(2));
                            totalSumPattern += x * y;
                        }
                    }
                }
            }

         // 8) Close the file
         reader.close();

         // 9) Show the result
         System.out.println("Suma de todos los numeros del patron multiplicados " + totalSumPattern);

    } catch (IOException e) {
        System.err.println("Error leyendo el archivo: " + e.getMessage());
   }
    
}
}
