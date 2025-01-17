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
        //1) Open the file for reading
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
