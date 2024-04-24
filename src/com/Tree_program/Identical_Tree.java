package com.Tree_program;

import java.util.Scanner;

public class Identical_Tree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	 //Function to check if two trees are identical.
		boolean isIdentical(Node root1, Node root2) {
			// Code Here
			// check for the base case

			if (root1 == null && root2 == null) {
				return true;
			}

			if (root1 != null && root2 == null) {
				return false;
			}
			if (root1 == null && root2 != null) {
				return false;
			}

			boolean left = isIdentical(root1.left, root2.left);
			boolean right = isIdentical(root1.right, root2.right);

			boolean value =  (root1.data == root2.data) ? true : false;
			if (left && right && value) {
				return true;
			} else {
				return false;
			}
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
		Identical_Tree obj = new Identical_Tree();
		 Node root1 = obj.buildTree();
		 Node root2 = obj.buildTree();
		 System.out.println(obj.isIdentical(root1,root2));
		 

	}
}
//1 2 N 3
//1 3 2
