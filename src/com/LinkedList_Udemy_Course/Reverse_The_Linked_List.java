package com.LinkedList_Udemy_Course;

public class Reverse_The_Linked_List {

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

	public Reverse_The_Linked_List(int value) {
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

	public boolean insert(int index, int value) {
		if (index < 0 || index > length)
			return false;
		if (index == 0) {
			append(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}

		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}

	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;

		Node after = temp.next;
		Node before = null;
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}

	}

	public void getLength() {
		System.out.println("Length : " + length);
	}

	// main method
	public static void main(String[] args) {
		Reverse_The_Linked_List myLinkedList = new Reverse_The_Linked_List(4);
		myLinkedList.append(5);
		myLinkedList.append(6);
		myLinkedList.append(7);
		myLinkedList.append(8);
		myLinkedList.append(9);

		myLinkedList.getLength();

		myLinkedList.printList();
		System.out.println("Reverse the Linked List");
		myLinkedList.reverse();
		myLinkedList.printList();
	}

}
