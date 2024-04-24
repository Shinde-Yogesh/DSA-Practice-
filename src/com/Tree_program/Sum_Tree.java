package com.Tree_program;

import java.util.Scanner;

import com.Tree_program.Binary_Tree.Node;

public class Sum_Tree {

	private static class IsSumTreeFast {
		int height;
		boolean isBalanced;

		public IsSumTreeFast(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

// Function to calculate height and balance condition of a subtree
	private static IsSumTreeFast sum(Node root) {
		// Base case: If node is null, it's balanced with height 0
		if (root == null) {
			return new IsSumTreeFast(0, true);
		}
		// for the leafe

		if (root.left == null && root.right == null) {
			return new IsSumTreeFast(root.data, true);
		}

		// Recursively calculate heights and balance for left and right subtrees
		IsSumTreeFast leftResult = sum(root.left);
		IsSumTreeFast rightResult = sum(root.right);

		boolean left = leftResult.isBalanced;
		boolean right = rightResult.isBalanced;

		boolean cond = (root.data == (leftResult.height + rightResult.height)) ? true : false;

		if (left && right && cond) {
			return new IsSumTreeFast(2 * root.data, true);
		} else {
			return new IsSumTreeFast(0, false);
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
		System.out.println("Enter the data for inserting in left  " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

// Function to check whether a binary tree is balanced or not
	public boolean isSumTree(Node root) {
		// Get the result from the helper function
		IsSumTreeFast result = sum(root);

		// Return the balance status of the entire tree
		return result.isBalanced;
	}

	public static void main(String[] args) {
		Sum_Tree obj = new Sum_Tree();
		Node root = obj.buildTree();

		// 1 === true
		// 0 === false;

		if (obj.isSumTree(root)) {
			System.out.println("Given binary tree is a sum tree 1 ");
		} else {
			System.out.println("Given binary tree is not a sum tree .. 0");
		}
	}
}
