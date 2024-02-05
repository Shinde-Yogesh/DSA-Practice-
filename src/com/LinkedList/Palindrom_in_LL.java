package com.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;

public class Palindrom_in_LL {

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
		while (current != null) {
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

				// assign the curr node to the curr.next.nxt == next_next
				curr.next = next_next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

	public static Node removeDuplicateUnordered(Node head) {
		// Check if the head is empty
		if (head == null)
			return null;

		// Temp node
		Node current = head;
		Node previous = null;

		HashSet<Integer> visited = new HashSet<>();

		while (current != null) {

			if (!visited.contains(current.data)) {
				visited.add(current.data);
				previous = current;
			} else {
				// Remove the duplicate node by skipping it
				previous.next = current.next;
			}
			// Move to the next node
			current = current.next;
		}
		return head;
	}

	public static boolean isPalindrom(Node head) {
		// create the arraylist
		ArrayList<Node> list = new ArrayList<>();
		Node temp = head;
		while (temp != null) {
			list.add(temp);
			temp = temp.next;

		}
		return checkPalindrom(list);
	}

	private static boolean checkPalindrom(ArrayList<Node> list) {
		int length = list.size();
		int s = 0;
		int e = length - 1;
		while (s <= e) {
			if (list.get(s).data != list.get(e).data) {
				return false;
			}
			;
			s++;
			e--;
		}

		return true;
	}

	public static void main(String[] args) {

		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(2);
		Node NodeThree = new Node(3);
//		Node NodeFour = new Node(2);
//		Node NodeFive = new Node(3);
//		Node NodeSix = new Node(1);

		Node head = NodeOne;

		NodeOne.next = NodeTwo;
		NodeTwo.next = NodeThree;
		NodeThree.next = null;
//		NodeThree.next = NodeFour;
//		NodeFour.next = NodeFive;
//		NodeFive.next = NodeSix;
//		NodeSix.next = null;

//		System.out.println("Before the applying the method ");
//		print(head);
//		
//		removeDuplicateUnordered(head);
//		System.out.println("After the applied the method ");
		System.out.println(isPalindrom(head));
		print(head);

	}

}
