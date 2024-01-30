package com.CircularLL;

import java.util.HashSet;

import com.CircularLL.Floyds_Cycle_Detection_Algorithm.Node;

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

				// assign the curr node to the curr.next.nxt == next_next
				curr.next = next_next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}
	
	//for the unsorted linked list
//	public static Node removeDuplicateUnordersorted(Node head)
//	{
//		//check head is empty or not
//		if(head == null)
//			return null;
//		
//		//temp node
//		Node temp= head;
//		
//		HashSet<Node> visited = new HashSet<>();
//		 while(temp != null)
//		 {
//			 if(!visited.contains(temp))
//			 {
//				 visited.add(temp);
//				 temp = temp.next;
//			 }
//			 //move the next node
//			 temp = temp.next;
//		 }
//		 return head;
//	}

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
	
	public static void main(String[] args) {

		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(3);
		Node NodeThree = new Node(2);
		Node NodeFour = new Node(5);
		Node NodeFive = new Node(1);
		Node NodeSix = new Node(1);
		
		Node head = NodeOne;

		NodeOne.next = NodeTwo;
		NodeTwo.next = NodeThree;
		NodeThree.next = NodeFour;
		NodeFour.next = NodeFive;
		NodeFive.next = NodeSix;
		NodeSix.next = null;
		
		System.out.println("Before the applying the method ");
		print(head);
		
		removeDuplicateUnordered(head);
		System.out.println("After the applied the method ");
		print(head);

	}
}
