package edu.syr.hw2;

public class OneDimArray {
    private int[] data;
    private int numRows;
    private int numCols;
    private int numLayers;

    public OneDimArray(int numRows, int numCols, int numLayers) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.numLayers = numLayers;
        data = new int[numRows * numCols * numLayers];
    }

    public int get(int row, int col, int layer) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || layer < 0 || layer >= numLayers) {
            throw new IllegalArgumentException("Invalid indices.");
        }
        int index = row * numCols * numLayers + col * numLayers + layer;
        return data[index];
    }

    public void set(int row, int col, int layer, int value) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || layer < 0 || layer >= numLayers) {
            throw new IllegalArgumentException("Invalid indices.");
        }
        int index = row * numCols * numLayers + col * numLayers + layer;
        data[index] = value;
    }

    public static void main(String[] args) {
        OneDimArray matrix = new OneDimArray(3, 4, 5);

        // Start the timer in nanoseconds
        long startTime = System.nanoTime();

        // Perform 10 multiplications
        for (int count = 0; count < 10; count++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 5; k++) {
                        matrix.set(i, j, k, count * i * j * k); // Linear write operation
                    }
                }
            }
        }

        // Linear read operation
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    result += matrix.get(i, j, k); // Linear read operation
                }
            }
        }

        // Stop the timer in nanoseconds
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken for 10 multiplications, linear read, and linear write for one dimensional : " + elapsedTime + " nanoseconds");
    }
}
