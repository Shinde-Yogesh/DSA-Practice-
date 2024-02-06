package com.LinkedList;

public class Add_Two_LL_And_New_Create {
	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node addTwoLists(Node first, Node second) {
		// code here
		// return head of sum list
		first = reverseList(first);
		second = reverseList(second);
		Node res = null, cur1 = first, cur2 = second, cur = null;
		int carry = 0;
		while (cur1 != null && cur2 != null) {
			int sum = cur1.data + cur2.data + carry;
			Node n = new Node(sum % 10);
			carry = sum / 10;
			if (res == null) {
				res = cur = n;
			} else {
				cur.next = n;
				cur = cur.next;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		while (cur1 != null) {
			int sum = cur1.data + carry;
			Node n = new Node(sum % 10);
			carry = sum / 10;
			cur.next = n;
			cur = cur.next;
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			int sum = cur2.data + carry;
			Node n = new Node(sum % 10);
			carry = sum / 10;
			cur.next = n;
			cur = cur.next;
			cur2 = cur2.next;
		}
		if (carry > 0) {
			Node n = new Node(carry);
			cur.next = n;
		}
		return reverseList(res);
	}

	static Node reverseList(Node head) {
		if (head.next == null)
			return head;
		Node temp = head.next;
		Node newHead = reverseList(temp);
		temp.next = head;
		head.next = null;
		return newHead;
	}

	public static void print(Node head) {

		if (head == null) {
			System.out.println("Linked List is empty.");
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

	public static void main(String[] args) {

		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(2);
		Node NodeThree = new Node(3);
		Node NodeFour = new Node(4);
		Node NodeFive = new Node(5);
		Node NodeSix = new Node(6);

		Node head = NodeOne;

		NodeOne.next = NodeTwo;
		NodeTwo.next = NodeThree;
		NodeThree.next = NodeFour;
		NodeFour.next = NodeFive;
		NodeFive.next = NodeSix;
		NodeSix.next = null;

		// new Linked List create
		Node sampleOne = new Node(1);
		Node sampleTwo = new Node(2);
		Node sampleThree = new Node(3);
		Node sampleFour = new Node(4);

		Node sampleHead = sampleOne;

		sampleOne.next = sampleTwo;
		sampleTwo.next = sampleThree;
		sampleThree.next = sampleFour;
		sampleFour.next = null;
//		
//		Node result = addTwoLists(NodeOne, sampleOne);
//		
//		while(result != null)
//		{
//			System.out.println("The result : "+result.data);
//			result  = result.next;
//		}
		print(head);
//		System.out.println();
		print(sampleHead);

		Node result = addTwoLists(NodeOne, sampleOne);

		while (result != null) {
			System.out.print(result.data + " -> ");
			result = result.next;
		}
		System.out.println("NULL");
	}

}