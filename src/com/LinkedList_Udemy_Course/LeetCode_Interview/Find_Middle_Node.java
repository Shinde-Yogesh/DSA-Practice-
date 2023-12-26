package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Find_Middle_Node {
	private Node head;
	private Node tail;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Find_Middle_Node(int value) {
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

	public Node findMiddleNode() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		Find_Middle_Node myLinkedList = new Find_Middle_Node(1);
		myLinkedList.append(2);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);

		System.out.println("1 -> 2 -> 3 -> 4 -> 5");
		System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

		myLinkedList.append(6);

		System.out.println("===========================");
		System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
		System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

		/*
		 * EXPECTED OUTPUT: ---------------- 1 -> 2 -> 3 -> 4 -> 5 Middle Node: 3
		 * =========================== 1 -> 2 -> 3 -> 4 -> 5 -> 6 Middle Node: 4
		 * 
		 */

	}

	// WRITE FIND MIDDLE NODE METHOD HERE //
	// //
	// //
	// //
	// //
	////////////////////////////////////////

}
/*
 * LL: Find Middle Node ( ** Interview Question) Implement a method called
 * findMiddleNode that returns the middle node of the linked list.
 * 
 * If the list has an even number of nodes, the method should return the second
 * middle node.
 * 
 * 
 * Method signature:
 * 
 * public Node findMiddleNode()
 * 
 * 
 * 
 * 
 * Example:
 * 
 * LinkedList myList = new LinkedList(1); myList.append(2); myList.append(3);
 * myList.append(4); myList.append(5); Node middleNode =
 * myList.findMiddleNode(); System.out.println(middleNode.value); // Output: 3
 * 
 * myList.append(6); middleNode = myList.findMiddleNode();
 * System.out.println(middleNode.value); // Output: 4
 * 
 * 
 * When the linked list has an odd number of nodes, like 1 -> 2 -> 3 -> 4 -> 5,
 * the function will find the exact middle node. In this case, it will return
 * the node containing the value 3.
 * 
 * When the linked list has an even number of nodes, there will be two middle
 * nodes. The findMiddleNode function will return the second of these two middle
 * nodes.
 * 
 * For example, if the linked list is 1 -> 2 -> 3 -> 4 -> 5 -> 6, the two middle
 * nodes are 3 and 4. The function will return the node containing the value 4.
 * 
 * 
 * 
 * Note:
 * 
 * In this problem, you should use the slow and fast pointer technique (also
 * known as Floyd's Tortoise and Hare algorithm) to find the middle element of
 * the linked list efficiently.
 * 
 * The key idea is to have two pointers, one that moves twice as fast as the
 * other. By the time the fast pointer reaches the end of the linked list, the
 * slow pointer will be at the middle.
 * 
 * 
 * 
 * DO NOT use the length attribute in your solution.
 */




/* 					Explanation with Ans

	Example Odd Number of Nodes:

Let's walk through the algorithm when the linked list has 5 elements. We'll denote these as:

Node1 -> Node2 -> Node3 -> Node4 -> Node5.

Initially:

slow = Node1

fast = Node1



First Iteration:

slow = slow.next → slow = Node2

fast = fast.next.next → fast = Node3

Here, slow is at Node2 and fast is at Node3.



Second Iteration:

Now, let's check the while condition:

fast is not null (it's Node3).

fast.next is also not null (it's Node4).

We go into the loop again:

slow = slow.next → slow = Node3

fast = fast.next.next → fast = Node5

Here, slow is at Node3 and fast is at Node5.



Third Iteration:

Now, let's check the while condition again:

fast is not null (it's Node5).

fast.next is null (end of the list).



The while loop will stop because the condition fast != null && fast.next != null is not fully met.

The method then returns slow, which points to Node3, the middle element in this 5-element linked list.



Example Even Number of Nodes:

Let's walk through what happens when the linked list has 4 elements. We'll denote these as:

Node1 -> Node2 -> Node3 -> Node4

Initially: slow = Node1, fast = Node1


First Iteration:

slow = slow.next → slow = Node2

fast = fast.next.next → fast = Node3

Here, slow points to the second node, and fast points to the third node.


Second Iteration:

Now, let's check the while condition:

fast is not null (it's Node3).

fast.next is also not null (it's Node4).

So, we go into the loop again:

slow = slow.next → slow = Node3

fast = fast.next.next → fast = null


In the second iteration, slow moves to Node3 and fast tries to jump two steps ahead, but it ends up at null.

Now, the while loop will stop. fast is null, so the condition fast != null && fast.next != null will not be true.


The method returns slow, which is pointing to Node3, the third element in this 4-element linked list. In the case of an even-numbered linked list, the algorithm returns the second middle element.





Code with inline comments:



public Node findMiddleNode() {
    // Initialize slow pointer to the head of the linked list
    Node slow = head;
 
    // Initialize fast pointer to the head of the linked list
    Node fast = head;
 
    // Traverse the linked list with two pointers: slow and fast
    // slow moves one node at a time, while fast moves two nodes at a time
    while (fast != null && fast.next != null) {
        // Move slow pointer to the next node
        slow = slow.next;
 
        // Move fast pointer to the next two nodes
        fast = fast.next.next;
    }
 
    // Return the Node object representing the middle node of the linked list
    return slow;
}







*/