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

        // return matrix;
        return rows.toArray(new char[0][]);
    }


    /**
     *  2) Método para verificar si hay un "X-MAS" centrado en (x, y)
     */
    public static boolean isXMAS(char[][] matrix, int x, int y) {
        if (matrix[x][y] != 'A') {
            return false; // El centro debe ser 'A'
        }

        // Verificamos ambas diagonales
    boolean diagonal1 = isMASInDirection(matrix, x, y, -1, -1) && isMASInDirection(matrix, x, y, 1, 1);
    boolean diagonal2 = isMASInDirection(matrix, x, y, -1, 1) && isMASInDirection(matrix, x, y, 1, -1);

    return diagonal1 || diagonal2;
}

       
    public static boolean checkDiagonal(char[][] matrix, int x, int y, int dx1, int dy1, int dx2, int dy2) {
        // Verificar "MAS" en una dirección
        boolean part1 = isMAS(matrix, x + dx1, y + dy1, dx1, dy1);
        boolean part2 = isMAS(matrix, x + dx2, y + dy2, dx2, dy2);

        return part1 && part2;
    }


    public static boolean isMAS(char[][] matrix, int x, int y, int dx, int dy) {
        String word = "MAS";

        for (int i = 0; i < word.length(); i++) {
            int nx = x + i * dx;
            int ny = y + i * dy;

            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || matrix[nx][ny] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
        
   
 /**
     * 3.1) 3.2) Verifica si "XMAS" está presente en una dirección específica desde un punto dado en la matriz.
     */
    public static boolean isMASInDirection(char[][] matrix, int x, int y, int dx, int dy) {
        // Verificamos si la dirección forma "MAS"
        if (!isInside(matrix, x + dx, y + dy) || matrix[x + dx][y + dy] != 'M') return false;
        if (!isInside(matrix, x + 2*dx, y + 2*dy) || matrix[x + 2*dx][y + 2*dy] != 'A') return false;
        if (!isInside(matrix, x + 3*dx, y + 3*dy) || matrix[x + 3*dx][y + 3*dy] != 'S') return false;
        
        return true;
    }

    // Función auxiliar para verificar límites de la matriz
    public static boolean isInside(char[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    
    
}
