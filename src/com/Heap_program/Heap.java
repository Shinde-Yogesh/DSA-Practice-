package com.Heap_program;

public class Heap {
    int array[];
    int size;

    Heap(int capacity) {
        array = new int[capacity + 1]; // Initialize the array with a given capacity
        array[0] = -1; // Not used in the heap, but it's a common practice to start from index 1
        size = 0;
    }

    public void insert(int value) {
        size++;
        int index = size;
        array[index] = value;

        // Bubble up to maintain the heap property
        while (index > 1) {
            int parent = index / 2;
            if (array[parent] < array[index]) {
                swap(parent, index);
                index = parent;
            } else {
                return;
            }
        }
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public void delete() {
        if (size == 0) {
            System.out.println("Nothing to delete");
            return;
        }

        // Step 1: Replace the root node with the last node
        array[1] = array[size];

        // Step 2: Decrement size
        size--;

        // Step 3: Take the root node to its correct position
        int i = 1;
        while (i <= size) {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;

            int largest = i;

            // Check if the left child is larger
            if (leftIndex <= size && array[leftIndex] > array[largest]) {
                largest = leftIndex;
            }

            // Check if the right child is larger
            if (rightIndex <= size && array[rightIndex] > array[largest]) {
                largest = rightIndex;
            }

            // If the largest is not the current node, swap
            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                return;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.insert(50);
        heap.insert(55);
        heap.insert(53);
        heap.insert(52);
        heap.insert(54);

        heap.print();
        
        heap.delete();
        
        heap.print();
    }
}
