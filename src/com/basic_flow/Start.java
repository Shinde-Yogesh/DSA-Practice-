package com.basic_flow;

public class Start {
	
	public static void main(String[] args) {
		System.out.println("************** Do while loop ************");
		
		int i = 0;
		do {
		  System.out.print(" "+i);
		  i++;
		}
		while (i < 5);
		
		System.out.println();
		
		System.out.println("************** for loop ************");
		for (int j = 0; j <= 10; j = j + 2) {
			  System.out.print(j+ " ");
			}
		System.out.println("************** For Each loop ************");
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		for (String k : cars) {
		  System.out.println(k);
		}
		
		System.out.println("************** while loop with continue keyword ************");
		int n = 0;
		while (n < 10) {
		  if (n == 4) {
		    n++;
		    continue;
		  }
		  System.out.println(n);
		  n++;
		}
	}

}
