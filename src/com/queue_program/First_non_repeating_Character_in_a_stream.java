package com.queue_program;

import java.util.LinkedList;
import java.util.Queue;

public class First_non_repeating_Character_in_a_stream {

	/*
	public static String FirstNonRepeating(String A) {

		// creating the map
		HashMap<Character, Integer> map = new HashMap<>();
		Queue<Character> queue = new ArrayDeque<>();

		StringBuilder ans = new StringBuilder();
		char StringToChar[] = A.toCharArray();
		for (int i = 0; i < StringToChar.length; i++) {
			// get the first character of the String
			char ch = StringToChar[i];
			map.put(ch, map.getOrDefault(ch, 0) + 1); // in me when want to increase the counter i used map.pu(ch,count++)which not increment the counter 

			// push into the queue
			queue.add(ch);

			while (!queue.isEmpty()) {

				if (map.get(queue.peek()) > 1) {
					// repeating character found
					queue.remove();
				} else {
					ans = ans.append(queue.peek());
					break;
				}
			}
			if (queue.isEmpty()) {
				ans = ans.append('#');
			}
		}
		return ans.toString();
	}
	*/
//			Approach 2 Using the Array
	
	public static String FirstNonRepeating(String s)
    {
        // code here
        StringBuffer str = new StringBuffer();
        
        int[] freq = new int[26];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            freq[(int)ch -97]++;
            
            if(freq[(int)ch - 97]==1) q.add((int)ch - 97);
            
            while(q.size()>0 && freq[q.peek()]>1)
            {
                q.remove();
            }
            
            if(q.size() > 0) str.append((char)(q.peek()+97));
            else str.append('#');
            
        }
        
        return str.toString();
    }

	public static void main(String[] args) {
		String str = "aabc";
		System.out.println(FirstNonRepeating(str));
	}
}
