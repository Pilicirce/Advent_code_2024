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
            //char[][] matrix = readFileAsMatrix(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
        

            // 1.1) declare variables
            String linea;
            int totalX_MASCount = 0;

             // Read the matrix from the file
             List<String> lines = new ArrayList<>();
             while ((linea = reader.readLine()) != null) {
                 lines.add(linea);
             }
             reader.close();
 
             char[][] matrix = new char[lines.size()][lines.get(0).length()];
             for (int i = 0; i < lines.size(); i++) {
                 matrix[i] = lines.get(i).toCharArray();
             }

              // Iterate through the matrix to find "X-MAS" patterns
            for (int x = 1; x < matrix.length - 1; x++) {
                for (int y = 1; y < matrix[0].length - 1; y++) {
                    if (matrix[x][y] == 'A') { // Solo evaluar si encontramos una 'A'
                        System.out.println("Encontrada 'A' en: (" + x + ", " + y + ")");

                        int countMAS = 0;

                        // 3) Comprobaciones en las 4 direcciones diagonales
                        boolean check1 = checkDirection(matrix, x, y, -1, -1, 1, 1); // ↖ y ↘
                        boolean check2 = checkDirection(matrix, x, y, -1, 1, 1, -1); // ↗ y ↙
                        boolean check3 = checkDirection(matrix, x, y, 1, -1, -1, 1); // ↙ y ↗
                        boolean check4 = checkDirection(matrix, x, y, 1, 1, -1, -1); // ↘ y ↖

                        // Imprimir el resultado de cada verificación
                        System.out.println("↖ y ↘ : " + check1);
                        System.out.println("↗ y ↙ : " + check2);
                        System.out.println("↙ y ↗ : " + check3);
                        System.out.println("↘ y ↖ : " + check4);

                        if (check1) countMAS++;
                        if (check2) countMAS++;
                        if (check3) countMAS++;
                        if (check4) countMAS++;

                        // 4) Si al menos dos direcciones formaron "MAS", contamos un "X-MAS"
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
            return (matrix[x + dx1][y + dy1] == 'M' && matrix[x + dx1 * 2][y + dy1 * 2] == 'S' &&
                    matrix[x + dx2][y + dy2] == 'M' && matrix[x + dx2 * 2][y + dy2 * 2] == 'S');
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}

    //         //2) Recorrer la matriz, evitando los bordes
    //         for (int x = 1; x < matrix.length - 1; x++) {
    //             for (int y = 1; y < matrix[0].length - 1; y++) {
    //                 if (matrix[x][y] == 'A') { // Solo evaluar si encontramos una 'A'
    //                 System.out.println("Encontrada 'A' en: (" + x + ", " + y + ")");

    //                     int countMAS = 0;

    //                     //3) Comprobaciones en las 4 direcciones diagonales
    //                     boolean check1 = checkDirection(matrix, x, y, -1, -1, 1, 1); // ↖ y ↘
    //                     boolean check2 = checkDirection(matrix, x, y, -1, 1, 1, -1); // ↗ y ↙
    //                     boolean check3 = checkDirection(matrix, x, y, 1, -1, -1, 1); // ↙ y ↗
    //                     boolean check4 = checkDirection(matrix, x, y, 1, 1, -1, -1); // ↘ y ↖

    //                     // Imprimir el resultado de cada verificación
    //                     System.out.println("↖ y ↘ : " + check1);
    //                     System.out.println("↗ y ↙ : " + check2);
    //                     System.out.println("↙ y ↗ : " + check3);
    //                     System.out.println("↘ y ↖ : " + check4);
                        
    //                     if (check1) countMAS++;
    //                     if (check2) countMAS++;
    //                     if (check3) countMAS++;
    //                     if (check4) countMAS++;

    //                     //4) Si al menos dos direcciones formaron "MAS", contamos un "X-MAS"
    //                     if (countMAS >= 2) {
    //                         totalX_MASCount++;
    //                         System.out.println("X-MAS encontrado en (" + x + ", " + y + ")! Total: " + totalX_MASCount);
    //                     }
    //                 }
    //             }
    //         }

    //         //5) Imprimir el resultado final
    //         System.out.println("Total X-MAS Count: " + totalX_MASCount);

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // //1.1) Método para leer el archivo y convertirlo en una matriz de caracteres
    // public static char[][] readFileAsMatrix(String filePath) throws IOException {
    //     BufferedReader reader = new BufferedReader(new FileReader(filePath));
    //     java.util.List<char[]> rows = new java.util.ArrayList<>();
    //     String line;

    //     while ((line = reader.readLine()) != null) {
    //         rows.add(line.toCharArray());
    //     }
    //     reader.close();

    //     return rows.toArray(new char[0][]);
    // }

    // /**
    //  * 3.1) Verifica si hay una "MAS" en dos direcciones diagonales opuestas.
    //  * 
    //  * @param matrix La matriz con la sopa de letras
    //  * @param x      Coordenada fila de la 'A'
    //  * @param y      Coordenada columna de la 'A'
    //  * @param dx1    Dirección x de la primera "MAS"
    //  * @param dy1    Dirección y de la primera "MAS"
    //  * @param dx2    Dirección x de la segunda "MAS"
    //  * @param dy2    Dirección y de la segunda "MAS"
    //  * @return `true` si ambas direcciones contienen "MAS", `false` en caso contrario
    //  */
    // public static boolean checkDirection(char[][] matrix, int x, int y, int dx1, int dy1, int dx2, int dy2) {
    //     return isMAS(matrix, x + dx1, y + dy1, dx1, dy1) && isMAS(matrix, x + dx2, y + dy2, dx2, dy2);
    // }

    // /**
    //  *3.2) Verifica si hay una palabra "MAS" en una dirección específica desde un punto dado.
    //  * 
    //  * @param matrix La matriz con la sopa de letras
    //  * @param x      Coordenada fila inicial
    //  * @param y      Coordenada columna inicial
    //  * @param dx     Dirección x
    //  * @param dy     Dirección y
    //  * @return `true` si hay una "MAS", `false` en caso contrario
    //  */
    // public static boolean isMAS(char[][] matrix, int x, int y, int dx, int dy) {
    //     int x1 = x, y1 = y; // Primera letra (M)
    //     int x2 = x + dx, y2 = y + dy; // Segunda letra (A)
    //     int x3 = x + 2 * dx, y3 = y + 2 * dy; // Tercera letra (S)

    //     // Verificar que los índices estén dentro de los límites
    //     if (!isInside(matrix, x1, y1) || !isInside(matrix, x2, y2) || !isInside(matrix, x3, y3)) {
    //         return false;
    //     }

    //     // Comprobar que la secuencia es "MAS"
    //     return matrix[x1][y1] == 'M' && matrix[x2][y2] == 'A' && matrix[x3][y3] == 'S';
    // }

    // //3.3)  Método auxiliar para verificar si un punto está dentro de la matriz
    // public static boolean isInside(char[][] matrix, int x, int y) {
    //     return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    // }
//}