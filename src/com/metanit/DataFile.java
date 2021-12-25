package com.metanit;

import java.io.*;
import java.util.*;



public class DataFile {

    public static void writeToFile(int[][] matrix, String file){
        try (PrintWriter writer = new PrintWriter(file,"UTF-8")){
            for(int i = 0; i < matrix.length;i++){
                for(int j = 0; j < matrix[0].length;j++){
                    writer.print((j==0 ?"":" ") + matrix[i][j]);
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.err.println("Ошибка");
        }
    }

    public static int[][] readFile(String file){

        int row = 4;
        int col = 4;

        int[][] matrix = new int[row][col];

        try (Scanner scanner = new Scanner(new File(file))){
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    if (scanner.hasNextInt()) matrix[r][c] = scanner.nextInt();
                }
            }

        } catch (FileNotFoundException e) {
            System.err.print("Error");
        }
        return matrix;
    }

}
