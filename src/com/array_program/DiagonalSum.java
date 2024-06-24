package com.array_program;

public class DiagonalSum {

    // Method to calculate the sum of the diagonals of a square matrix
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        // Check if the matrix is empty or not square
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix must be non-empty and square.");
        }

        int n = matrix.length;

        // Iterate through the matrix to calculate the diagonal sums
        for (int i = 0; i < n; i++) {
            // Add the primary diagonal element
            sum += matrix[i][i];
            // Add the secondary diagonal element, avoid double counting the center element in odd-dimension matrix
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print the sum of the diagonals
        System.out.println(diagonalSum(matrix));
    }
}


				///Approach 2
				/*  Code contain O(n^2)
				for(int i = 0; i<matrix.length;i++)
				{
					for(int j=0; j<matrix[0].length;j++)
					{
						if(i == j)
						{
							sum += matrix[i][j];
						}
						else
						{
							if(i+j == matrix.length-1)
							{
								sum += matrix[i][j];
							}
						}
					}
				}*/