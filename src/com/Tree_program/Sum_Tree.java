package com.Tree_program;

import java.util.Scanner;

import com.Tree_program.Binary_Tree.Node;

public class Sum_Tree {

	// Define a class to hold the result of the Sum Tree check
	private static class SumTreeInfo {
		int sum;
		boolean isSumTree;

		public SumTreeInfo(int sum, boolean isSumTree) {
			this.sum = sum;
			this.isSumTree = isSumTree;
		}
	}

	// Function to check if a binary tree is a Sum Tree
	private static SumTreeInfo isSumTree(Node root) {
		// Base case: If node is null, it's a sum tree with sum 0
		if (root == null) {
			return new SumTreeInfo(0, true);
		}

		// If it's a leaf node, it's considered a sum tree with its own value
		if (root.left == null && root.right == null) {
			return new SumTreeInfo(root.data, true);
		}

		// Recursively calculate sum and check sum tree property for left and right
		// subtrees
		SumTreeInfo leftInfo = isSumTree(root.left);
		SumTreeInfo rightInfo = isSumTree(root.right);

		// Calculate sum of current node
		int currentSum = root.data;

		// Check if current node's value equals the sum of its left and right subtrees
		boolean isCurrentSumTree = (currentSum == (leftInfo.sum + rightInfo.sum));

		// Check if both left and right subtrees are sum trees
		boolean isSubtreeSumTree = leftInfo.isSumTree && rightInfo.isSumTree;

		// Determine if current node forms a sum tree
		boolean isSumTree = isSubtreeSumTree && isCurrentSumTree;

		// Calculate the total sum of the subtree rooted at the current node
		int totalSum = currentSum + leftInfo.sum + rightInfo.sum;

		return new SumTreeInfo(totalSum, isSumTree);
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

	public static void main(String[] args) {
		Sum_Tree obj = new Sum_Tree();
		Node root = obj.buildTree();

		// 1 === true
		// 0 === false;
		System.out.println(isSumTree(root).isSumTree);
	}
}
