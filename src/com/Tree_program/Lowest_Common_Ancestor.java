package com.Tree_program;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.Scanner;

public class Lowest_Common_Ancestor {
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

	public Node buildTree() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data : ");
		int data = sc.nextInt();

		if (data == -1) {
			return null; // Return null to indicate no node
		}

		Node root = new Node(data); // Create the root node

		// Build left subtree
		System.out.println("Enter the data for inserting in left " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right  " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	Node lca(Node root, int n1, int n2) {
		// base case
		if (root == null) {
			return null;
		}

		// main case to find n1 and n2
		if (root.data == n1 || root.data == n2) {
			return root;
		}

		Node leftAns = lca(root.left, n1, n2);
		Node rightAns = lca(root.right, n1, n2);

		// test cases

		if (leftAns != null && rightAns != null) {
			return root;
		} else if (leftAns != null && rightAns == null) {
			return leftAns;
		} else if (leftAns == null && rightAns != null) {
			return rightAns;
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		Lowest_Common_Ancestor obj = new Lowest_Common_Ancestor();
		Node root = obj.buildTree();
		System.out.println(obj.lca(root, 3, 4).data);
	}
}/*
						n1 = 3 , n2 = 4
						5    
						/    
						2  
						/ \  
						3   4
						Output: 2
						Explanation:
						LCA of 3 and 4 is 2. 
*/