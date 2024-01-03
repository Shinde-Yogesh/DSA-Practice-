package com.Heap_Udemy_Course;

public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(99);
		heap.insert(72);
		heap.insert(61);
		heap.insert(58);

		System.out.println(heap.getHeap());

		heap.insert(100);
		System.out.println(heap.getHeap());
	}
}
