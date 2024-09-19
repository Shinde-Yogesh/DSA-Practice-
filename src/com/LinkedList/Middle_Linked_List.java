package com.LinkedList;

public class Middle_Linked_List {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to print the linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}

	// Optimized method to find the middle node of a linked list
	Node findMiddleNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// The slow pointer will now be at the middle node
		return slow;
	}

	// Driver Code
	public static void main(String[] args) {
		Middle_Linked_List list = new Middle_Linked_List();
		Middle_Linked_List.head = new Node(85);
		Middle_Linked_List.head.next = new Node(15);
		Middle_Linked_List.head.next.next = new Node(4);
		Middle_Linked_List.head.next.next.next = new Node(20);
		Middle_Linked_List.head.next.next.next.next = new Node(25);

		System.out.println("Given linked list:");
		list.printList(head);

		// Finding and printing the middle node
		Node middleNode = list.findMiddleNode(head);
		System.out.println("Middle Node of linked list: " + middleNode.data);
	}
}
