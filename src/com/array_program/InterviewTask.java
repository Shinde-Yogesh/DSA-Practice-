package com.array_program;

import java.util.ArrayList;

public class InterviewTask {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(-5);
		list.add(18);
		list.add(0);
		list.add(-3);
		list.add(7);
		
//		System.out.println(list);
//		
//		System.out.println(negativeNumber(list));
//		System.out.println(sum(list));
		
		String value = "lazy123";
		sortAlphabeticaly(value);
	}
	
	public static ArrayList<Integer> negativeNumber(ArrayList<Integer> list)
	{
//		list.stream().filter(x -> x > 0 ? : );
		
		ArrayList<Integer> positive = new ArrayList<>();
		for(Integer value : list)
		{
			if(value > 0)
			{
				positive.add(value);
			}
		}
		return positive;
	}
	
	public static int sum (ArrayList<Integer> list)
	{
//		list.stream().filter(x -> x > 0 ? : );
		
		int sum = 0;
		for(Integer value : list)
		{
			if(value > 0)
			{
				sum += value;
			}
		}
		return sum;
	}
	
	
	public static void separateDigitAndLetters(String str)
	{
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i) > 65)
			{
				
			}
		}
		
	}
	
	public static void sortAlphabeticaly(String str)
	{
		char result[] = str.toCharArray();
		System.out.println(result);
	}
	
}
