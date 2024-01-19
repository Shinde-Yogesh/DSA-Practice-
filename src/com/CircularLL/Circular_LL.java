package com.CircularLL;

public class Circular_LL {
	/*class Node{
		int value;
		Node next;
		
		public Node(int value)
		{
			this.value = value;
			next = null;
		}
	}
void insertNode(Node tail, int element, int value)
{

	//empty list
	if(tail == null)
	{
		Node newNode = new Node(value);
		tail = newNode;
		newNode.next = newNode;
	}
	else
	{
		// non empty list
		Node curr =tail;
		while(curr.value != element)
		{
			curr = curr.next;
		}
		
//		element found curr is representing the element
		Node temp = new Node(value);
		temp.next = curr.next;
		curr.next = temp;
	}
}

void print(Node tail)
{
	Node temp = tail;
//	while(tail.next != temp)
//	{
//		System.out.print(tail.value + " ");
//		tail = tail.next;
//	}
//	System.out.println( " NULL");
	
	//using do while loop
	do {
		System.out.print(tail.value +" ");
		tail = tail.next;
	}while(tail != temp);
}
	
	public static void main(String[] args) {
		Node tail ;
		Circular_LL cll = new Circular_LL();
		cll.insertNode(tail, 5, 3);
		cll.print(tail);
	
	}*/
	
	
	  // Node class representing each element in the linked list
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
    public Circular_LL() {
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
    public void deleteNode(int value)
    {
    
    	if(head == null)
    	{
    		System.out.println("List is empty try again ");
    		return;
    	}else
    	{
    		Node prev = head;
    		Node curr = prev.next;
    		
    		while(curr.data != value)
    		{
    			prev = curr;
    			curr = curr.next;
    		}
    		prev.next = curr.next;
    		
    		//for the single linked list node
    		if(curr ==prev)
    		{
    			head = null;
    		}
    		//for the >2 node case
    		if(head == curr)
    		{
    			head = prev;
    		}
    		curr.next = null;
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

    public static void main(String[] args) {
    	Circular_LL circularList = new Circular_LL();

        // Inserting elements into the circular linked list
        circularList.insert(1);
        circularList.insert(2);
//        circularList.insert(3);
//        circularList.insert(4);
//        circularList.insert(5);

        // Printing the elements of the circular linked list
        System.out.println("Circular Linked List:");
        circularList.print();
        System.out.println("Circular Linked List: After Delete Node");
        circularList.deleteNode(2);
        circularList.print();
    }
}
