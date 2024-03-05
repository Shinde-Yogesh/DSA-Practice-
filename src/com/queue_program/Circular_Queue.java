package com.queue_program;

public class Circular_Queue {

	int array[];
	int front;
	int rear;
	int size;

	// constructor

	public Circular_Queue(int size, int array[], int front, int rear) {
		this.size = size;
		this.array = array;
		this.front = front;
		this.rear = rear;

	}

	public boolean enqueue(int value) {
		if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
			System.out.println("Queue is Full");
			return false;
		} else if (front == -1) // first element to push
		{
			front = rear = 0;

		} else if (rear == size - 1 && front != 0) // rear start from the begining
		{
			rear = 0;

		} else {
			rear++;
		}
		//push inside the queue
		array[rear] = value;
		return true;

	}

	public int dequeue() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return -1;
		}

		int ans = array[front];
		array[front] = -1;
		if (front == rear) {
			front = rear = -1;
		} else if (front == size - 1) // to maintent cycle nature
		{
			front = 0;
		} else {
			front++;
		}
		return ans;

	}
	public static void main(String[] args) {

		int size= 3;
		int array[] = new int[size];
		int front = -1;
		int rear = -1;
		Circular_Queue obj = new Circular_Queue(size,array,front,rear);
		
	     obj.enqueue(2);
	     obj.enqueue(3);
	     obj.enqueue(4);
	     obj.enqueue(6);
	     System.out.println(obj.dequeue());
	     
//	     System.out.println(obj.dequeue());
	     for (int i : array) {
				System.out.print(i+ " ");
			}
	}
}


// Using the Coding Ninja Plateform ans with explanation

/*
 
 			In this approach, we will be implementing a circular queue using arrays. A circular queue has two key methods or purpose:

 

enqueue():
Check whether the queue is full.
A queue is full when the front is next to the rear. For example, with a queue of size 6, if front is 0 and rear is 5, or if front is 2 and rear is 1, it means that the queue is full.
If it is full, then return false.
If the queue is not full, then check if rear is the last index.
If it is, set rear to 0;
If it is not, increment rear and add the value at that index.
dequeue():
Check whether the queue is empty (i.e., if front/rear has a value of -1).
If it is empty, the return -1.
If the queue is not empty, then check if the queue has only one value (i.e., front == rear).
If it does have only one value, set both rear and front to -1.
If it does not, check if front is the last index of the queue and, if so, set front to 0, otherwise, increment front.
 					
	Time complexity: O(1) for all operations.
	Space Complexity: O(N)
	
	Where 'N' is the size of the queue.  


import java.util.ArrayList;

public class CircularQueue {
	// Initialise front and rear of the queue.
	private int rear, front;

	// Size of the queue.
	private int d;

	// Array To be used for the implementation.
	private ArrayList<Integer> arr;

	// Initialize your data structure..
	public CircularQueue(int n) {
		d = n;

		// For a circular queue the front and rear both start as empty.
		front = rear = -1;

		// Create the arrays..
		arr = new ArrayList<Integer>(d);
		for (int i = 0; i < d; i++) {
			arr.add(0);
		}
	}

	// Enqueues 'X' into the Queue. Returns true if it gets enqueued into the queue and false otherwise..
	public boolean enqueue(int value) {
		if ((front == 0 && rear == d - 1) || (rear == (front - 1) % (d - 1))) {
			/*
			  If the queue is full, no more elements can be added so return false.
			   Queue will be full if front is at 1st element and rear is at last element.
			   OR if rear is equal to front - 1.
			
			return false;
		}

		else if (front == -1) {
			// Queue is empty, hence insert the first element.
			front = rear = 0;
			arr.set(rear, value);
		}
		else if (rear == d - 1 && front != 0) {
			// If rear reaches end of queue but the first element is empty.
			rear = 0;
			arr.set(rear, value);
		}
		else {
			// Otherwise simply enqueue the element.
			rear++;
			arr.set(rear, value);
		}
		return true;
	}
	/*
	   Dequeues top element from Mth Queue. Returns -1 if the queue is empty,
	   otherwise returns the dequeued element.
	
	public int dequeue() {
		if (front == -1) {
			// If queue is empty.
			return -1;
		}
		// Initialise element to store dequeud element.
		int data = arr.get(front);
		arr.set(front, -1);

		if (front == rear) {
			// If the queue has only one element.
			front = -1;
			rear = -1;
		}
		else if (front == d - 1) {
			// If front is the last element of the queue.
			front = 0;
		}
		else {
			// In all other cases simply dequeue.
			front++;
		}
		// Return the dequeued element.
		return data;
	}
};


*/
