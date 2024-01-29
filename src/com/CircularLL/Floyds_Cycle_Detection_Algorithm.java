package com.CircularLL;

import java.util.HashSet;

public class Floyds_Cycle_Detection_Algorithm {
		private static Node startedNode;


		//Solution One
	
	public static class Node {
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public static void isLoopPresent(Node head)
	{
		// creating two pointer
		Node slowPointer = head;
		Node fastPointer = head;
		
		//loop present make first false;
		boolean loopPresent = false;
		//base case 
		
		while(fastPointer != null)
		{
			fastPointer = fastPointer.next;
			
			// for the the two node test case
			if(fastPointer != null)
			{
				fastPointer = fastPointer.next;
				slowPointer = slowPointer.next;
			}
			
			
			//if both node match at one location
			if(fastPointer == slowPointer)
			{
				loopPresent = true;
				break;
			}
		}
		
		if(loopPresent)
		{
			System.out.println("Cycle is Present");
		}
		else
		{
			System.out.println("Cycle is Not Present");
		}
	}
	
	public static boolean cycleDetect(Node head)
	{
		if(head == null)
		    return false;
		
		// traverse the node
		Node temp = head;
		
		//create visited HashSet 
		 HashSet<Node> visited = new HashSet<>();
		 while(temp != null)
		 {
			 if(visited.contains(temp))
			 {
				 System.out.println("Node present at the node : "+temp.data);
				 return true;
			 }	 
			 // add the next node
			 visited.add(temp);
			 
			 //move the next node
			 temp = temp.next;
		 }
		 return false;
	}
	
	
	// for the fistNode in cycle using 
	//floydsDetection method and get started Node
	static //for the staring node return 
	
	Node floydsDetection(Node head)
	{
		if(head == null) return null;
		
		Node fastpointer= head;
		Node slowPointer = head;
		
		while(slowPointer != null && fastpointer != null)
		{
			fastpointer = fastpointer.next;
			
			if(fastpointer != null)
			{
				fastpointer = fastpointer.next;
			}
			
			slowPointer = slowPointer.next;
			
			if(slowPointer == fastpointer)
			{
				return slowPointer;
			}
		}
		return null;
	}
	
	 static Node getStartedNode(Node head)
	{
		if(head == null) return null;
		
		Node intersectionNode = floydsDetection(head);
		Node slow = head;
		
		while(slow != intersectionNode)
		{
			slow = slow.next;
			intersectionNode = intersectionNode.next;
		}
		return slow;
	}
	 
	 // cycle remove 
	 
	 static void removeloop(Node head)
	 {
		 if(head == null)
		 {
			  return;
		 }
		 
		 Node startofNode = getStartedNode(head);
		 
		 //temp node 
		 Node temp = startofNode;
		 while(temp.next != startofNode)
		 {
			 temp = temp.next;
		 }
		 temp.next = null;
	 }

	 //printing the node
	 public static void print(Node head) {
		 
	        if (head == null) {
	            System.out.println("Circular Linked List is empty.");
	            return;
	        }

	        Node current = head;
	        do {
	        	if(current == null)  return ;
	            System.out.print(current.data + " "+" -> ");
	            current = current.next;
	        } while (current != head);
	        System.out.println("HEAD");
	        System.out.println();
	    }

	public static void main(String[] args) {
		
		Node NodeOne = new Node(1);
		Node NodeTwo = new Node(2);
		Node NodeThree = new Node(3);
		Node NodeFour = new Node(4);
		Node NodeFive = new Node(5);
		Node NodeSix = new Node(6);
		Node NodeSeven = new Node(7);
		Node NodeEight = new Node(8);
		
	   
		Node head = NodeOne;
		 
		NodeOne.next = NodeTwo;
		NodeTwo.next = NodeThree;
	    NodeThree.next = NodeFour;
	    NodeFour.next = NodeFive;
	    NodeFive.next = NodeSix;
	    NodeSix.next = NodeSeven;
	    NodeSeven.next = NodeEight;
	    NodeEight.next = NodeThree;
	    
	    //calling method to evaluate
//	    isLoopPresent(head);
//	    System.out.println(cycleDetect(head));
//	    System.out.println(cycleDetect(head));
	    System.out.println("Cycle present at the node : "+floydsDetection(head).data);
	
	    Node  startedNode = getStartedNode(head);
	    System.out.println("Cycle Starting Node  present at the : "+ startedNode.data);
	    removeloop(head);
	    
	    print(head);
	  
	  
	}
	
	
	
	
	
	
	
	/*
	//Solution Second //Optimization

    public static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node getStartNodeOfLoopInLinklist(Node startNode) {
        Node tortoisePointer = startNode; // Initially ptr1 is at starting location.
        Node harePointer = startNode; // Initially ptr2 is at starting location.
        // If ptr2 encounters NULL, it means there is no Loop in Linked list.
        while (harePointer != null && harePointer.next != null) {
            tortoisePointer = tortoisePointer.next; // ptr1 moving one node at at time
            harePointer = harePointer.next.next; // ptr2 moving two nodes at at time
            // if ptr1 and ptr2 meets, it means linked list 
//contains loop.
            if (tortoisePointer == harePointer) {
                //After meet, moving tortoisePointer to start node of list.
                tortoisePointer = startNode;

                //Moving tortoisePointer and harePointer one node at a time till the time they meet at common point. 
                while (tortoisePointer != harePointer) {
                    tortoisePointer = tortoisePointer.next;
                    harePointer = harePointer.next;
                }

                //returning start node of loop.
                return tortoisePointer;
            }
        }
        // this condition will arise when there is no loop in list.
        return null;
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.next = (n2);
        n2.next = (n3);
        n3.next = (n4);
        n4.next = (n5);
        n5.next = (n6);
        n6.next = (n7);
        n7.next = (n8);
        n8.next = (n6);

        Node loopNode = getStartNodeOfLoopInLinklist(n1);
        if (loopNode == null) {
            System.out.println("Loop not present");
        } else {
            System.out.println("Start node of Loop is :" + loopNode.data);
        }
    }*/
  //  Time complexity is O(N) where N is the number of nodes in the linked list, space complexity is O(1) as you use only two pointers.



}
											/*
											Creating a Linked List of eight nodes
											having a loop at (node 3)
											
											HEAD-->1-->2-->3-->4-->5
											              ^       |
											              |       v
											              8<--7<--6
											
											*/
