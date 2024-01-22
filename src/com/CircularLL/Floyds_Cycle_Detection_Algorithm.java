package com.CircularLL;

public class Floyds_Cycle_Detection_Algorithm {
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
	    isLoopPresent(head);
	}

}
											/*
											Creating a Linked List of eight nodes
											having a loop at (node 3)
											
											HEAD-->1-->2-->3-->4-->5
											              ^       |
											              |       v
											              8<--7<--6
											
											*/
