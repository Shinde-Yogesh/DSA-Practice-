package com.DoublyLinkedList_Udemy_Course;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;
		Node prev;

		Node(int value) {
			this.value = value;
		}
	}

	public DoublyLinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public void getHead() {
		System.out.println("Head : " + head.value);
	}

	public void getTail() {
		System.out.println("Tail : " + tail.value);
	}
	public void getLength() {
		System.out.println("Length : " + length);
	}
	
	// Append the Node
	public void append(int value)
	{
		Node newNode = new Node(value);
		
		if(length == 0)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		length++;
	}
	
	//removeLast Node
	public Node removeLast()
	{/*
		if(length == 0) return null;
		Node temp = tail;
		tail = temp.prev;
		tail.next = null;
		temp.prev = null;
		length--;
		// One test case for after remove single node in linked list
		if(length == 0)
		{
			head = null;
			tail = null;
		}
		return temp;*/
		
		//optimize code
		if(length == 0) return null;
		Node temp = tail;
		if(length == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			tail = temp.prev;
			tail.next = null;
			temp.prev = null;
		}
		length--;
		return temp;
	}
	
	public void prepend(int value)
	{
		Node newNode = new Node(value);
		if(length == 0)
		{
			head = newNode;
			tail = newNode;
		}else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		length++;
	}
	
	public Node removeFirst()
	{
		if(length == 0) return null;
		Node temp = head;
		if(length == 1)
		{
			head = null;
			tail = null;
		}else
		{
			head = head.next;
			head.prev = null;
			temp.next = null;
		}
		length--;
		return temp;
	}
}
