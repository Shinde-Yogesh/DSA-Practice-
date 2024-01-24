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

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " " + " -> ");
			node = node.next;
		}
		System.out.println("NULL");
	}

	/*
	 * // for the length public static int length(Node head) { int count = 0; while
	 * (head != null) { count++; head = head.next; } return count; }
	 * 
	 * //for the middle node Node findMiddleNode(Node head) { int len =
	 * length(head); int ans = (len/2);
	 * 
	 * Node temp = head; int cnt = 0; while(cnt < ans) { temp = temp.next; cnt++; }
	 * return temp; }
	 */

	// optimization code

	Node findMiddleNode(Node head) {
		if (head == null || head.next == null)
			return head;

		// for the 2 node condition
		if (head.next.next == null)
			return head.next;

		Node slow = head;
		Node fast = head.next;

		while (fast != null) {
			fast = fast.next;

			if (fast != null) {
				fast = fast.next;
			}
			slow = slow.next;
		}
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

		System.out.println("Given linked list");
		list.printList(head);
		System.out.println("Middle Node of linked list " + list.findMiddleNode(head).data);

//		System.out.println("Length of LL : "+length(head));
	}

}
