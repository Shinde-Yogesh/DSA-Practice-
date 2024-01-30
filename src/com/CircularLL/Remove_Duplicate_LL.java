package com.CircularLL;

public class Remove_Duplicate_LL {

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	// printing the node
	public static void print(Node head) {

		if (head == null) {
			System.out.println("Circular Linked List is empty.");
			return;
		}

		Node current = head;
		while(current != null)
		{
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("NULL");
		System.out.println();
	}

	static Node removeDuplicateNode(Node head) {
		if (head == null) {
			return null;
		}

		// store the temp
		Node curr = head;

		while (curr != null) {
			if ((curr.next != null) && curr.data == curr.next.data) {

				// create the node of next node
				Node next_next = curr.next.next;

				// point to the node which have to delete
				//Node nodeToDelete = curr.next;
				//nodeToDelete = null;

				// assign the curr node to the curr.next.nxt == next_next
				curr.next = next_next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {

		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(2);
		Node NodeThree = new Node(2);
		Node NodeFour = new Node(3);
		Node NodeFive = new Node(3);
		Node NodeSix = new Node(4);
		Node NodeSeven = new Node(4);
		Node NodeEight = new Node(8);

		Node head = NodeOne;

		NodeOne.next = NodeTwo;
		NodeTwo.next = NodeThree;
		NodeThree.next = NodeFour;
		NodeFour.next = NodeFive;
		NodeFive.next = NodeSix;
		NodeSix.next = NodeSeven;
		NodeSeven.next = NodeEight;
		NodeEight.next = null;
		
		print(head);
		removeDuplicateNode(head);
		System.out.println("After the remove duplicate method  ");
		print(head);

	}
}
