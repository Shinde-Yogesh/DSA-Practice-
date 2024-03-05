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
