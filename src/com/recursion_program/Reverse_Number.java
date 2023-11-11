package com.recursion_program;

public class Reverse_Number {
	public static void reverse(int number) {
		if (number < 10) {
			System.out.println(number);
			return;
		} else {
			System.out.print(number % 10);
			reverse(number / 10);
		}

	}
	public static void main(String args[])
	{
		reverse(135);
	}

}
