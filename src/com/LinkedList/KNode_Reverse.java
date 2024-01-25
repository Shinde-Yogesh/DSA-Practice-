package com.LinkedList;

public class KNode_Reverse {
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
	  public static Node kReverse(Node head, int k)
	    {

	        Node curr = head;
	        Node prev = null, next = null;
	        int cnt = 0;

	        // Reversing the first K nodes of the given linked list.
	        while (curr != null && cnt < k)
	        {
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	            cnt++;
	        }

	        // If the last group has < k nodes, reversing it again to get the previous order.
	        if (cnt < k)
	        {
	            curr = prev;
	            prev = null;
	            next = null;
	            cnt = 0;
	            while (curr != null && cnt < k)
	            {

	                next = curr.next;
	                curr.next = prev;
	                prev = curr;
	                curr = next;
	                cnt++;
	            }
	        }

	        // If some nodes are still left, then we pass it to the recursive function.
	        if (next != null)
	        {
	            head.next = kReverse(next, k);
	        }

	        return prev;

	    }

 // Driver Code
 public static void main(String[] args)
 {
	 KNode_Reverse list = new KNode_Reverse();
	 KNode_Reverse.head = new Node(85);
	 KNode_Reverse.head.next = new Node(15);
	 KNode_Reverse.head.next.next = new Node(4);
	 KNode_Reverse.head.next.next.next = new Node(20);

     System.out.println("Given linked list");
     list.printList(head);
//     head = list.reverse(head);
     list.kReverse(head,2);
     System.out.println("");
     System.out.println("Reversed linked list ");
     list.printList(head);
 }
}
