package com.adventcode2024.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4_Part1 {
    
    public static void main(String[] args) {

        solveDay4Part1();

        }

    public static void solveDay4Part1() {

        System.out.println("SOLVING EXERCISE DAY 4, PART 1 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia4_2024.txt";

        try {
        //1) Open the file for reading (y almacenar la sopa de letras como la matriz). En un método a parte
        //llamamos a la funcion para leer el archivo y obtener la matriz
        char[][] matrix = readFileAsMatrix(filePath);

         // Imprimimos la matriz para verificar que se leyó correctamente (pero esto es temporal, no hace falta luego)
        //  for (char[] row : matrix) {
        //     System.out.println(new String(row)); // Convertimos la fila a String para imprimirla
        // }


        //2) Definir las direcciones de búsqueda.
        int[][] directions = {
            {0, 1},   // Derecha
            {0, -1},  // Izquierda
            {1, 0},   // Abajo
            {-1, 0},  // Arriba
            {1, 1},   // Diagonal ↘
            {-1, -1}, // Diagonal ↖
            {1, -1},  // Diagonal ↙
            {-1, 1}   // Diagonal ↗
        };

        //3) Escribir una función para contar "XMAS" en una dirección específica. (a parte)    


        //4) Iterar sobre toda la matriz para cada dirección.
        int totalXMASCount = 0;

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                for (int[] direction : directions) {
                    int dx = direction[0];
                    int dy = direction[1];
                    if (isXMASInDirection(matrix, x, y, dx, dy)) {
                        totalXMASCount++;
                    }
                }
            }
        }

        //5) 5) Imprimir el resultado
    System.out.println("Total XMAS Count: " + totalXMASCount);

    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 3) Verifica si "XMAS" está presente en una dirección específica desde un punto dado en la matriz.
     */
    public static boolean isXMASInDirection(char[][] matrix, int x, int y, int dx, int dy) {
        String word = "XMAS";

        // 3.1) Verificar si hay suficiente espacio para formar la palabra
        if (x + (word.length() - 1) * dx < 0 || x + (word.length() - 1) * dx >= matrix.length ||
            y + (word.length() - 1) * dy < 0 || y + (word.length() - 1) * dy >= matrix[0].length) {
            return false; // No hay espacio suficiente
        }

        // 3.2) Comprobar si las siguientes letras forman "XMAS"
        for (int j = 0; j < word.length(); j++) {
            if (matrix[x + j * dx][y + j * dy] != word.charAt(j)) {
                return false; // No coincide
            }
        }
        return true; // Se encontró "XMAS"
    }


    
    /**
     * Lee el archivo y almacena el contenido en una matriz bidimensional de caracteres.
     */
    public static char[][] readFileAsMatrix(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        // Usamos un ArrayList para almacenar temporalmente las filas
        java.util.List<char[]> rows = new java.util.ArrayList<>();
        
        String line;
        while ((line = reader.readLine()) != null) {
            // Convertimos la línea en un arreglo de caracteres y la añadimos a la lista
            rows.add(line.toCharArray());
        }
        reader.close();

        // Convertimos la lista de filas en una matriz bidimensional
        char[][] matrix = new char[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            matrix[i] = rows.get(i);
        }

        return matrix;
    }
}
