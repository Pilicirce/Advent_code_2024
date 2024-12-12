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

        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\Advent_code_2024\\inputDia2_2024_ejemplo.txt";

        try {
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        //2) declare variables
        String report;
        Integer totalSafeReports = 0;
        List<Integer> levelsReport = new ArrayList<>();
        
        //3) Iterate over each line of the file and split the line into parts (levels separados por espacios)
                
            while ((report = reader.readLine()) != null) {
                // Divide la línea en diferentes números (levels) usando split con un espacio y lo almacena en un array
                String[] parts = report.trim().split(" ");
               
                for (String part : parts) {
                    levelsReport.add(Integer.parseInt(part));
                }
                
            //     // Comparar los levels de cada report: es safe si se cumplen estas dos condiciones: 
            //     // -The levels are either all increasing or all decreasing.
            //     // -Any two adjacent levels differ by at least one and at most three.
            //     boolean isSafe = true;
            //     for (int i = 0; i < levelsReport.size() - 1; i++) {
            //         int diff = levelsReport.get(i) - levelsReport.get(i + 1);
            //         if (diff >= 1 || diff <= 3) {
            //             isSafe = true;
            //             totalSafeReports++;
            //             break;
            //         }
            //     }
                
            //     if (isSafe) {
            //         System.out.println("El report " + levelsReport + " es safe");
            //         totalSafeReports++;
            //     } else {
            //         System.out.println("El report " + levelsReport+ " NO es safe");
            //     }
            // }

        //4) Comparar los levels de cada report: es safe si se cumplen estas dos condiciones: 
        //-The levels are either all increasing or all decreasing.
        //-Any two adjacent levels differ by at least one and at most three.
        for (int i = 0; i < levelsReport.size() - 1; i++) {
            if (levelsReport.get(i) - levelsReport.get(i + 1) >= 1 && levelsReport.get(i) - levelsReport.get(i + 1) <= 3) {

                //5) Contar los reports que son safe (y añadirla a una variable sumatoria)
                // totalSafeReports++;
                System.out.println("El report " + levelsReport + "es safe : " + totalSafeReports);
                totalSafeReports = totalSafeReports + 1;

            } else {
                System.out.println("El report " + levelsReport + " NO es safe");
            }
        }

        //6) Close the file
        reader.close();

        //7) Show the result
        System.out.println("Número total de reports que son safe: " + totalSafeReports);

    }
    } catch (IOException e) {
         e.printStackTrace();
    }

    }
}
