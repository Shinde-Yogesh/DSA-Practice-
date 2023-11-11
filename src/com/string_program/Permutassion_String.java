package com.string_program;

public class Permutassion_String {
	public static void main(String[] args) {
		permutaion("", "abc");
		
	}
	
	public static void permutaion(String p, String up)
	{
		if(up.isEmpty())
		{
			System.out.println(p);
			return;
		}
		
		char c = up.charAt(0);
		
		for(int i = 0; i<= p.length();i++)
		{
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			
			permutaion(f + c + s, up.substring(1));
		}
	}

}
