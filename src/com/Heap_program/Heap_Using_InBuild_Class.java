package com.Heap_program;

import java.util.PriorityQueue;

public class Heap_Using_InBuild_Class {
	 public static void main(String[] args) {
	        // Creating a min-heap using PriorityQueue
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        // Adding elements to the min-heap
	        minHeap.add(10);
	        minHeap.add(20);
	        minHeap.add(15);
	        minHeap.add(5);
	        minHeap.add(30);

	        // Printing elements of the min-heap
	        System.out.println("Min-Heap elements:");
	        while (!minHeap.isEmpty()) {
	            System.out.print(minHeap.poll()+ " ");
	        }
	    }
}
