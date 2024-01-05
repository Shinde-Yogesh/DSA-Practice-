package com.Heap_Udemy_Course;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Integer> heap;

	public Heap() {
		this.heap = new ArrayList<>();
	}

	public List<Integer> getHeap() {
		return new ArrayList<>(heap);
	}

	private int leftChild(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return 2 * index + 2;
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	// for swape the value
	private void swap(int index1, int index2) {
		int temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}

	public void insert(int value) {
		heap.add(value);
		int current = heap.size() - 1;

		while (current > 0 && heap.get(current) > heap.get(parent(current))) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	private void sinkDown(int index) {
		int maxIndex = index;
		while (true) {
			int leftIndex = leftChild(index);
			int rightIndex = rightChild(index);

			if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
				maxIndex = leftIndex;
			}
			if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
				maxIndex = rightIndex;
			}

			if (maxIndex != index) {
				swap(index, maxIndex);
				index = maxIndex;
			} else {
				return;
			}
		}
	}

	// for remove the node
	public Integer remove() {
		if (heap.size() == 0) {
			return null;
		}
		if (heap.size() == 1) {
			return heap.remove(0);
		}

		int maxValue = heap.get(0);
		// temp set the last node to top in heap
		heap.set(0, heap.remove(heap.size() - 1));
		// here is operation for for right node the top after the remove method
		sinkDown(0);
		return maxValue;
	}

}
