package com.adventcode2024.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_Part1 {
    public static void main(String[] args) {

        solveDay3Part1();

        }

    public static void solveDay3Part1() {
        System.out.println("SOLVING EXERCISE DAY 3, PART 1 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia3_2024.txt";

        try {
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //2) declare variables
        String linea;
        //este regex captura los números como grupos separados para extraerlos con matcher.group(1) y matcher.group(2).
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)"; 

        //mul\(\d{1,3},\d{1,3}\)
        //mul\((\d{1,3}),(\d{1,3})\)
        // "mul\\(\\d{1,3},\\d{1,3}\\)"

        //para leer el archivo:
        StringBuilder contenido = new StringBuilder();
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea);
        }

        // Ahora tengo todo el texto en una sola variable
        String textoCompleto = contenido.toString();

        //3) Compilar el patron
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textoCompleto);  

        //4) Buscar coincidencias
        while (matcher.find()) {
        String coincidencia = matcher.group(); // Captura la coincidencia completa
        // int x = Integer.parseInt(matcher.group(1)); // Primer número
        // int y = Integer.parseInt(matcher.group(2)); // Segundo número
        // System.out.println("Coincidencia encontrada: " + coincidencia + " -> Números: " + x + ", " + y);

        //5) agregar (x, y) a una lista para procesarlo luego. Almacenar cada par en un array de dos enteros (int[])
            List<int[]> listaNumeros = new ArrayList<>();
             while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                listaNumeros.add(new int[] {x, y}); 
            }
        }

        //6) Recorrer la lista, hacer las multiplicaciones pertinentes y despues sumarlas
        int totalSumPattern = 0;

        //7) Close the file
        reader.close();

        //8) Show the result
        System.out.println("Suma de todos los numeros del patron multiplicados " + totalSumPattern);

    } catch (IOException e) {
        System.err.println("Error leyendo el archivo: " + e.getMessage());
   }
}
}


