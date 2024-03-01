package com.queue_program;

public class Queue_Imple_Using_Array {
	int array[];
	int qfront;
	int rear;
	int size;
	
	//constructor
	
	
	public Queue_Imple_Using_Array(int size, int array[],int front,int rear)
	{
		this.size = size;
		this.array = array;
		this.qfront = front;
		this.rear = rear;
		
	}
	
	//insert the end 
	
	
	void enqueue(int data)
	{
		if(rear == size)
		{
			System.out.println("Queue is full");
		}
		else
		{
			array[rear] = data;
			rear ++;
		}
	}
	
	//delete the record from front
	int dequeue()
	{
		if(qfront == rear)
		{
			return -1;
		}else
		{
			int ans = array[qfront];
			array[qfront] =-1;
			qfront++;
			if(qfront == rear )
			{
				qfront = 0;
				rear = 0;
			}
			return ans;
		}
	}
	
	//front element
	int front()
	{
		if(qfront == rear)
		{
			return -1;
		}
		else
		{
			return array[qfront];
		}
	}
	boolean isEmpty()
	{
		if(qfront == rear)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public static void main(String[] args) {
		
		int size= 10;
		int array[] = new int[size];
		int front = 0;
		int rear = 0;
		Queue_Imple_Using_Array obj = new Queue_Imple_Using_Array(10001,array,front,rear);
//		0;
		
		obj.enqueue(17);
		obj.enqueue(23);
		obj.enqueue(19);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.isEmpty());
//		System.out.println();
		for (int i : array) {
			System.out.print(i+ " ");
		}
		
	}
}
