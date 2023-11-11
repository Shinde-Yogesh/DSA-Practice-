package com.string_program;

public class Number_Make_Permitutations_Google_Question {

	public static void main(String[] args) {
		
		permitutaions("", "12");
		
	}
	
	static void permitutaions(String p, String up)
	{
		if(up.isEmpty())
		{
			System.out.println(p);
			return;
		}
		
		int digit  = up.charAt(0) - '0';  //this will convert '2' into 2
		for(int i = (digit - 1) *3; i < digit * 3; i++)
		{
			char ch = (char) ('a' + i);
			permitutaions(p + ch, up.substring(1));
		}
	}
}
