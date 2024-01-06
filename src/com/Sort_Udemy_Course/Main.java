package com.Sort_Udemy_Course;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int array[] = { 4, 2, 6, 5, 1, 3 };
		Sorting_Techniques sort = new Sorting_Techniques();
		sort.bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

}
