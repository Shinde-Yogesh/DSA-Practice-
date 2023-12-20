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
			System.out.print(temp.value + " -> ");
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

	// remove first element
	public Node removeFirst() {
		if (length == 0)
			return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if (length == 0) {
			tail = null;
		}
		return temp;
	}

	public Node removeLast() {
		if (length == 0) {
			return null;
		}

		Node temp = head;
		Node pre = head;

		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		tail = pre;
		tail.next = null;
		length--;

		// if single node test case
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}

	public static void main(String[] args) {
		Append_Node_Last myLinkedList = new Append_Node_Last(4);
//		myLinkedList.printList();

		myLinkedList.append(5);
//		myLinkedList.printList();
		/*
		// if 2 Item - return 2 node
		System.out.println(myLinkedList.removeLast().value);

		// if 1Item - return 1 node
		System.out.println(myLinkedList.removeLast().value);

		// if 0 Item - return null
		System.out.println(myLinkedList.removeLast());
		
		*/
		
		myLinkedList.printList();
		
		// if 2 Item - return 2 node
				System.out.println(myLinkedList.removeFirst().value);

				// if 1Item - return 1 node
				System.out.println(myLinkedList.removeFirst().value);

				// if 0 Item - return null
				System.out.println(myLinkedList.removeFirst());
	}

}
