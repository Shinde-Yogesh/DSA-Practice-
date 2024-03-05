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
	/*
    Time complexity: O(q)
    Space complexity: O(q)

    Where q is the number of queries.
*/
/*
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
};

public class Queue_Imple_Using_Array {
    Node head;
    Node tail;
    int size;

    Queue_Imple_Using_Array() {
        head = null;
        tail = null;
        size = 0;
    }

    // Function to check if the queue is empty.
    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {

        // Increase the count of elements present in the List.
        size++;

        // Create a new node.
        Node newNode = new Node(data);

        // Check if the Queue is empty.
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Push the element to the last of the queue.
        tail.next = newNode;
        tail = newNode;
        return;
    }

    int dequeue() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        int ans = head.data;

        Node tmp = head;
        head = head.next;

        // If the queue is empty make the tail pointer null.
        if (head == null) {
            tail = null;
        }

        tmp = null;

        size--;

        return ans;
    }

    int front() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        // Return the element at the front.
        return head.data;
    }
//    print the queue using linked list
    public  void print()
    {
    	Node temp = head;
    	while(temp != tail)
    	{
    		System.out.print(temp.data + " "+" -> ");
    		temp = temp.next;
    	}
    	System.out.print(tail.data +" -> ");
    	System.out.println("REAR");
    }
    public static void main(String[] args) {
    	Queue_Imple_Using_Array obj  = new Queue_Imple_Using_Array();
    	obj.enqueue(17);
    	obj.enqueue(19);
    	obj.enqueue(23);
    	System.out.println(obj.isEmpty());
    	obj.print();
	}

}*/


