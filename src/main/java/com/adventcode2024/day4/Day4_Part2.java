package com.adventcode2024.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4_Part2 {
    public static void main(String[] args) {
        solveDay4Part2();
    }

    public static void solveDay4Part2() {
        System.out.println("SOLVING EXERCISE DAY 4, PART 2:");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia4_2024.txt";

        try {
            //1) Leer el archivo y convertirlo en una matriz de caracteres
            char[][] matrix = readFileAsMatrix(filePath);
        
        // Iterar a través de la matriz para encontrar patrones "X-MAS"
       // Iterar a través de la matriz para encontrar patrones "X-MAS"
       int totalX_MASCount = 0;
       for (int x = 1; x < matrix.length - 1; x++) {
           for (int y = 1; y < matrix[0].length - 1; y++) {
               if (matrix[x][y] == 'A') { // Solo evaluar si encontramos una 'A'
                   int countMAS = 0;

                   // Comprobaciones en las 4 direcciones diagonales
                   boolean check1 = checkDirection(matrix, x, y, -1, -1, 1, 1); // ↖ y ↘
                   boolean check2 = checkDirection(matrix, x, y, -1, 1, 1, -1); // ↗ y ↙
                   boolean check3 = checkDirection(matrix, x, y, 1, -1, -1, 1); // ↙ y ↗
                   boolean check4 = checkDirection(matrix, x, y, 1, 1, -1, -1); // ↘ y ↖

                   if (check1) countMAS++;
                   if (check2) countMAS++;
                   if (check3) countMAS++;
                   if (check4) countMAS++;

                        // Imprimir el resultado de cada verificación
                        // System.out.println("↖ y ↘ : " + check1);
                        // System.out.println("↗ y ↙ : " + check2);
                        // System.out.println("↙ y ↗ : " + check3);
                        // System.out.println("↘ y ↖ : " + check4);


                        // 4)  // Si al menos dos direcciones formaron "MAS", contamos un "X-MAS"
                        if (countMAS >= 2) {
                            totalX_MASCount++;
                            System.out.println("X-MAS encontrado en (" + x + ", " + y + ")! Total: " + totalX_MASCount);
                        }
                    }
                }
            }

            // 5) Imprimir el resultado final
            System.out.println("Total X-MAS Count: " + totalX_MASCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkDirection(char[][] matrix, int x, int y, int dx1, int dy1, int dx2, int dy2) {
        try {
            // Verificar las combinaciones posibles de "MAS" en las direcciones diagonales
            return ((matrix[x + dx1][y + dy1] == 'M' && matrix[x + dx1 * 2][y + dy1 * 2] == 'S' &&
                     matrix[x + dx2][y + dy2] == 'M' && matrix[x + dx2 * 2][y + dy2 * 2] == 'S') ||
                    (matrix[x + dx1][y + dy1] == 'M' && matrix[x + dx1 * 2][y + dy1 * 2] == 'S' &&
                     matrix[x + dx2][y + dy2] == 'S' && matrix[x + dx2 * 2][y + dy2 * 2] == 'M') ||
                    (matrix[x + dx1][y + dy1] == 'S' && matrix[x + dx1 * 2][y + dy1 * 2] == 'M' &&
                     matrix[x + dx2][y + dy2] == 'M' && matrix[x + dx2 * 2][y + dy2 * 2] == 'S') ||
                    (matrix[x + dx1][y + dy1] == 'S' && matrix[x + dx1 * 2][y + dy1 * 2] == 'M' &&
                     matrix[x + dx2][y + dy2] == 'S' && matrix[x + dx2 * 2][y + dy2 * 2] == 'M')
                     );
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

  

    //1.1) Método para leer el archivo y convertirlo en una matriz de caracteres
    public static char[][] readFileAsMatrix(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

         // Usamos un ArrayList para almacenar temporalmente las filas
        List<char[]> rows = new ArrayList<>();

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

