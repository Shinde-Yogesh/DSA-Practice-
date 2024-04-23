package com.Tree_program;

import java.util.Scanner;

import com.Tree_program.Binary_Tree.Node;

public class Check_For_Balaned_Tree {
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

	int height(Node node) {
		// base case
		if (node == null) {
			return 0;
		}

		// the formula for calculate
		// Max(leftNode ,rightNode)+1
		int left = height(node.left);
		int right = height(node.right);

		int ans = Math.max(left, right) + 1;
		return ans;
	}

	// Function to check whether a binary tree is balanced or not.
	boolean isBalanced(Node root) {
		// base case
		if (root == null) {
			return true;
		}

		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);

		int leftcall = height(root.left);
		int rightcall = height(root.right);
		boolean diff = false;
		if (leftcall - rightcall <= 1) {
			return !diff;
		}

		if (left && right && diff) {
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
		Check_For_Balaned_Tree obj = new Check_For_Balaned_Tree();
		Node root = obj.buildTree();
		System.out.println(obj.height(root));

		// 1 === true
		// 0 === false;

		if (obj.isBalanced(root)) {
			System.out.println("Tree is balanced 1 ");
		} else {
			System.out.println("Tree is not balanaced.. 0");
		}

	}
}
