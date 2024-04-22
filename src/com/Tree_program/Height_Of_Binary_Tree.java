package com.Tree_program;

import java.util.Scanner;

public class Height_Of_Binary_Tree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	int height(Node node) {
		//base case
		if(node == null)
		{
			return 0;
		}
		
		//the formula for calculate 
		//Max(leftNode ,rightNode)+1
	int left = height(node.left);
	int right = height(node.right);
	
	int ans = Math.max(left, right)+1;
	return ans;
	}
	 public Node buildTree() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the data : ");
	        int data = sc.nextInt();

	        if (data == -1) {
	            return null; // Return null to indicate no node
	        }

	        Node root = new Node(data); // Create the root node

	        // Build left subtree
	        System.out.println("Enter the data for inserting in left node " + data);
	        root.left = buildTree();

	        // Build right subtree
	        System.out.println("Enter the data for inserting in right node " + data);
	        root.right = buildTree();

	        return root; // Return the constructed subtree
	    }
	public static void main(String[] args) {
		Height_Of_Binary_Tree obj = new Height_Of_Binary_Tree();
		 Node root = obj.buildTree();
		 System.out.println(obj.height(root));
		 

	}
}
