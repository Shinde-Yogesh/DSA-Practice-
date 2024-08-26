package com.LinkedList;

public class LinkedList {
	  static Node head;
	  
	    static class Node {
	 
	        int data;
	        Node next;
	 
	        Node(int d)
	        {
	            data = d;
	            next = null;
	        }
	    }
	
	
	void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " "+" -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        LinkedList.head = new Node(85);
        LinkedList.head.next = new Node(15);
        LinkedList.head.next.next = new Node(4);
        LinkedList.head.next.next.next = new Node(20);
 
        System.out.println("Given linked list");
        list.printList(head);
        
        head = list.reverse(head);
        System.out.println("");
        
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    //using linear way
  /*  Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }*/
    
    //using recursion
    Node reverse(Node head)
    {
    	
    	if(head == null || head.next == null) return head;
    	
    	Node chotaHead = reverse(head.next);
    	head.next.next = head;
    	head.next = null;
		return chotaHead;
    	
    }
}
