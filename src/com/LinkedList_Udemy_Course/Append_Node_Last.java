package com.LinkedList_Udemy_Course;

public class Append_Node_Last {
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

	// constuctor

	public Append_Node_Last(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value+" -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
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

	public static void main(String[] args) {
		Append_Node_Last myLinkedList = new Append_Node_Last(4);
		myLinkedList.printList();

		myLinkedList.append(5);
		myLinkedList.printList();
	}

}
