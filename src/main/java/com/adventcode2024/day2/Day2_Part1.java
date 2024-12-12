package com.adventcode2024.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2_Part1 {

    public static void main(String[] args) {

        solveDay2Part1();

        }

    public static void solveDay2Part1() {

        System.out.println("SOLVING EXERCISE DAY 2, PART 1 : ");

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia2_2024.txt";

        try {
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //2) declare variables
        String report;
        int totalSafeReports = 0;
        
        //3) Iterate over each line of the file and split the line into parts (levels separados por espacios)
                
            while ((report = reader.readLine()) != null) {
                // Divide la línea en diferentes números (levels) usando split con un espacio y lo almacena en un array
                String[] parts = report.trim().split(" ");
                List<Integer> levelsReport = new ArrayList<>();
                for (String part : parts) {
                    levelsReport.add(Integer.parseInt(part));
                }
                

        //4) llamar al método que comprueba si un report es safe (método a parte)
        if (isSafe(levelsReport)) { 
            totalSafeReports++;
            System.out.println("El report " + levelsReport + " es SAFE.");
        } else {
            System.out.println("El report " + levelsReport + " NO es SAFE.");
        }
    }
        //6) Close the file
        reader.close();

        //7) Show the result
        System.out.println("Número total de reports que son safe: " + totalSafeReports);

    } catch (IOException e) {
         e.printStackTrace();
    }

    }

//Method to check if a report is safe. Comparar los levels de cada report: es safe si se cumplen estas dos condiciones: 
        //-The levels are either all increasing or all decreasing.
        //-Any two adjacent levels differ by at least one and at most three.
public static boolean isSafe(List<Integer> levels) {
    boolean isIncreasing = true;
    boolean isDecreasing = true;

    for (int i = 0; i < levels.size() - 1; i++) {
        int diff = levels.get(i + 1) - levels.get(i);

         // Check if difference is within the range [1, 3]
         if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
            return false;
        }

         // Check for increasing and decreasing trends
         if (diff > 0) {
            isDecreasing = false;
        } else if (diff < 0) {
            isIncreasing = false;
        }
    }

    // A report is safe if it's either strictly increasing or strictly decreasing
    return isIncreasing || isDecreasing;

}


}
