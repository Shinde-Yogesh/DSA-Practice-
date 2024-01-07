package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Partion_List {

	private Node head;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Partion_List(int value) {
		Node newNode = new Node(value);
		head = newNode;
		length = 1;
	}

	public Node getHead() {
		return head;
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
		} else {
			System.out.println("Head: " + head.value);
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
		length = 0;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		length++;
	}

	public void partitionList(int x) {
		if (head == null) {
			// If the linked list is empty, return immediately
			return;
		}

		Node lessThanXHead = new Node(0); // Dummy node for the chain with values less than x
		Node lessThanX = lessThanXHead;

		Node greaterThanOrEqualXHead = new Node(0); // Dummy node for the chain with values greater than or equal to x
		Node greaterThanOrEqualX = greaterThanOrEqualXHead;

		Node current = head;

		// Traverse the linked list
		while (current != null) {
			if (current.value < x) {
				lessThanX.next = current;
				lessThanX = lessThanX.next;
			} else {
				greaterThanOrEqualX.next = current;
				greaterThanOrEqualX = greaterThanOrEqualX.next;
			}

			current = current.next;
		}

		// Connect the two chains
		lessThanX.next = greaterThanOrEqualXHead.next;
		greaterThanOrEqualX.next = null;

		// Update the head of the linked list
		head = lessThanXHead.next;
	}

	public static void main(String[] args) {

		// Create a new LinkedList and append values to it
		Partion_List ll = new Partion_List(3);
		ll.append(5);
		ll.append(8);
		ll.append(10);
		ll.append(2);
		ll.append(1);

		// Print the list before partitioning
		System.out.println("LL before partitionList:");
		ll.printList(); // Output: 3 5 8 10 2 1

		// Call the partitionList method with x = 5
		ll.partitionList(5);

		// Print the list after partitioning
		System.out.println("LL after partitionList:");
		ll.printList(); // Output: 3 2 1 5 8 10

		/*
		 * EXPECTED OUTPUT: ---------------- LL before partition_list: 3 5 8 10 2 1 LL
		 * after partition_list: 3 2 1 5 8 10
		 * 
		 */

	}

}

/*
 * Solution
 * 
 * public void partitionList(int x) { if (head == null) return;
 * 
 * Node dummy1 = new Node(0); Node dummy2 = new Node(0); Node prev1 = dummy1;
 * Node prev2 = dummy2; Node current = head;
 * 
 * while (current != null) { if (current.value < x) { prev1.next = current;
 * prev1 = current; } else { prev2.next = current; prev2 = current; } current =
 * current.next; }
 * 
 * prev2.next = null; prev1.next = dummy2.next;
 * 
 * head = dummy1.next; }
 * 
 * 
 * 
 * 
 * The partitionList method aims to rearrange nodes in a singly linked list
 * based on a given integer value x.
 * 
 * Nodes with values less than x are moved before those with values greater than
 * or equal to x.
 * 
 * The original relative order of the nodes is maintained.
 * 
 * Here's a more detailed breakdown of each part:
 * 
 * 
 * 
 * Check for Empty List: if (head == null) return; The first line of code checks
 * whether the linked list is empty. If the head pointer is null, there's
 * nothing to partition. The method immediately returns, avoiding any further
 * computations.
 * 
 * Create Dummy Nodes: Node dummy1 = new Node(0); Node dummy2 = new Node(0); Two
 * dummy nodes are created with value 0. These act as temporary placeholders and
 * make it easier to manage the two new lists being formed—one for nodes less
 * than x and another for nodes greater than or equal to x.
 * 
 * Initialize Tracker Variables: Node prev1 = dummy1; Node prev2 = dummy2; Two
 * variables, prev1 and prev2, are initialized to point to the dummy nodes.
 * These variables will help us keep track of the last nodes in each of our two
 * new lists as we build them.
 * 
 * Initialize Current Node: Node current = head; A variable named current is
 * initialized to point to the head of the list. This current node will be the
 * starting point for our iteration through the linked list.
 * 
 * Iterate Through the List: while (current != null) { ... } A while loop is
 * used to iterate through the original linked list. This loop will keep running
 * until we reach the end of the list, signified by current becoming null.
 * 
 * Inside the Loop:
 * 
 * a. Nodes with Value Less Than x: if (current.value < x) { ... } If the
 * current node's value is less than x, we append it to the end of the list
 * being built by prev1.
 * 
 * b. Nodes with Value Greater or Equal to x: else { ... } If the current node's
 * value is greater than or equal to x, we append it to the end of the list
 * being built by prev2.
 * 
 * c. Move to Next Node: current = current.next; After deciding where the
 * current node should be placed, we advance current to the next node in the
 * list for the next iteration.
 * 
 * Mark End of Second List: prev2.next = null; After the while loop ends, we
 * need to ensure that the end of the list managed by prev2 is properly marked.
 * We set the next pointer of the last node to null.
 * 
 * Connect The Two Lists: prev1.next = dummy2.next; Now, we connect the two
 * lists to form a single, partitioned list. The next pointer of the last node
 * in the list tracked by prev1 is set to the first actual node in the list
 * tracked by dummy2.
 * 
 * Update Head Pointer: head = dummy1.next; Finally, the head of the original
 * list is updated to point to the first actual node in the list tracked by
 * dummy1. This effectively completes the partitioning process.
 * 
 * 
 * 
 * 
 * 
 * Code with inline comments:
 * 
 * 
 * 
 * public void partitionList(int x) { // Step 1: Check for an empty list. // If
 * the list is empty, there is nothing // to partition, so we exit the method.
 * if (head == null) return;
 * 
 * // Step 2: Create two dummy nodes. // These dummy nodes act as placeholders
 * // to simplify list manipulation. Node dummy1 = new Node(0); Node dummy2 =
 * new Node(0);
 * 
 * // Step 3: Initialize pointers for new lists. // 'prev1' and 'prev2' will
 * track the end nodes of // the two lists that are being created. Node prev1 =
 * dummy1; Node prev2 = dummy2;
 * 
 * // Step 4: Start with the head of the original list. Node current = head;
 * 
 * // Step 5: Iterate through the original list. while (current != null) {
 * 
 * // Step 6: Compare current node value with 'x'. // Nodes are partitioned
 * based on their value // being less than or greater than/equal to 'x'.
 * 
 * // Step 6.1: If value is less than 'x', // add node to the first list. if
 * (current.value < x) { prev1.next = current; // Link node to the end of the
 * first list. prev1 = current; // Update the end pointer of the first list. }
 * else { // Step 6.2: If value is greater or equal, // add node to the second
 * list. prev2.next = current; // Link node to the end of the second list. prev2
 * = current; // Update the end pointer of the second list. }
 * 
 * // Move to the next node in the original list. current = current.next; }
 * 
 * // Step 7: Terminate the second list. // This prevents cycles in the list.
 * prev2.next = null;
 * 
 * // Step 8: Connect the two lists. // The first list is followed by the second
 * list. prev1.next = dummy2.next;
 * 
 * // Step 9: Update the head of the original list. // The head now points to
 * the start of the first list. head = dummy1.next; }
 */
