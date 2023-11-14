package com.recursion_program.easy_Level;

public class First_UpperCase_Letter_String {
	public static char checkUpper(String str)
	{
		String clone = str;
		clone = clone.toUpperCase();
		
		for(int i = 0; i< str.length(); i++)
		{
			if(str.charAt(i) == clone.charAt(i))
			{
				//System.out.println(str.charAt(i));
				return str.charAt(i);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String str= "geekS";
		System.out.println(checkUpper(str));
	}
}
