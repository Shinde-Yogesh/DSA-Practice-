package com.Tree_program;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Tree_Creation {
	static class Node {
		int data;
		Node left;
		Node right;

		// Constructor
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("Tree is Empty");
			return; // If the tree is empty
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static Node takeInput() {
		Scanner sc = new Scanner(System.in);
		Node root = null;

		System.out.println("Enter the data to create BST (-1 to end): ");
		while (true) {
			int data = sc.nextInt();
			if (data == -1) {
				break;
			}
			root = insertIntoBST(root, data);
		}
		sc.close();
		return root;
	}

	private static Node insertIntoBST(Node root, int data) {
		// Base case
		if (root == null) {
			root = new Node(data);
			System.out.println("Inserted " + data);
			return root;
		}

		if (data > root.data) {
			// Right part to work
			System.out.println("Insert " + data + " to right of " + root.data);
			root.right = insertIntoBST(root.right, data);
		} else {
			// Left side
			System.out.println("Insert " + data + " to left of " + root.data);
			root.left = insertIntoBST(root.left, data);
		}
		return root;
	}

	// for the Binary search code
	public static boolean searchInBST(Node root, int x) {
		/*	
		 		Approach 1
		 		
		 		
		 		
		 		
		 
			return false;
		}

		if (root.data == x) {
			return true;
		}

		if (root.data > x) {
			// left part
			return searchInBST(root.left, x);
		} else {
			return searchInBST(root.right, x);
		}
	*/
		
		Node temp = root;
		while(temp != null)
		{
			if(temp.data == x)
			{
				return true;
			}
			if(temp.data > x)
			{
				temp = temp.left;
			}else
			{
				temp = temp.right;
			}
		}
		return false;
	}
	
	static Node minValue(Node root)
	{
		Node temp = root;
		while(temp.left != null)
		{
			temp = temp.left;
		}
		return temp;
	}
	static Node maxValue(Node root)
	{
		Node temp = root;
		while(temp.right != null)
		{
			temp = temp.right;
		}
		return temp;
	}
	
	// Delete the node from Tree
	public static Node  deleteFromBST(Node root, int val)
	{
		//base case
		if(root == null)
		{
			return null;
		}
		
		if(root.data == val)
		{
			//for the 0 child
			if((root.left ==null) && (root.right == null))
			{
				 root = null;
				return root;
			}
			// for the 1 child
			
			//here two cases one for the left and other for the right
			//for the left side 
			if((root.left != null) && (root.right == null))
			{
				Node temp = root.left;
				root = null;
				return temp;
			}
			
			//for the right child if it is not null
			if((root.left == null)&& (root.right != null))
			{
				Node temp = root.right;
				root= null;
				return temp;
			}
			
			// for the 2 child
			
			//two child have
			
			if((root.left != null ) && (root.right != null))
			{
				int mini = minValue(root.right).data;
				root.data = mini;
				root.right = deleteFromBST(root.right, mini);
				return root;
			}
			
		}
		else if(root.data > val)
		{
			//left call because the value is small
			root.left = deleteFromBST(root.left, val);
			return root;
		}
		else
		{
			//right call because the value is small
			root.right = deleteFromBST(root.right, val);
			return root;
		}
		return root;
	}

	public static void main(String[] args) {
		System.out.println("Enter the data to create BST:");
		Node root = takeInput();

		System.out.println("Printing the BST:");
		levelOrderTraversal(root);
		
		System.out.println();
		
		System.out.println("The min value : "+minValue(root).data);
		System.out.println("The max value : "+maxValue(root).data);
		
		
		System.out.println("For the delete the node ");
		deleteFromBST(root, 30);
		
		System.out.println("Printing the BST:");
		levelOrderTraversal(root);
	}
}

/* 		
						Tree for the deleteNode
						
						      50
						  /	        \
						30		     70
				       /   \        /   \
				    20    	40	   60    80
			


*/