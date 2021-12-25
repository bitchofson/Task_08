package com.metanit;


/*
18. Будем называть соседями элемента с индексами (r, c) в двумерном массиве такие элементы, индексы которых отличатся от (r, c) не более чем на единицу.
Для  переданного двумерного массива составить новый двумерный массив, где каждый элемент (r, c) нового массива будет содержать число соседей элемента (r, c)
в переданном массиве, равных элементу (r, c) (в переданном массиве).
 */

import java.util.Arrays;

public class Logic {

    int row;
    int col;
    int[][] dataArr;

    Logic(int[][] dataArr, int row, int col) {
        this.dataArr = dataArr;
        this.col = col;
        this.row = row;
    }

    public int[][] findingNeighbors() {

        int[][] tempArr = new int[row][col];

        for (int[] ints : tempArr) {
            Arrays.fill(ints, 0);
        }

        for (int r = 0; r < dataArr.length; r++) {
            for (int c = 0; c < dataArr[r].length; c++) {

                if (isValid(r, c-1))
                    if (dataArr[r][c] == dataArr[r][c-1]) tempArr[r][c]++;

                if (isValid(r-1, c-1))
                    if (dataArr[r][c] == dataArr[r-1][c-1]) tempArr[r][c]++;

                if (isValid(r-1, c))
                    if (dataArr[r][c] == dataArr[r-1][c]) tempArr[r][c]++;

                if (isValid(r-1, c+1))
                    if (dataArr[r][c] == dataArr[r-1][c+1]) tempArr[r][c]++;

                if (isValid(r, c+1))
                    if (dataArr[r][c] == dataArr[r][c+1]) tempArr[r][c]++;

                if (isValid(r+1, c+1))
                    if (dataArr[r][c] == dataArr[r+1][c+1]) tempArr[r][c]++;

                if (isValid(r+1, c))
                    if (dataArr[r][c] == dataArr[r+1][c]) tempArr[r][c]++;

                if (isValid(r+1, c-1))
                    if (dataArr[r][c] == dataArr[r+1][c-1]) tempArr[r][c]++;

            }

        }

        return tempArr;
    }

    public boolean isValid(int r, int c) {
        return (r >= 0 && c >= 0) && (r < row && c < col);
    }

}
