package com.string_program;

public class Longest_Palindrom_In_String {
	public static String LongestString(String str)
	{
		//base case length == 1 or > 1 return
		if(str.length() <=1 || str == null)
		{
			return "";
		}
		
		String output = "";
		int maxLength = 0;
		//traversal the loop
		for(int i = 0; i<str.length();i++)
		{
			
			for(int j = i+1;j<=str.length();j++)
			{
				String sample = str.substring(i , j);
				if(isPalindrom(sample) && sample.length()>maxLength) {
					output = sample;
					maxLength = sample.length();
				}
				
			}
		}
		return output;
	}

	private static boolean isPalindrom(String sample) {
		//check for palindrom
		StringBuilder sb = new StringBuilder(sample);
		return sb.reverse().toString().equals(sample);
		
	}

	public static void main(String[] args) {
		String str = "babad";
		System.out.println(LongestString(str));
	}
}
