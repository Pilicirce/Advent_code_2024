package com.adventcode2024.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4_Part2 {
    public static void main(String[] args) {

        solveDay4Part2();

        }

    public static void solveDay4Part2() {

        System.out.println("SOLVING EXERCISE DAY 4, PART 2 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia4_2024.txt";

        try {
            //1) Open the file for reading (y almacenar la sopa de letras como la matriz). En un método a parte
            // 1.1) llamamos a la funcion para leer el archivo y obtener la matriz
            char[][] matrix = readFileAsMatrix(filePath);


           //2) Escribir un método que busca ambas diagonales para un "X_MAS" desde un punto (x,y). (a parte)  
           //3) Verifica si "XMAS" está presente en una dirección específica desde un punto dado en la matriz (a parte)


         //4) Iterar sobre toda la matriz evitando los bordes
         int totalX_MASCount = 0;

         for (int x = 1; x < matrix.length - 1; x++) { // Evita los bordes
            for (int y = 1; y < matrix[0].length - 1; y++) { // Evita los bordes
                if (isXMAS(matrix, x, y)) {
                    totalX_MASCount++;
                }
            }
        }
 
         //5) Imprimir el resultado
     System.out.println("Total X-MAS Count: " + totalX_MASCount);


        } catch (IOException e) {
            e.printStackTrace();
        }
}




 /**
     * 1.1) Lee el archivo y almacena el contenido en una matriz bidimensional de caracteres.
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


    /**
     *  2) Método que busca ambas diagonales para un "X_MAS" desde un punto (x,y).
     */
    public static boolean isXMAS(char[][] matrix, int x, int y) {
        
        // Verificar que el punto central es 'A'
         if (matrix[x][y] != 'A') {
            return false;
         }
       
        
        // 3.1) Verificar si las diagonales ↘ y ↖ forman "MAS" (método a parte)
        boolean diagonal1 = isMASInDirection(matrix, x, y, 1, 1) && isMASInDirection(matrix, x, y, -1, -1);
        //3.2)  Verificar si las diagonales ↙ y ↗ forman "MAS"
        boolean diagonal2 = isMASInDirection(matrix, x, y, 1, -1) && isMASInDirection(matrix, x, y, -1, 1);
    
        // El centro de ambas diagonales debe ser 'A'
        return diagonal1 || diagonal2;
    }



 /**
     * 3.1) 3.2) Verifica si "XMAS" está presente en una dirección específica desde un punto dado en la matriz.
     */
    public static boolean isMASInDirection(char[][] matrix, int x, int y, int dx, int dy) {
        String word = "MAS";

        // // Verificar si hay suficiente espacio para formar la palabra
        // if (x + (word.length() - 1) * dx < 0 || x + (word.length() - 1) * dx >= matrix.length ||
        //     y + (word.length() - 1) * dy < 0 || y + (word.length() - 1) * dy >= matrix[0].length) {
        //     return false; // No hay espacio suficiente
        // }

        // // Comprobar si las siguientes letras forman "MAS"
        // for (int j = 0; j < word.length(); j++) {
        //     if (matrix[x + j * dx][y + j * dy] != word.charAt(j)) {
        //         return false; // No coincide
        //     }
        // }
        // return true; // Se encontró "MAS"

        // Verificar si hay espacio suficiente en la dirección dada
        for (int j = 0; j < word.length(); j++) {
            int nx = x + j * dx;
            int ny = y + j * dy;

            // Verificar límites
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length) {
                return false;
            }

            // Comparar caracteres
            if (matrix[nx][ny] != word.charAt(j)) {
                return false;
            }
     }
             return true;

    }
    
}
