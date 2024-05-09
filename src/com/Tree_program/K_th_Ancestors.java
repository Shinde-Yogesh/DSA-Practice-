package com.Tree_program;

import java.util.Scanner;

public class K_th_Ancestors {
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

	int kthAncestor(Node root, int k, int node) {
		int[] ans = new int[] { -1 }; // Array to store the kth ancestor
		findKthAncestor(root, k, node, ans);
		return ans[0];
	}

	// Helper function to find the kth ancestor
	int findKthAncestor(Node root, int k, int node, int[] ans) {
		if (root == null)
			return 0;
		if (root.data == node)
			return 1;

		int left = findKthAncestor(root.left, k, node, ans);
		int right = findKthAncestor(root.right, k, node, ans);

		if (left != 0) {
			if (left == k)
				ans[0] = root.data; // Found the kth ancestor
			return 1 + left;
		}

		if (right != 0) {
			if (right == k)
				ans[0] = root.data; // Found the kth ancestor
			return 1 + right;
		}

		return 0;
	}

	public static void main(String[] args) {
		K_th_Ancestors obj = new K_th_Ancestors();
		Node root = obj.buildTree();
		System.out.println(obj.kthAncestor(root, 1, 3));
	}
}
