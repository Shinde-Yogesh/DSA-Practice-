package com.recursion_program.easy_Level;

public class Length_of_String {
	public static int calculateLengthRecursive(String str) {
		if(str.equals(""))
		{
			return 0;
		}
		
		return calculateLengthRecursive(str.substring(1))+1;
	}

	public static void main(String[] args) {
		String str = "geeks";
		System.out.println(calculateLengthRecursive(str));
	}
}


/*

						RRT
			
				calculateLengthRecursive("Hello, World!")
				|-- 1 + calculateLengthRecursive("ello, World!")
				|   |-- 1 + calculateLengthRecursive("llo, World!")
				|   |   |-- 1 + calculateLengthRecursive("lo, World!")
				|   |   |   |-- 1 + calculateLengthRecursive("o, World!")
				|   |   |   |   |-- 1 + calculateLengthRecursive(", World!")
				|   |   |   |   |   |-- 1 + calculateLengthRecursive(" World!")
				|   |   |   |   |   |   |-- 1 + calculateLengthRecursive("World!")
				|   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("orld!")
				|   |   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("rld!")
				|   |   |   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("ld!")
				|   |   |   |   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("d!")
				|   |   |   |   |   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("!")
				|   |   |   |   |   |   |   |   |   |   |   |   |-- 1 + calculateLengthRecursive("")
				|   |   |   |   |   |   |   |   |   |   |   |   |   `-- Result: 0
				|   |   |   |   |   |   |   |   |   |   |   |   `-- Result: 1
				|   |   |   |   |   |   |   |   |   |   |   `-- Result: 2
				|   |   |   |   |   |   |   |   |   |   `-- Result: 3
				|   |   |   |   |   |   |   |   |   `-- Result: 4
				|   |   |   |   |   |   |   |   `-- Result: 5
				|   |   |   |   |   |   |   `-- Result: 6
				|   |   |   |   |   |   `-- Result: 7
				|   |   |   |   |   `-- Result: 8
				|   |   |   |   `-- Result: 9
				|   |   |   `-- Result: 10
				|   |   `-- Result: 11
				|   `-- Result: 12
				`-- Result: 13


*/