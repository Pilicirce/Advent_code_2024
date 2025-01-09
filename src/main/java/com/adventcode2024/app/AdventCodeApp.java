package com.adventcode2024.app;

import com.adventcode2024.day1.Day1_Part1;
import com.adventcode2024.day1.Day1_Part2;
import com.adventcode2024.day2.Day2_Part1;
import com.adventcode2024.day2.Day2_Part2;
import com.adventcode2024.day3.Day3_Part1;

public class AdventCodeApp {

    // this is the main class of the project. It indicates which Day and Part of the Adven Code must run
    public static void main(String[] args) {

        // Aquí llamo a los métodos de mis ejercicios según sea necesario
        Day1_Part1.solveDay1Part1();
        Day1_Part2.solveDay1Part2();
        Day2_Part1.solveDay2Part1();
        Day2_Part2.solveDay2Part2();
        Day3_Part1.solveDay3Part1();
   
    }
}