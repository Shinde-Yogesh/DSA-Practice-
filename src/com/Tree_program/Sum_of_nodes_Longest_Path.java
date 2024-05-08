package com.Tree_program;

import java.util.Scanner;

public class Sum_of_nodes_Longest_Path {
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

	int maxSum = 0;
	int maxLength = 0;

	public int sumOfLongRootToLeafPath(Node root) {
		findMaxSum(root, 0, 0);
		return maxSum;
	}

	private void findMaxSum(Node root, int sum, int len) {
		if (root == null) {
			return;
		}

		sum += root.data;
		len++;

		if (root.left == null && root.right == null) {
			if (len > maxLength || (len == maxLength && sum > maxSum)) {
				maxLength = len;
				maxSum = sum;
			}
			return;
		}

		findMaxSum(root.left, sum, len);
		findMaxSum(root.right, sum, len);
	}

	public static void main(String[] args) {
		Sum_of_nodes_Longest_Path obj = new Sum_of_nodes_Longest_Path();
		Node root = obj.buildTree();
		System.out.println(obj.sumOfLongRootToLeafPath(root));
	}
}
