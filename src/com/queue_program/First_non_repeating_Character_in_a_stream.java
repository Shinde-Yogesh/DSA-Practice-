package com.queue_program;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class First_non_repeating_Character_in_a_stream {
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

	public static void main(String[] args) {
		String str = "aabc";
		System.out.println(FirstNonRepeating(str));
	}
}
