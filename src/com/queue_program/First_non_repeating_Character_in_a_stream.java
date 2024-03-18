package com.queue_program;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class First_non_repeating_Character_in_a_stream {
	 public static  String FirstNonRepeating(String A)
	    {
		 
		 //creating the map
		 HashMap <Character,Integer> map = new HashMap<>();
		 Queue<Character> queue =new ArrayDeque<>();
		 
		 String ans = "";
		 char StringToChar[] = A.toCharArray();
		
		for(int i = 0;i< StringToChar.length;i++)
		{
			//get the first character of the String
			char ch = StringToChar[i];
			  map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			//push into the queue
			queue.add(ch);
			
			while(!queue.isEmpty())
			{
				
				if(map.get(queue.peek())>1)
				{
					//repeating character found
					queue.remove();
				}else
				{
					ans = ans + queue.peek();
					break;
				}
			}
			if(queue.isEmpty())
			{
				ans = ans + '#';
			}
		}
			return ans;
	    }
	 public static void main(String[] args) {
		String str =  "aabc";
		System.out.println(FirstNonRepeating(str));
	}
}
