package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class K_Th_Node {
	private Node head;
	private Node tail;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public K_Th_Node(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void printAll() {
		if (head == null) {
			System.out.println("Head: null");
			System.out.println("Tail: null");
		} else {
			System.out.println("Head: " + head.value);
			System.out.println("Tail: " + tail.value);
		}
		System.out.println("\nLinked List:");
		if (head == null) {
			System.out.println("empty");
		} else {
			printList();
		}
	}

	public void makeEmpty() {
		head = null;
		tail = null;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Node findKthFromEnd(int k) {
		if (k <= 0 || head == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;

		// Move the fast pointer k nodes ahead
		for (int i = 0; i < k; i++) {
			if (fast == null) {
				// If the list has fewer than k nodes
				return null;
			}
			fast = fast.next;
		}

		// Move both pointers until the fast pointer reaches the end
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		K_Th_Node myLinkedList = new K_Th_Node(1);
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);

		int k = 2;
		int result = myLinkedList.findKthFromEnd(k).value;

		System.out.println(result); // Output: 4

		/*
		 * EXPECTED OUTPUT: ---------------- 4
		 * 
		 */

	}
}
/*
 * question
 * 
 * LL: Find Kth Node From End ( ** Interview Question) Implement a method called
 * findKthFromEnd that returns the k-th node from the end of the list.
 * 
 * If the list has fewer than k nodes, the method should return null.
 * 
 * Note: This implementation of the Linked List class does not have the length
 * attribute.
 * 
 * Method signature:
 * 
 * public Node findKthFromEnd(int k)
 * 
 * 
 * Example:
 * 
 * LinkedList myList = new LinkedList(1); myList.append(2); myList.append(3);
 * myList.append(4); myList.append(5);
 * 
 * Node result = myList.findKthFromEnd(2); // Output: Node with value 4
 * 
 * result = myList.findKthFromEnd(5); // Output: Node with value 1
 * 
 * result = myList.findKthFromEnd(6); // Output: null
 * 
 * 
 * Note:
 * 
 * In this problem, you should use the two-pointer technique to efficiently find
 * the k-th node from the end of the linked list.
 */

/*
 * Solution public Node findKthFromEnd(int k) { Node slow = head; Node fast =
 * head;
 * 
 * for (int i = 0; i < k; i++) { if (fast == null) { return null; } fast =
 * fast.next; }
 * 
 * while (fast != null) { slow = slow.next; fast = fast.next; }
 * 
 * return slow; }
 * 
 * 
 * 
 * 
 * This code defines a method called findKthFromEnd inside a LinkedList class,
 * which takes an integer k as input and returns the kth node from the end of
 * the LinkedList.
 * 
 * 
 * 
 * The method initializes two pointers, slow and fast, both pointing to the head
 * of the LinkedList.
 * 
 * It then moves the fast pointer k steps ahead in the LinkedList. If fast
 * becomes null at any point during this process, it means that k is out of
 * bounds (greater than the length of the LinkedList), so the method returns
 * null.
 * 
 * After moving the fast pointer k steps ahead, the method enters a while loop.
 * This loop continues until the fast pointer reaches the end of the LinkedList
 * (i.e., fast becomes null).
 * 
 * Inside the while loop, both the slow and fast pointers move one step at a
 * time. Since the fast pointer is already k steps ahead of the slow pointer,
 * when the fast pointer reaches the end of the LinkedList, the slow pointer
 * will be at the kth node from the end.
 * 
 * Finally, the method returns the slow pointer, which now points to the kth
 * node from the end of the LinkedList.
 * 
 * 
 * 
 * 
 * 
 * Code with inline comments:
 * 
 * 
 * 
 * public Node findKthFromEnd(int k) { Node slow = head; // Initialize slow
 * pointer at head Node fast = head; // Initialize fast pointer at head
 * 
 * // Move fast pointer k steps ahead for (int i = 0; i < k; i++) { if (fast ==
 * null) { // If k is out of bounds, return null return null; } fast =
 * fast.next; // Move the fast pointer to the next node }
 * 
 * // Move both pointers until fast reaches the end while (fast != null) { slow
 * = slow.next; // Move the slow pointer to the next node fast = fast.next; //
 * Move the fast pointer to the next node }
 * 
 * return slow; // Return the kth node from the end (slow pointer) }
 */