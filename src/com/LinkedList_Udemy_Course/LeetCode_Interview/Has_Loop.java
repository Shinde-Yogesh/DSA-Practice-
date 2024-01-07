package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Has_Loop {

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

	public Has_Loop(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void printAll() {
		if (length == 0) {
			System.out.println("Head: null");
			System.out.println("Tail: null");
		} else {
			System.out.println("Head: " + head.value);
			System.out.println("Tail: " + tail.value);
		}
		System.out.println("Length:" + length);
		System.out.println("\nLinked List:");
		if (length == 0) {
			System.out.println("empty");
		} else {
			printList();
		}
	}

	public void makeEmpty() {
		head = null;
		tail = null;
		length = 0;
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

	// Other methods for adding nodes to the list can be implemented here

	public boolean hasLoop() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next; // Move one step at a time
			fast = fast.next.next; // Move two steps at a time

			// If the pointers meet, there is a loop
			if (slow == fast) {
				return true;
			}
		}

		// If fast reaches the end of the list, there is no loop
		return false;
	}
	 public static void main(String[] args) {

		 Has_Loop myLinkedList = new Has_Loop(1);
	        myLinkedList.append(2);
	        myLinkedList.append(3);
	        myLinkedList.append(4);
	        myLinkedList.append(5);
	        
	        // create a loop by connecting the tail to the second node
	        myLinkedList.getTail().next = myLinkedList.getHead().next;
	        

	        System.out.println("Has Loop:");
	        System.out.println( myLinkedList.hasLoop());


	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            Has Loop:
	            true

	        */

	    }

}
/*
 * solution checks if there is at least one more node after the current fast
 * node before trying to move to the next node. If this condition wasn't there
 * and fast was at the last node in the list, trying to move two nodes ahead
 * with fast.next.next would result in a NullPointerException. 
 * 
 * 
 * Code with inline comments:
 * 
 * 
 * 
 * public boolean hasLoop() { // Initialize slow pointer to the head of the
 * linked list Node slow = head;
 * 
 * // Initialize fast pointer to the head of the linked list Node fast = head;
 * 
 * // Traverse the linked list with two pointers: slow and fast // slow moves
 * one node at a time, while fast moves two nodes at a time while (fast != null
 * && fast.next != null) { // Move slow pointer to the next node slow =
 * slow.next;
 * 
 * // Move fast pointer to the next two nodes fast = fast.next.next;
 * 
 * // If slow pointer meets fast pointer, then there is a loop in the linked
 * list if (slow == fast) { return true; } }
 * 
 * // If the loop has not been detected after the traversal, then there is no
 * loop in the linked list return false; }
 */
