package com.queue_program;

import java.util.ArrayDeque;
import java.util.Deque;

public class Double_Ended_Queue {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(10);
		deque.addFirst(15);
		deque.addLast(20);
		System.out.println(deque);
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
	
	}

}
