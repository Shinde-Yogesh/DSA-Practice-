package com.Heap_program;

import java.util.Collections;
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
	        
	        System.out.println();
	        
	        // Creating a max-heap using PriorityQueue with a custom comparator
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	        // Adding elements to the max-heap
	        maxHeap.add(10);
	        maxHeap.add(20);
	        maxHeap.add(15);
	        maxHeap.add(5);
	        maxHeap.add(30);

	        // Printing elements of the max-heap
	        System.out.println("Max-Heap elements:");
	        while (!maxHeap.isEmpty()) {
	            System.out.print(maxHeap.poll()+ " ");
	        }
	    }
}