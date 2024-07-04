package com.recursion_program;

public class SayDigits {
	public static void sayNumber(int num , String[] array) {
        // Handle negative numbers
        if(num < 0) {
            System.out.print("negative ");
            num = -num;
        }

        // Base case
        if(num == 0) {
            return;
        }

        // Processing part
        int digit = num % 10;
        num = num / 10;

        // Recursive call
        sayNumber(num, array);

        System.out.print(array[digit]+ " ");
    }

    public static void main(String[] args) {
        String array[] = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
        int num = -752;
        sayNumber(num, array);
    }
}

/*
 * 
 * if call the main method then output is System.out.print(array[digit]+ " ");
 * 
 * //Recursive call sayNumber(num, array);
 * 
 * ----------------------------------------------OUTPUT-------------------- zero
 * one /calling the function again and again the base case is satisfied and then
 * print the message output is reverse 
 */