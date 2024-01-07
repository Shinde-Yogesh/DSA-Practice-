package com.LinkedList_Udemy_Course;

public class LinkedList_Construct {
	
	private Node head;
	private Node tail;
	private int length;
	
	class Node{
		int value;
		Node next;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
	public LinkedList_Construct(int value)
	{
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public void getHead()
	{
		System.out.println("Head : "+head.value);
	}
	
	public void gettail()
	{
		System.out.println("Tail : "+ tail.value);
	}
	public void getLength()
	{
		System.out.println("Length : "+length);
	}

	// main method
	public static void main(String[] args) {
		LinkedList_Construct myLinkedList = new LinkedList_Construct(4);
		myLinkedList.getHead();
		myLinkedList.gettail();
		myLinkedList.getLength();
		
		
		myLinkedList.printList();
	}
}

/*   		Time Complexcity 
	  Removing the last item from a Linked List is: O(n)
	  Removing the first item from a Linked List is: O(1)
  	  Finding an item by index in a Linked List is:O(n)
        
    */
