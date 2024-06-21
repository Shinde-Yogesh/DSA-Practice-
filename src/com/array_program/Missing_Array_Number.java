package com.array_program;

import java.util.Arrays;

public class Missing_Array_Number {
	public static int missingNumber(int array[], int n) {
        int xor = 0;
        int anotherXor = 0;

        // XOR all the numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            anotherXor = anotherXor ^ i;
        }
        System.out.println(anotherXor);
        // XOR all the elements in the array
        for (int i = 0; i < n - 1; i++) {
            xor = xor ^ array[i];
        }
System.out.println(xor);
        // XOR of both will give the missing number
        return (xor ^ anotherXor);
    }

    public static void main(String[] args) {
        int array[] = {6, 1, 2, 8, 3, 4, 7, 10, 5};
        int n = array.length + 1; // n should be the length of array + 1
        System.out.println("Missing number: " + missingNumber(array, n));
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
