package com.CircularLL;

public class isCircular_LL {

	  private static class Node {
	        int data;
	        Node next;

	        public Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    private Node head;  // Head of the circular linked list

	    // Constructor to initialize an empty circular linked list
	    public isCircular_LL() {
	        head = null;
	    }

	    // Method to insert a new node at the end of the circular linked list
	    public void insert(int data) {
	        Node newNode = new Node(data);

	        // If the list is empty, make the new node as the head and point its next to itself
	        if (head == null) {
	            head = newNode;
	            head.next = head;
	        } else {
	            // Traverse to the end of the list
	            Node current = head;
	            while (current.next != head) {
	                current = current.next;
	            }

	            // Insert the new node at the end
	            current.next = newNode;
	            newNode.next = head;
	        }
	    }
	    // Method to print the elements of the circular linked list
	    public void print() {
	        if (head == null) {
	            System.out.println("Circular Linked List is empty.");
	            return;
	        }

	        Node current = head;
	        do {
	            System.out.print(current.data + " "+" -> ");
	            current = current.next;
	        } while (current != head);
	        System.out.println("HEAD");
	        System.out.println();
	    }
	    
	    public static boolean iscircular(Node head)
	    {
	    	//check is CLLL is empty
	    	if(head == null)
	    	{
	    		return false;
	    	}
	    	
	    	// for the single node and more than one node
	    
	    	//create temp node
	    	Node temp= head.next;
	    	while(temp != null && temp != head)
	    	{
	    		temp = temp.next;
	    	}
	    	if(temp == head)
	    	{
	    		return true;
	    	}
	    	return false;
	    }

	    public static void main(String[] args) {
	    	isCircular_LL  circularList = new isCircular_LL();

	        // Inserting elements into the circular linked list
	        circularList.insert(1);
	        circularList.insert(2);
	        circularList.insert(3);
	        circularList.insert(4);
	        circularList.insert(5);

	        // Printing the elements of the circular linked list
	        System.out.println("Circular Linked List:");
	        circularList.print();
	       
	    }
	
}
