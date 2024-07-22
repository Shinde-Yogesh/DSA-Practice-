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
    
 // Heapify Algorithm
    void heapify(int array[], int n, int i)
    {
        int largest = i;
        int left = 2 * i + 1; // Correct calculation for left child
        int right = 2 * i + 2; // Correct calculation for right child

        // Check if the left child exists and is greater than the current largest
        if (left < n && array[left] > array[largest])
        {
            largest = left;
        }

        // Check if the right child exists and is greater than the current largest
        if (right < n && array[right] > array[largest])
        {
            largest = right;
        }

        // If the largest element is not the current element, swap and continue heapifying
        if (largest != i)
        {
        	 int temp = array[i];
             array[i] = array[largest];
             array[largest] = temp;

             // Recursively heapify the affected subtree
             heapify(array, n, largest);
        }
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
        
        int array[] = {54,53,55,52,50}; 
        int n = array.length-1;
     
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
           heap. heapify(array, n, i);
        }

        // Print the heapified array
        System.out.println("Heapified array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
