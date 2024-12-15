package com.adventcode2024.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2_Part2 {
    
    public static void main(String[] args) {

        solveDay2Part2();

        }

    public static void solveDay2Part2() {
        System.out.println("SOLVING EXERCISE DAY 2, PART 2 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia2_2024.txt";

        try {
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //2) declare variables
        String report;
        int safeReportsWithoutTolerance = 0;
        int safeReportsWithTolerance = 0;
        List<List<Integer>> unsafeReports = new ArrayList<>(); // Lista para reportes inseguros
        
        //3) Iterate over each line of the file and split the line into parts (levels separados por espacios)
                
            while ((report = reader.readLine()) != null) {
                // Divide la línea en diferentes números (levels) usando split con un espacio y lo almacena en un array
                String[] parts = report.trim().split(" ");
                List<Integer> levelsReport = new ArrayList<>();
                for (String part : parts) {
                    levelsReport.add(Integer.parseInt(part));
                }
                

        //4) llamar al método que comprueba si un report es safe, primero SIN tolerancias
        if (isSafeWithoutTolerance(levelsReport)) { 
            safeReportsWithoutTolerance++;
            // System.out.println("El report " + levelsReport + " es SAFE.");
        } else {
            // System.out.println("El report " + levelsReport + " NO es SAFE.");
            // Si no es seguro, agregarlo a la lista de inseguros
            unsafeReports.add(levelsReport);
        }
    }

    // 5) Procesar reportes inseguros (lista quitando los seguros que ya están contados). Esta vez CON tolerancia
    for (List<Integer> levels : unsafeReports) {
        if (isSafeWithTolerances(levels)) {
            safeReportsWithTolerance++;
        }
    }
        //6) Close the file
        reader.close();

        //7) Calcular el total y Show the result
        int totalSafeReports = safeReportsWithoutTolerance + safeReportsWithTolerance;
            System.out.println("Número total de reports que son safe: " + totalSafeReports);
        

    } catch (IOException e) {
         e.printStackTrace();
    }

    }




    //Method to check if a report is safe. Comparar los levels de cada report: es safe si se cumplen estas dos condiciones: 
        //-The levels are either all increasing or all decreasing.
        //-Any two adjacent levels differ by at least one and at most three.
        private static boolean isSafeWithoutTolerance(List<Integer> levels) {
            boolean isIncreasing = true;
            boolean isDecreasing = true;
    
            for (int i = 0; i < levels.size() - 1; i++) {
                int diff = levels.get(i + 1) - levels.get(i);
    
                if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                    return false;
                }
    
                if (diff > 0) {
                    isDecreasing = false;
                } else if (diff < 0) {
                    isIncreasing = false;
                }
            }
    
            return isIncreasing || isDecreasing;
        }
    


//método para verificar si un report es seguro CON tolerancias

private static boolean isSafeWithTolerances(List<Integer> levels) {
    // Intentar eliminar cada nivel y verificar si el resto es seguro
    for (int i = 0; i < levels.size(); i++) {
        List<Integer> modifiedLevels = new ArrayList<>(levels);
        modifiedLevels.remove(i);

        //llamamos de nuevo al método "estrella" de isSafeWithoutTolerance, pero ya hemos quitado un level
        if (isSafeWithoutTolerance(modifiedLevels)) { 
            return true;
        }
    }
    return false; // Ninguna eliminación hace que el reporte sea seguro
}
}

