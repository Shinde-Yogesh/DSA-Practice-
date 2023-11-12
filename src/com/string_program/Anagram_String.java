package com.string_program;

import java.util.Arrays;

public class Anagram_String {

	   static boolean areAnagram(String value, String sample)
	    {
		   
		   char[] str1 = value.toCharArray();
		   char[] str2 = sample.toCharArray();
	        // Get lengths of both strings
	        int n1 = str1.length;
	        int n2 = str2.length;
	 
	        // If length of both strings is not same,
	        // then they cannot be anagram
	        if (n1 != n2)
	            return false;
	 
	        // Sort both strings
	        Arrays.sort(str1);
	        Arrays.sort(str2);
	 
	        // Compare sorted strings
	        for (int i = 0; i < n1; i++)
	            if (str1[i] != str2[i])
	                return false;
	 
	        return true;
	    }
	   public static void main(String[] args) {
		String abc = "madam";
		String value = "madam";
		System.out.println(areAnagram(abc,value));
	}
}
