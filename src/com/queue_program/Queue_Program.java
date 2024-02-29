package com.queue_program;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Program {
	public static void main(String[] args) {
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.add(10);
	queue.add(40);
	queue.add(50);
	queue.add(60);
	queue.add(60);
	System.out.println(queue);
	}

}
