package edu.syr.hw2;

public class MultiDimArray {
    public static void main(String[] args) {
        int[][][] matrix1 = new int[3][4][5];
        int[][][] matrix2 = new int[3][4][5];

        // Start the timer
        long startTime = System.nanoTime();

        // linear write test
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    matrix1[i][j][k] = i + j + k;
                    matrix2[i][j][k] = i * j * k;
                }
            }
        }

        // variables to read data
        int x ;
        int y ;

        // linear read test
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    x = matrix1[i][j][k] = i + j + k;
                    y = matrix2[i][j][k] = i * j * k;
                }
            }
        }

        // Perform 10 multiplications using two arrays
        for (int count = 0; count < 10; count++) {
            int result = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 5; k++) {
                        result += matrix1[i][j][k] * matrix2[i][j][k]; // Multiplication operation
                    }
                }
            }
        }

        // Stop the timer
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken for 10 multiplications, linear read, and linear write for multi dimensional array: " + elapsedTime + " nanoseconds.");
    }
}
