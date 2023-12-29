package com.Stack_Udemy_Course;

public class Stack {

	private Node top;
	private int height;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Stack(int value) {
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}

	public void printStack() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("START");
	}

	public void getTop() {
		System.out.println("Top : " + top.value);
	}

	public void getHeight() {
		System.out.println("height : " + height);
	}

	// push the new node

	public void push(int value) {
		Node newNode = new Node(value);

		if (height == 0) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		height++;
	}

	// pop the node

	public Node pop() {

		if (height == 0) {
			return null;
		}
		Node temp = top;
		top = top.next;
		temp.next = null;
		height--;
		return temp;

	}

}
