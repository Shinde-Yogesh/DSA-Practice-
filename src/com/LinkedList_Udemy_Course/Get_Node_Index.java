package com.LinkedList_Udemy_Course;

public class Get_Node_Index {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Get_Node_Index(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public Node get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public boolean set(int index, int value)
	{
		Node temp = get(index);
		if(temp != null)
		{
			temp.value = value;
			return true;
		}
		return false;
	}

	public void getLength() {
		System.out.println("Length : " + length);
	}

	// main method
	public static void main(String[] args) {
		Get_Node_Index myLinkedList = new Get_Node_Index(4);
		myLinkedList.append(5);
		myLinkedList.append(6);
		myLinkedList.append(7);
		myLinkedList.append(8);
		myLinkedList.getLength();
		
		myLinkedList.printList();
		myLinkedList.set(4,9);
		
		myLinkedList.printList();
//		System.out.println("The index element : "+myLinkedList.get(2).value);
	}

}
