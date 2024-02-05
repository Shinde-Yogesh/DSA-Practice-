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
	public static void print_for_CLL(Node head) {

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
	
	// Aprroach 2
	
	static Node getmiddleNode(Node head)
	{
		Node fast = head.next;
		Node slow = head;
		
		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static boolean isPalindromApproch_2(Node head) {
		if(head ==null || head.next ==null)
		{
			return true;
		}
		
		//get Middle node for reverse the ll
		Node middle=  getmiddleNode(head);
		Node temp = middle.next;
		middle.next = reverse(temp);
		
		
		//for compare
		Node head1 = head;
		Node head2 = middle.next;
		
		while(head2 != null)
		{
			if(head1.data != head2.data)
			{
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		//repreate step 2
		
		temp = middle.next;
		middle.next = reverse(temp);
		return true;
		
	}

	private static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static  String convertToString(Node head)
	    {
	        StringBuilder s= new StringBuilder();
	        Node cur=head;
	        while(cur!=null)
	        {
	            s.append(Integer.toString(cur.data));
	            cur=cur.next;
	        }
	        return s.toString();
	    }
	    
	    
	   static boolean isPalindrome(Node head) 
	    {
	        if(head.next==null)
	            return true;   //LL of length 1
	            
	        String s1=convertToString(head);
	        
	        Node prev=null,curr=head;
	        while(curr!=null)
	        {
	            Node temp=curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=temp;
	        }
	        //prev is head now
	        
	        String s2=convertToString(prev);
	        
	        if(s1.equals(s2))
	            return true;
	        return false;
	    
	    }    

	public static void main(String[] args) {

		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(2);
		Node NodeThree = new Node(1);
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
		print(head);
		System.out.println(isPalindromApproch_2(head));
		System.out.println(isPalindrome(head));
		

	}

}
